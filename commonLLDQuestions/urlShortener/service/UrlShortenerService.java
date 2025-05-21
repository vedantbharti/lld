package commonLLDQuestions.urlShortener.service;

import commonLLDQuestions.urlShortener.entities.Url;
import commonLLDQuestions.urlShortener.repository.UrlRepository;
import commonLLDQuestions.urlShortener.util.HashStrategy;

public class UrlShortenerService {

    private HashStrategy hashStrategy;
    private UrlRepository urlRepository;

    private static final String BASE_URL = "www.shorturl.com/";
    private static final String seedString = "/AlphaBetaGamma";

    public UrlShortenerService(HashStrategy hashStrategy) {
        this.hashStrategy = hashStrategy;
        this.urlRepository = UrlRepository.getInstance();
    }

    public String generateShortUrl(String longUrl) {
        //generate shortUrl
        while(true) {
            String generatedHash = hashStrategy.generateHash(longUrl);
            String generatedShortUrl = BASE_URL + generatedHash;
            boolean shortUrlAlreadyExists = urlRepository.checkIfShortUrlAlreadyExists(generatedShortUrl);
            if (shortUrlAlreadyExists) {
                longUrl = longUrl + seedString;
            } else {
                urlRepository.addUrl(new Url(longUrl,generatedShortUrl));
                return generatedShortUrl;
            }
        }

    }

    public String fetchShortUrl(String longUrl) {
        return urlRepository.getUrl(longUrl).getShortUrl();
    }
}
