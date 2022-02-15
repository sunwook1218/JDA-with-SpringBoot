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
    private List<String> jewelList;

    private String searchUrl;

    public String getInfoForEmbedField() {

        StringBuilder sb = new StringBuilder();

        sb.append("캐릭터명 : ")
                .append(characterName)
                .append("\n")
                .append("서버　　 : ")
                .append(serverName)
                .append("\n")
                .append("클래스　 : ")
                .append(className)
                .append("\n")
                .append("전투레벨 : ")
                .append(battleLevel)
                .append("\n")
                .append("템레벨　 : ")
                .append(itemLevel)
                .append("\n")
                .append("원대레벨 : ")
                .append(expeditionLevel);

        return sb.toString();
    }

    public String getAengraveForEmbedField() {

        StringBuilder sb = new StringBuilder();

        equipAengraveList.forEach(aeng -> {
            sb.append(aeng);
            sb.append(" ");
        });

        return sb.toString();
    }

    public String getJewelForEmbedField() {
        StringBuilder sb = new StringBuilder();

        jewelList.forEach(jewel -> {
            String replace = jewel.replaceAll("[레|벨|화|염|의|보|석| ]", "");
            sb.append(replace);
            sb.append(" ");
        });

        return sb.toString();
    }

}
