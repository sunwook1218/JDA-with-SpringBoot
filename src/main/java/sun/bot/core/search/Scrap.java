package sun.bot.core.search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scrap {

    public static Map<String, String> scrapCharacter(String characterName) {

        Map<String, String> result = new HashMap<>();

        try {
            Document doc = Jsoup.connect("https://loawa.com/char/" + characterName).get();

            String text = doc.select(".char-info dd").text();

            result.put("document", doc.text());
            result.put("level", text);

        } catch(Exception e) {

            result.put("exception", e.getMessage());

        }

        return result;


    }

    public static Map<String, Object> best(Integer number) {

        Map<String, Object> result = new HashMap<>();

        try {

            Document doc = Jsoup.connect("https://arca.live/b/lostark?mode=best").get();

            Elements select = doc.select(".title");

            List<String> titles = new ArrayList<>();

            for(Element e : select) {
                titles.add(e.text());
            }

            result.put("titles", titles);

        } catch (Exception e) {
            result.put("error", e.getMessage());
        }

        return result;

    }



}
