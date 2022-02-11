package sun.bot.core.message;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageProxy {

    private static MessageProxy instance = null;

    public static MessageProxy getInstance() {
        if (instance == null) {
            instance = new MessageProxy();
        }
        return instance;
    }

    public void process(MessageReceivedEvent event) {

        // Something Before Send Message

        try {

            MessageService.getInstance().service(event);

        } catch(Exception e) {

            event.getChannel().sendMessage(e.getMessage());

        }

        // Something After Send Message

    }

}
