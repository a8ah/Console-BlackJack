package com.example.blackjack;

import java.util.Scanner;

import com.example.blackjack.Bussines.Desk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);

		Scanner sc = new Scanner(System.in);
		int totalOfPlayers = 0;
		String  inputTotalOfPlayers;

		do {
			System.out.println(
					"\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
					"               " + "♣ ♠ ♥ ♦   Black Jack  ♦ ♥ ♠ ♣" + "                   " +
					"\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
			System.out.println("Select de Number of Players. Up to 3  players....");
			inputTotalOfPlayers = sc.next();

			switch (inputTotalOfPlayers) {
				case "1", "2", "3":
					totalOfPlayers = Integer.parseInt(inputTotalOfPlayers);
					System.out.println("Number of Players - " + totalOfPlayers);
					break;

				default:
					System.out.println("Wrong input value. Trie again.");
					break;
			}

		} while (totalOfPlayers == 0);

		System.out.println("Preparing the Desk....");
		Desk desk = new Desk(totalOfPlayers);

		System.out.println(
					"\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
					"               " + "♣ ♠ ♥ ♦   Dealing Cards  ♦ ♥ ♠ ♣" + "                   " +
					"\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");

		
	}

}
