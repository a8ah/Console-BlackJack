package com.example.blackjack;

import java.util.Scanner;

import com.example.blackjack.Bussines.Desk;
import com.example.blackjack.Resolver.Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);

		Game game = new Game();

		while (true) {
			game.startGame();

			game.playGame();

			game.restartGame();
		}
	}

	
}
