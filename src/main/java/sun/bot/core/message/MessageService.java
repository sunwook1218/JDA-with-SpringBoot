package sun.bot.core.message;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import sun.bot.common.BaseService;
import sun.bot.core.domain.character.Character;
import sun.bot.core.message.embed.EmbedMapper;
import sun.bot.core.search.ScrapUtil;

import java.awt.*;
import java.util.Map;

public class MessageService extends BaseService {

    private static MessageService instance = null;

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    public void service(MessageReceivedEvent event) throws Exception {

        String contentRaw = event.getMessage().getContentRaw();

        if(contentRaw.startsWith("ww ")){

            String[] messages = contentRaw.split(" ");

            String command = messages[1];
            String content = messages[2];

            if(command.equals("s")) {

                logger.debug("command : {}, content : {}", command, content);

                Character character = ScrapUtil.character(content);
                MessageEmbed messageEmbed = EmbedMapper.mkCharacterEmbed(character);

                event.getChannel().sendMessageEmbeds(messageEmbed).queue();

            }

        } else {






        }

    }


}
