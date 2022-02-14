package bot.discord.ww.core.main;

import bot.discord.ww.core.message.MessageService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MainAdapter extends ListenerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final MessageService messageService;

    public MainAdapter(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        try {
            messageService.service(event);

        } catch (Exception e) {

            event.getChannel().sendMessage(e.getMessage()).queue(message -> {
                message.editMessageFormat("Error : %s", e.getMessage());
            });

            e.printStackTrace();
        }


    }
}
