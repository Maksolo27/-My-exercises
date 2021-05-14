package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SpringcrudmethodsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringcrudmethodsApplication.class, args);
		GameService gameService = ctx.getBean(GameServiceImpl.class);
		Game game = new Game(1, "game", 200);
		gameService.save(game);
		System.out.println(gameService.getGameByName("game"));
	}

}
