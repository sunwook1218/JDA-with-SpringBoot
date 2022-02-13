package bot.discord.ww.core.scheduler;

import bot.discord.ww.common.JDAContextHolder;
import bot.discord.ww.common.string.ChannelId;
import bot.discord.ww.common.string.UserId;
import bot.discord.ww.core.message.icon.SendIconService;
import net.dv8tion.jda.api.JDA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Calendar;

@Component
public class MessageScheduler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private JDA jda = JDAContextHolder.getInstance().getJda();

    private final SendIconService sendIconService;

    public MessageScheduler(SendIconService sendIconService) {
        this.sendIconService = sendIconService;
    }

    @Scheduled(cron = "0 55 * * * *")
    public void sendMessage() {

        int dayOfWeek = Calendar.DAY_OF_WEEK;
        int hourOfDay = Calendar.HOUR_OF_DAY;

        if(dayOfWeek == 1 || dayOfWeek == 7) {
            if(11 <= hourOfDay || hourOfDay <= 24) {
                jda.getTextChannelById(ChannelId.TSU).sendMessage(jda.getUserById(UserId.MALAMUTE).getAsMention() + " 정각 5분 전입니다.").queue();
            }
        } else {
            if(19 <= hourOfDay || hourOfDay <= 24) {
                jda.getTextChannelById(ChannelId.TSU).sendMessage(jda.getUserById(UserId.MALAMUTE).getAsMention() + " 정각 5분 전입니다.").queue();
            }
        }

    }

    @Scheduled(cron = "0 * * * * *")
    public void sendImgIcon() throws Exception {

//        sendIconService.groud_gif(null);

    }

}
