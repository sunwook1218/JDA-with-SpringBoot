package bot.discord.ww.core.message.icon;

import bot.discord.ww.common.BaseService;
import bot.discord.ww.common.JDAContextHolder;
import bot.discord.ww.common.string.ChannelId;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SendIconService extends BaseService {

    private JDA jda = JDAContextHolder.getInstance().getJda();

    private DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

    private static final String BASE_DIRECTORY_100 = "file:src/main/resources/static/img/icon_100/";

    public void shy(MessageReceivedEvent event) throws Exception {

        MessageChannel targetChannel = getTargetChannel(event, jda.getTextChannelById(ChannelId.TSU_CHANNEL));

        File icon = defaultResourceLoader.getResource(BASE_DIRECTORY_100 + "1.jpg").getFile();

        targetChannel.sendFile(icon).queue();
    }

    private MessageChannel getTargetChannel(MessageReceivedEvent event, MessageChannel defaultChannel) {
        if (event == null) {
            return defaultChannel;
        } else {
            return event.getChannel();
        }
    }


}
