package bot.discord.ww.core.domain.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    private String characterName;
    private String serverName;
    private String guildName;
    private String className;
    private String titleName;
    private String battleLevel;
    private String itemLevel;
    private String expeditionLevel;
    private String pvpClass;
    private String wisdomInfo;
    private List<String> equipAengraveList;

    private String searchUrl;

    public String characterInfoForEmbedField() {

        StringBuilder sb = new StringBuilder();

        return sb.append("캐릭터명 : ")
                .append(characterName)
                .append("\n")


                .toString();
    }

}
