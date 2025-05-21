package commonLLDQuestions.urlShortener;

import commonLLDQuestions.urlShortener.exception.ShortUrlNotFoundException;
import commonLLDQuestions.urlShortener.service.UrlShortenerService;
import commonLLDQuestions.urlShortener.util.HashStrategy;
import commonLLDQuestions.urlShortener.util.SHA256HashStrategy;

public class URLShortener {

    public static void main(String[] args) {

        HashStrategy sha256HashStrategy = new SHA256HashStrategy();

        UrlShortenerService urlShortenerService = new UrlShortenerService(sha256HashStrategy);

        String longUrl = "www.longurl.com/abbcccdddd/efghijkl/mnopq";

        String shortUrl = urlShortenerService.generateShortUrl(longUrl);

        try {
            String generatedShortUrl = urlShortenerService.fetchShortUrl(longUrl);
            System.out.println("the generated short url for " + longUrl + " is " + generatedShortUrl);

        } catch (ShortUrlNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}
