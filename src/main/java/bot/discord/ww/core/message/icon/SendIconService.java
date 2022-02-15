package bot.discord.ww.core.message.icon;

import bot.discord.ww.common.base.BaseService;
import bot.discord.ww.common.jda.JDAContextHolder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class SendIconService extends BaseService {

    private JDA jda = JDAContextHolder.getInstance().getJda();

    private DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();

    private static final String BASE_DIRECTORY_100 = "file:src/main/resources/static/img/icon_100/";

    public void shy(MessageChannel channel) throws Exception {
        sendImage(channel, "1.jpg");
    }

    public void jjong_jjong(MessageChannel channel) throws Exception {
        sendImage(channel, "2.jpg");
    }

    public void three_dots(MessageChannel channel) throws Exception {
        sendImage(channel, "3.jpg");
    }

    public void chu(MessageChannel channel) throws Exception {
        sendImage(channel, "4.jpg");
    }

    public void bi_chu(MessageChannel channel) throws Exception {
        sendImage(channel, "5.jpg");
    }

    public void denture(MessageChannel channel) throws Exception {
        sendImage(channel, "6.jpg");
    }

    public void jjin(MessageChannel channel) throws Exception {
        sendImage(channel, "7.jpg");
    }

    public void rice(MessageChannel channel) throws Exception {
        sendImage(channel, "8.jpg");
    }

    public void cute(MessageChannel channel) throws Exception {
        sendImage(channel, "9.jpg");
    }

    public void hanging(MessageChannel channel) throws Exception {
        sendImage(channel, "10.jpg");
    }

    public void groud_gif(MessageChannel channel) throws Exception {
        sendImage(channel, "11.gif");
    }

    public void portal(MessageChannel channel) throws Exception {
        sendImage(channel, "12.jpg");
    }

    public void i_am_here(MessageChannel channel) throws Exception {
        sendImage(channel, "13.jpg");
    }

    private void sendImage(MessageChannel channel, String fileName) throws Exception {
        File icon = defaultResourceLoader.getResource(BASE_DIRECTORY_100 + fileName).getFile();
        channel.sendFile(icon).queue();
    }

}
