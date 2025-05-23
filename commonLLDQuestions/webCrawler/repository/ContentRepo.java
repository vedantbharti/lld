package commonLLDQuestions.webCrawler.repository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ContentRepo {

    private final Set<String> contentHashSet;

    private ContentRepo() {
        contentHashSet = ConcurrentHashMap.newKeySet();
    }

    private static class Initializer {
        private static final ContentRepo INSTANCE = new ContentRepo();
    }

    public static ContentRepo getInstance() {
        return Initializer.INSTANCE;
    }

    public boolean isContentSeen(String contentHash) {
        return contentHashSet.contains(contentHash);
    }

    public void addContent(String contentHash) {
        contentHashSet.add(contentHash);
    }

}
