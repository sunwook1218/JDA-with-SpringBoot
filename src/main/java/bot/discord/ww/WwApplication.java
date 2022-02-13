package bot.discord.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class WwApplication {

	public static void main(String[] args) {

		if (args.length > 0) {
			args[1].equals("server");
			System.setProperty("keypath", File.separator + "home" + File.separator + "ubuntu" + File.separator + "key" + File.separator + "key.txt");
		}

		SpringApplication.run(WwApplication.class, args);

	}

}
