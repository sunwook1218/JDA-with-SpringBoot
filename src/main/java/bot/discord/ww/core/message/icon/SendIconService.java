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
        sendImage(event, "1.jpg");
    }

    public void jjong_jjong(MessageReceivedEvent event) throws Exception {
        sendImage(event, "2.jpg");
    }

    public void three_dots(MessageReceivedEvent event) throws Exception {
        sendImage(event, "3.jpg");
    }

    public void chu(MessageReceivedEvent event) throws Exception {
        sendImage(event, "4.jpg");
    }

    public void bi_chu(MessageReceivedEvent event) throws Exception {
        sendImage(event, "5.jpg");
    }

    public void denture(MessageReceivedEvent event) throws Exception {
        sendImage(event, "6.jpg");
    }

    public void jjin(MessageReceivedEvent event) throws Exception {
        sendImage(event, "7.jpg");
    }

    public void rice(MessageReceivedEvent event) throws Exception {
        sendImage(event, "8.jpg");
    }

    public void cute(MessageReceivedEvent event) throws Exception {
        sendImage(event, "9.jpg");
    }

    public void hanging(MessageReceivedEvent event) throws Exception {
        sendImage(event, "10.jpg");
    }

    public void groud_gif(MessageReceivedEvent event) throws Exception {
        sendImage(event, "11.gif");
    }

    public void portal(MessageReceivedEvent event) throws Exception {
        sendImage(event, "12.jpg");
    }

    public void i_am_here(MessageReceivedEvent event) throws Exception {
        sendImage(event, "13.jpg");
    }

    private void sendImage(MessageReceivedEvent event, String fileName) throws Exception {
        MessageChannel targetChannel = getTargetChannel(event, jda.getTextChannelById(ChannelId.TSU));
        File icon = defaultResourceLoader.getResource(BASE_DIRECTORY_100 + fileName).getFile();
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
