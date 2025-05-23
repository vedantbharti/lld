package commonLLDQuestions.webCrawler.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HtmlDownloader {

    public HtmlDownloader(){

    }

    public static String download(String url) throws IOException {
        try (InputStream input = new URL(url).openStream();
             Scanner scanner = new Scanner(input, StandardCharsets.UTF_8)) {
            return scanner.useDelimiter("\\A").next();
        }
    }
}
