package bot.discord.ww.common;

import bot.discord.ww.core.main.MainAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ApplicationInit {

    private final MainAdapter mainAdapter;

    public ApplicationInit(MainAdapter mainAdapter) {
        this.mainAdapter = mainAdapter;
    }

    @PostConstruct
    public void init() throws Exception {

        String keypath = System.getProperty("keypath", "/home/ubuntu/key/key.txt");

        Path fileName = Path.of(keypath);
        String key = Files.readString(fileName);

        JDA jda = JDABuilder.createDefault(key).build();
        JDAContextHolder.getInstance().setJda(jda);

        jda.addEventListener(mainAdapter);
    }

}
