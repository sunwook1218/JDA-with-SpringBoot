package bot.discord.ww.core.domain.island;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Island {

    private String nextStartTime;
    private List<String> islandList;
    private String timeToNextStart;

}
