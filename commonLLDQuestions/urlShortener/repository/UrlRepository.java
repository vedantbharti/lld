package commonLLDQuestions.urlShortener.repository;

import commonLLDQuestions.urlShortener.entities.Url;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class UrlRepository {

    private ConcurrentMap<String, Url> urls;

    private UrlRepository(){
        urls = new ConcurrentHashMap<>();
    }

    private static class Initializer {
        private static final UrlRepository INSTANCE = new UrlRepository();
    }

    public static UrlRepository getInstance() {
        return Initializer.INSTANCE;
    }

    public void addUrl(Url url) {
        urls.put(url.getLongUrl(),url);
    }

    public Url getUrl(String longUrl) {
        return urls.get(longUrl);
    }

    public boolean checkIfShortUrlAlreadyExists(String shorUrl) {
        return urls.values().stream().anyMatch(url -> url.getShortUrl().equals(shorUrl));
    }
}
