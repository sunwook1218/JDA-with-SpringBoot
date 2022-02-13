package bot.discord.ww.core.scheduler;

import bot.discord.ww.common.JDAContextHolder;
import bot.discord.ww.common.string.ChannelId;
import bot.discord.ww.core.message.icon.SendIconService;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Component
public class MessageScheduler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private JDA jda = JDAContextHolder.getInstance().getJda();

    private final ServletContext servletContext;

    private final SendIconService sendIconService;

    public MessageScheduler(ServletContext servletContext, SendIconService sendIconService) {
        this.servletContext = servletContext;
        this.sendIconService = sendIconService;
    }

    @Scheduled(cron = "0 55 * * * *")
    public void sendMessage() {

        jda.getTextChannelById(ChannelId.TSU_CHANNEL).sendMessage(jda.getUserById("194151264316162050").getAsMention() + " 정각 5분 전입니다.").queue();

    }

    @Scheduled(cron = "0 * * * * *")
    public void sendImgIcon() throws Exception {

        sendIconService.shy(null);

    }

}
