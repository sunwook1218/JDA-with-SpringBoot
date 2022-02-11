package sun.bot.core.search;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.bot.core.domain.character.Character;
import sun.bot.core.domain.character.CharacterMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScrapUtil {

    public static Character character(String characterName) throws Exception {

            Document document = Jsoup.connect("https://loawa.com/char/" + characterName).get();

            return CharacterMapper.documentToCharacter(document);
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
