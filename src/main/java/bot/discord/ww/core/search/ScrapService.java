package bot.discord.ww.core.search;

import bot.discord.ww.core.domain.character.Character;
import bot.discord.ww.core.domain.character.CharacterMapper;
import bot.discord.ww.core.domain.island.Island;
import bot.discord.ww.core.domain.island.IslandMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ScrapService {

    private final CharacterMapper characterMapper;

    private final IslandMapper islandMapper;

    public ScrapService(CharacterMapper characterMapper, IslandMapper islandMapper) {
        this.characterMapper = characterMapper;
        this.islandMapper = islandMapper;
    }

    /**
     * ScrapUtil do Search lostArk data infos from https://loawa.com/ and it provides java object by mapping document data
     */

    private static final String urlBase = "https://loawa.com/";

    public Character getCharacterByName(String characterName) throws Exception {

        Document document = Jsoup.connect(urlBase + "char/" + characterName).get();

        return characterMapper.documentToCharacter(document);
    }

    public Island getIsland() throws Exception {

        Document document = Jsoup.connect(urlBase).get();

        return islandMapper.documentToIsland(document);
    }



}
