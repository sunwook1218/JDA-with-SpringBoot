package bot.discord.ww.common;

import bot.discord.ww.core.main.MainAdapter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ApplicationInit {

    @Autowired
    private MainAdapter mainAdapter;

    @PostConstruct
    public void init() throws Exception {

        Path fileName = Path.of("C:\\Key\\key.txt");
        String key = Files.readString(fileName);

        JDA jda = JDABuilder.createDefault(key).build();
        JDAContextHolder.getInstance().setJda(jda);

        jda.addEventListener(mainAdapter);
    }

}
