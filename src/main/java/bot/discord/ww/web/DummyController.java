package bot.discord.ww.web;

import bot.discord.ww.core.main.MainAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DummyController {

    @Autowired
    private MainAdapter adapter;

}
