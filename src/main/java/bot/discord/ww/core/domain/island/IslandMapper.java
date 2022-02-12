package bot.discord.ww.core.domain.island;

import bot.discord.ww.common.BaseMapper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class IslandMapper extends BaseMapper {

    public Island documentToIsland(Document document) {

        Island.IslandBuilder builder = Island.builder();

        String nextStartTime = document.select(".main-inner-box .count-box").stream().findFirst().get().text().replace(" 시작", "");
        builder.nextStartTime(nextStartTime);

        logger.debug("nextStartTime : {}", nextStartTime);

        Elements islandListElements = document.select(".today-quest-list .list");
        List<String> islandList = islandListElements.stream().map(ele -> ele.text()).collect(Collectors.toList());
        builder.islandList(islandList);

        logger.debug("islandList : {}", islandList.toString());

        String timeToNextStart = getTimeDiffToString(nextStartTime);
        builder.timeToNextStart(timeToNextStart);

        logger.debug("timeToNextStart : {}", timeToNextStart);

        return builder.build();
    }

    private String getTimeDiffToString(String nextStartTime) {

        Timestamp nextStamp = Timestamp.valueOf(nextStartTime);
        Timestamp nowStamp = new Timestamp(System.currentTimeMillis());

        long diff = nextStamp.getTime() - nowStamp.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        StringBuilder sb = new StringBuilder();

        return sb.append(diffHours)
                .append("시간 ")
                .append(diffMinutes)
                .append("분 ")
                .append(diffSeconds)
                .append("초")
                .toString();
    }

}
