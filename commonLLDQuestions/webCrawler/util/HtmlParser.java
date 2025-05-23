package commonLLDQuestions.webCrawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {

    public HtmlParser(){

    }

    public static List<String> extractLinks(String html, String baseUrl) {
        List<String> links = new ArrayList<>();
        Document doc = Jsoup.parse(html, baseUrl);
        for (Element element : doc.select("a[href]")) {
            String href = element.attr("abs:href");
            if (!href.isEmpty()) {
                links.add(href);
            }
        }
        return links;
    }
}
