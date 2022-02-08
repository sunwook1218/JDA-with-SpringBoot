package sun.bot.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.requests.RestAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class SelfDestructMsg implements RestAction {

    @NotNull
    @Override
    public JDA getJDA() {
        return null;
    }

    @NotNull
    @Override
    public RestAction setCheck(@Nullable BooleanSupplier booleanSupplier) {
        return null;
    }

    @Override
    public Object complete(boolean b) throws RateLimitedException {
        return null;
    }

    @NotNull
    @Override
    public CompletableFuture submit(boolean b) {
        return null;
    }

    @Override
    public void queue(@Nullable Consumer consumer, @Nullable Consumer consumer1) {

    }
}
