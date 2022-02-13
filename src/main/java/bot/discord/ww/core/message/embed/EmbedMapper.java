package bot.discord.ww.core.message.embed;

import bot.discord.ww.core.domain.character.Character;
import bot.discord.ww.core.domain.island.Island;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class EmbedMapper {

    public <T> MessageEmbed usage(T object) {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Title");

        eb.setColor(Color.red);
        eb.setColor(new Color(0xF40C0C));
        eb.setColor(new Color(255, 0, 54));

        eb.setDescription("상세 정보");
        eb.addField("Title of field", "", false);
        eb.addBlankField(false);
        eb.setAuthor("name", null, "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
        eb.setFooter("Text", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");
        eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");
        eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

        return eb.build();
    }

    public MessageEmbed mkCharacterEmbed(Character character) {

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("로아와 - " + character.getCharacterName(), character.getSearchUrl());
        eb.setColor(Color.red);
        eb.setColor(new Color(0xF40C0C));
        eb.setColor(new Color(255, 0, 54));

        eb.addField("캐릭터 정보", character.getInfoForEmbedField(), false);
        eb.addField("각인", character.getAengraveForEmbedField(), false);
        eb.addField("보석", character.getJewelForEmbedField(), false);

        eb.addBlankField(false);

        return eb.build();
    }

    public MessageEmbed mkIslandEmbed(Island island) {

        EmbedBuilder eb = new EmbedBuilder();

        return eb.build();
    }

}
