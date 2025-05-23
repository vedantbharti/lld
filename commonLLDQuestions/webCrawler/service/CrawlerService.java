package commonLLDQuestions.webCrawler.service;

import commonLLDQuestions.webCrawler.repository.ContentRepo;
import commonLLDQuestions.webCrawler.repository.SeenUrlRepo;
import commonLLDQuestions.webCrawler.repository.UrlFrontierRepo;
import commonLLDQuestions.webCrawler.util.HashGenerator;
import commonLLDQuestions.webCrawler.util.HtmlDownloader;
import commonLLDQuestions.webCrawler.util.HtmlParser;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrawlerService {

    private final ContentRepo contentRepo;
    private final SeenUrlRepo seenUrlRepo;
    private final UrlFrontierRepo urlFrontierRepo;
    private final ExecutorService executorService;
    private final HashGenerator hashGenerator;

    public CrawlerService(List<String> seedUrls, int threadCount) {
        this.contentRepo = ContentRepo.getInstance();
        this.seenUrlRepo = SeenUrlRepo.getInstance();
        this.urlFrontierRepo = UrlFrontierRepo.getInstance();
        this.hashGenerator = new HashGenerator();
        this.executorService = Executors.newFixedThreadPool(threadCount);
        seedUrls.forEach(seedurl -> urlFrontierRepo.addUrl(seedurl));
    }

    public void start() {
        while (!urlFrontierRepo.isEmpty()) {
            String url = urlFrontierRepo.getNextUrl();
            if (url != null && !seenUrlRepo.urlAlreadySeen(url)) {
                seenUrlRepo.markUrlSeen(url);
                executorService.submit(new CrawlTask(url));
            }
        }
        executorService.shutdown();
    }

    private class CrawlTask implements Runnable {

        private String url;
        protected CrawlTask(String url){
            this.url = url;
        }

        @Override
        public void run() {
            System.out.println("this website is crawled by thread: " + Thread.currentThread().getName());
            try {
                String html = HtmlDownloader.download(url);
                String htmlHash = hashGenerator.generateHash(html);

                if (contentRepo.isContentSeen(htmlHash)) {
                    System.out.println("Duplicate content skipped: " + url);
                    return;
                }

                contentRepo.addContent(htmlHash);
                System.out.println("Crawled: " + url);

                for (String extractedUrl : HtmlParser.extractLinks(html, url)) {
                    System.out.println("extracted url is: " + extractedUrl);
                    if (!seenUrlRepo.urlAlreadySeen(extractedUrl)) {
                        urlFrontierRepo.addUrl(extractedUrl);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error crawling " + url + ": " + e.getMessage());
            }
        }
    }


}
