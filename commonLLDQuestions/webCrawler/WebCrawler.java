package commonLLDQuestions.webCrawler;

import commonLLDQuestions.webCrawler.service.CrawlerService;

import java.util.List;

public class WebCrawler {

    public static void main(String[] args) {

        List<String> seeds = List.of("https://example.com", "https://example1.com");
        CrawlerService crawlerService = new CrawlerService(seeds,4);
        crawlerService.start();

    }
}
