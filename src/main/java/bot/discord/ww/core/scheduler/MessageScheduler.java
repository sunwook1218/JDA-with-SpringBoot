package bot.discord.ww.core.scheduler;

import bot.discord.ww.common.JDAContextHolder;
import net.dv8tion.jda.api.JDA;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageScheduler {

    @Scheduled(cron = "0 55 * * * *")
    public void sendMessage() {

        JDA jda = JDAContextHolder.getInstance().getJda();

        jda.getTextChannelById("246804865005780993").sendMessage(jda.getUserById("194151264316162050").getAsMention() + " 정각 5분 전입니다.").queue();

    }

}
