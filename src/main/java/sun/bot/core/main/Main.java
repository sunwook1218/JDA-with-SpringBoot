package sun.bot.core.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sun.bot.core.message.MessageProxy;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws Exception {

        Path fileName = Path.of("C:\\Key\\key.txt");
        String key = Files.readString(fileName);

        JDA jda= JDABuilder.createDefault(key).build();

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        MessageProxy.getInstance().process(event);

    }

}