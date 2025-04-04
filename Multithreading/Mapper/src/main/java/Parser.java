import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private String url;
    private List<String> urls = new ArrayList<>();
    private Document document;
    private Elements elements;

    public Parser(String url) {
        this.url = url;
        parse();
    }

    private void parse() {

        try {
            Thread.sleep(400);
            if (200 == Jsoup.connect(url).ignoreContentType(true).followRedirects(false).execute().statusCode()) {
                Thread.sleep(300);
                document = Jsoup.connect(url).ignoreContentType(true).get();
                elements = document.select("a");
                for (Element element : elements) {
                    String absLink = element.absUrl("href");
                        if (!(urls.contains(absLink) && absLink.equals(url)) && !absLink.contains("#")) {
                            urls.add(absLink);
                        }
                    }
                }
            } catch(IOException e){
                throw new RuntimeException(e);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
    }

    public List<String> getUrls() {
        return urls;
    }
}
