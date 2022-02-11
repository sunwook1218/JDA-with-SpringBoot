package sun.bot.core.message.embed;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import sun.bot.core.domain.character.Character;

import java.awt.*;

public class EmbedMapper {

    public static MessageEmbed mkCharacterEmbed(Character character) {


        EmbedBuilder eb = new EmbedBuilder();

        /*
            Set the title:
            1. Arg: title as string
            2. Arg: URL as string or could also be null
         */
        eb.setTitle("로아와 - " + character.getCharacterName(), character.getSearchUrl());

        /*
            Set the color
         */
        eb.setColor(Color.red);
        eb.setColor(new Color(0xF40C0C));
        eb.setColor(new Color(255, 0, 54));

        /*
            Set the text of the Embed:
            Arg: text as string
         */
//        eb.setDescription("상세 정보");

        /*
            Add fields to embed:
            1. Arg: title as string
            2. Arg: text as string
            3. Arg: inline mode true / false
         */
        eb.addField("Title of field", character.toString(), false);

        /*
            Add spacer like field
            Arg: inline mode true / false
         */
        eb.addBlankField(false);

        /*
            Add embed author:
            1. Arg: name as string
            2. Arg: url as string (can be null)
            3. Arg: icon url as string (can be null)
         */
//        eb.setAuthor("name", null, "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");

        /*
            Set footer:
            1. Arg: text as string
            2. icon url as string (can be null)
         */
//        eb.setFooter("Text", "https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/zekroBot_Logo_-_round_small.png");

        /*
            Set image:
            Arg: image url as string
         */
//        eb.setImage("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

        /*
            Set thumbnail image:
            Arg: image url as string
         */
//        eb.setThumbnail("https://github.com/zekroTJA/DiscordBot/blob/master/.websrc/logo%20-%20title.png");

        return eb.build();

    }

}
