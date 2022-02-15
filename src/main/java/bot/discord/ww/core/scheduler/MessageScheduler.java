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

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

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

        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"), Locale.KOREA);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if(dayOfWeek == 1 || dayOfWeek == 7) {
            if(11 <= hourOfDay || hourOfDay <= 24) {
                logger.info("dayOfWeek : {}, hourOfDay : {}", dayOfWeek,  hourOfDay);
                jda.getTextChannelById(ChannelId.PERSONAL).sendMessage(jda.getUserById(UserId.MALAMUTE).getAsMention() + " 정각 5분 전입니다.").queue();
            }
        } else {
            if(19 <= hourOfDay || hourOfDay <= 24) {
                logger.info("dayOfWeek : {}, hourOfDay : {}", dayOfWeek,  hourOfDay);
                jda.getTextChannelById(ChannelId.PERSONAL).sendMessage(jda.getUserById(UserId.MALAMUTE).getAsMention() + " 정각 5분 전입니다.").queue();
            }
        }

    }

    @Scheduled(cron = "0/30 * * * * *")
    public void sendImgIcon() throws Exception {

        sendIconService.cute(null);

    }

}
