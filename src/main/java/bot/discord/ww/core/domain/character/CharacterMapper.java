package bot.discord.ww.core.domain.character;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterMapper {

    public Character documentToCharacter(Document document) {

        Character.CharacterBuilder builder = Character.builder();
        builder.characterName(document.select(".char-title").text());
        builder.searchUrl("https://loawa.com/char/" + document.select(".char-title").text());

        Elements characterInfoElements = document.select(".char-info dd");

        for (int i = 0; i < characterInfoElements.size(); i++) {

            Element element = characterInfoElements.get(i);

            switch (i) {
                case 0:
                    builder.serverName(element.text());
                    break;
                case 1:
                    builder.guildName(element.text());
                    break;
                case 2:
                    builder.className(element.text());
                    break;
                case 3:
                    builder.titleName(element.text());
                    break;
                case 4:
                    builder.battleLevel(element.text());
                    break;
                case 5:
                    builder.itemLevel(element.text());
                    break;
                case 6:
                    builder.expeditionLevel(element.text());
                    break;
                case 7:
                    builder.pvpClass(element.text());
                    break;
                case 8:
                    builder.wisdomInfo(element.text());
                    break;

            }
        }

        Elements aengraveListElements = document.select(".char-equip-aengrave div img");

        List<String> collect = aengraveListElements.stream().map(ele -> ele.text().replace("&nbsp;", "")).collect(Collectors.toList());
        builder.equipAengraveList(collect);

        return builder.build();
    }
}
