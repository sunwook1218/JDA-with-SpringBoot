package sun.bot.core.main;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import sun.bot.core.search.Scrap;
import sun.bot.example.KeyConstants;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Map;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDA jda= JDABuilder.createDefault(KeyConstants.APPLICATION_KEY).build();

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContentRaw().startsWith("!search")){

            String[] command = event.getMessage().getContentRaw().split(" ");

            Map<String, String> stringStringMap = Scrap.scrapCharacter(command[1]);
            event.getChannel().sendMessage(stringStringMap.get("level")).queue();

        }

        if(event.getMessage().getContentRaw().startsWith("!board")){

            Map<String, Object> best = Scrap.best(1);

            List<String> titles = (List<String>) best.get("titles");

            titles.forEach(title -> {
                event.getChannel().sendMessage(title).queue();
            });

        }

    }

}