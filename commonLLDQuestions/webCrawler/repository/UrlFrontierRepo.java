package commonLLDQuestions.webCrawler.repository;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class UrlFrontierRepo {

    private final Queue<String> urlFrontierQueue;

    private UrlFrontierRepo(){
        this.urlFrontierQueue = new ConcurrentLinkedQueue<>();
    }

    private static class Initializer {
        private static final UrlFrontierRepo INSTANCE = new UrlFrontierRepo();
    }

    public static UrlFrontierRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public void addUrl(String url) {
        urlFrontierQueue.offer(url);
    }

    public String  getNextUrl() {
        return urlFrontierQueue.poll();
    }

    public boolean isEmpty(){
        return urlFrontierQueue.isEmpty();
    }
}
