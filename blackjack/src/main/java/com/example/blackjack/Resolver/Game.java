package com.example.blackjack.Resolver;

import java.util.ArrayList;
import java.util.Scanner;

import com.example.blackjack.Bussines.Desk;
import com.example.blackjack.Model.Card;
import com.example.blackjack.Model.Dealer;
import com.example.blackjack.Model.GameStatus;
import com.example.blackjack.Model.Player;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    private Desk desk;
    private GameStatus gameStatus;
    private Boolean dealerWin = Boolean.FALSE;

    public Game() {
        this.gameStatus = GameStatus.NOTSTARTED;
    }

    public void startGame() {
        this.prepareDesk();
    }

    public void restartGame() {
        this.startGame();
    }

    private void prepareDesk() {
        int totalOfPlayers = 0;
        String inputTotalOfPlayers;

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
                    System.out.println("Starting game with " + totalOfPlayers + " players.");
                    break;

                default:
                    System.out.println("Wrong input value. Trie again.");
                    break;
            }

        } while (totalOfPlayers == 0);

        System.out.println("Preparing the Desk....");
        this.desk = new Desk(totalOfPlayers);
        this.gameStatus = GameStatus.READY;
    }

    public void playGame() {
        this.gameStatus = GameStatus.STARTED;

        System.out.println(
                "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                        "               " + "♣ ♠ ♥ ♦  Shuffling  ♦ ♥ ♠ ♣" + "                   " +
                        "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");

        this.initialRound();

        this.finalRoundForPlayers();

        this.finalRoundForDealer();

        if (dealerWin) {
            System.out.println(
                    "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                            "               " + "♣ ♠ ♥ ♦   Dealer Win...  ♦ ♥ ♠ ♣" + "                   " +
                            "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
        } else{

            System.out.println(
                    "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                            "               " + "♣ ♠ ♥ ♦  Score  ♦ ♥ ♠ ♣" + "                   " +
                            "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
            this.getScore();

            this.finalResult();
        }

    }

    private void initialRound() {
        for (Player player : desk.getPlayers()) {
            Card card = desk.getCard();
            player.getDeck().add(card);
            player.setDeckValue(card.getValue());
            player.setDeckAsString(card.getFullName());
            System.out.println("Dealing to " + player.getName() + ", card: " + player.getDeckAsString());
        }

        // Card face Down to Dealer
        Card card = desk.getCard();
        desk.getDealer().getDeck().add(card);
        desk.getDealer().setDeckValue(card.getValue());
        desk.getDealer().setDeckAsString(card.getFullName());
        System.out.println("Dealing to " + desk.getDealer().getName() + ", card: face down");
    }

    private void finalRoundForPlayers() {

        ArrayList<Player> bustedPlayers = new ArrayList<>();

        for (Player player : desk.getPlayers()) {

            boolean standOrder = false;
            do {
                Card card = desk.getCard();
                player.getDeck().add(card);
                player.setDeckValue(card.getValue());
                player.setDeckAsString(card.getFullName());

                System.out.println("Dealing to " + player.getName() + ", cards: " + player.getDeckAsString());

                if (player.getDeckValue() == 21){
                    System.out.println( player.getName() + "has a BLACKJAC");
                    standOrder = true;
                } else if (player.getDeckValue() > 21) {
                    bustedPlayers.add(player);
                    System.out.println(player.getName() + ", busted: over 21");
                    break;
                } else {
                    boolean wrongType = true;
                    do {
                        System.out.println("Hit or Stand?");
                        String inputTotalOfPlayers = sc.next();

                        switch (inputTotalOfPlayers) {
                            case "hit":
                                wrongType = false;
                                break;

                            case "stand":
                                wrongType = false;
                                standOrder = true;
                                break;

                            default:
                                System.out.println("Wrong input value. Trie again.");
                                break;
                        }

                    } while (wrongType);
                }

            } while (!standOrder);
        }
        if (bustedPlayers.size() > 0)
            for (Player player : bustedPlayers) {
                desk.bustPlayer(player);
            }

        if (desk.getPlayers().size() == 0)
            dealerWin = Boolean.TRUE;
    }

    private void finalRoundForDealer() {
        boolean standOrder = false;
        do {
            Card card = desk.getCard();            
            desk.getDealer().getDeck().add(card);
            desk.getDealer().setDeckValue(card.getValue());
            desk.getDealer().setDeckAsString(card.getFullName());
            System.out.println("Dealing to " + desk.getDealer().getName() + ", cards: " + desk.getDealer().getDeckAsString());

            if(desk.getDealer().getDeckValue() == 21){
                System.out.println( desk.getDealer().getName() + " has a BLACKJAC, ");
                standOrder =true;
                dealerWin = Boolean.TRUE;
            }else if (desk.getDealer().getDeckValue() > 16) {
                standOrder = true;
            }
        } while (!standOrder);
    }

    private void getScore() {

        if(desk.getDealer().getDeckValue()<21){

            int dealerDeckValue = desk.getDealer().getDeckValue();
            ArrayList<Player> bustedPlayers = new ArrayList<>();

            for (Player player : desk.getPlayers()) {

                int playerDeckValue = player.getDeckValue();
                System.out.println(
                        "Scoring" + player.getName() + " has " + playerDeckValue + " , dealere has " + dealerDeckValue);
                if (playerDeckValue <= dealerDeckValue) {
                    System.out.println(" Dealer WIN to " + player.getName());
                    bustedPlayers.add(player);
                } else {
                    System.out.println(player.getName() + " WIN to Dealer");
                }
            }

            if (bustedPlayers.size() > 0) {
                for (Player bustedPlayer : bustedPlayers) {
                    desk.bustPlayer(bustedPlayer);
                }
            }

            if (desk.getPlayers().size() > 0)
                dealerWin = Boolean.FALSE;
            else
                dealerWin = Boolean.TRUE;

        }else{
            System.out.println(" Dealer busted, over 21");
            dealerWin = Boolean.FALSE;
        }

    }

    private void finalResult() {
        if (dealerWin) {
            System.out.println(
                    "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                            "               " + "♣ ♠ ♥ ♦   Dealer Win...  ♦ ♥ ♠ ♣" + "                   " +
                            "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
        } else {
            if (desk.getPlayers().size() == 1) {
                System.out.println(
                        "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                                "           " + "♣ ♠ ♥ ♦  Winer is......  " + desk.getPlayers().get(0).getName() + "   ♦ ♥ ♠ ♣"
                                + "                   " +
                                "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
            } else {
                String winers = "";
                for (Player player : desk.getPlayers()) {
                    if (!winers.equals(""))
                        winers += " ," + player.getName();
                    else
                        winers = player.getName();
                }

                System.out.println(
                        "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  " +
                                "           " + "♣ ♠ ♥ ♦  Winer is...... " + winers + "  ♦ ♥ ♠ ♣" + "                   " +
                                "\n――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n  ");
            }
        }

    }
}
