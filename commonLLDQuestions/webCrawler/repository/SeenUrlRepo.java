package commonLLDQuestions.webCrawler.repository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SeenUrlRepo {

    private final Set<String> seenUrls;

    private SeenUrlRepo(){
        this.seenUrls = ConcurrentHashMap.newKeySet();
    }

    private static class Initializer {
        private static final SeenUrlRepo INSTANCE = new SeenUrlRepo();
    }

    public static SeenUrlRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public boolean urlAlreadySeen(String url) {
        return seenUrls.contains(url);
    }

    public synchronized void markUrlSeen(String url) {
        seenUrls.add(url);
    }
}
