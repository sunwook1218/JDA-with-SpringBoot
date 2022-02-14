package bot.discord.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;

@SpringBootApplication
@EnableScheduling
public class WwApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwApplication.class, args);
	}

}
