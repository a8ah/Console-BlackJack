package com.example.blackjack.Bussines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.blackjack.Model.Card;
import com.example.blackjack.Model.CardName;
import com.example.blackjack.Model.Dealer;
import com.example.blackjack.Model.Player;
import com.example.blackjack.Model.Shape;

public class Desk {

    private Dealer dealer;
    private ArrayList<Player> players;
    private ArrayList<Card> deck = new  ArrayList<>();

    public Desk(){}

    public Desk(int totalPlayers) {

        dealer = new Dealer();
        
        players = new ArrayList<Player>();
        for(int i=0;i<=totalPlayers-1;i++){
            players.add( new Player("Player-" + (i+1) ));
        }

        // for (Player player : players) {
        //     System.out.println("Name " + player.getName());
        // }

        this.generateDeckCards();
        
        // System.out.println("Mazo de cartas");
        // System.out.println("Total de cartas " + deck.size());
        // for (Card card : deck) {
        //     System.out.println("mazo de cartas " + card.getFullName());
        // }
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void generateDeckCards() {

        // Getting the Shapes List
        List<Shape> shapes = Arrays.stream(Shape.values()).collect(Collectors.toList());

        // Getting the Shapes List
        List<CardName> cardsName = Arrays.stream(CardName.values()).collect(Collectors.toList());

        for (Shape shape : shapes) {
            for (CardName cardName : cardsName) {
                Card card = new Card(shape, cardName);
                deck.add(card);
            }
        }
    }

    public Card getCard(){
        Random rndm = new Random();
        int randomCardSelection = rndm.nextInt(deck.size());

        Card card = deck.get(randomCardSelection);
        deck.remove(randomCardSelection);

        return card;
    }

    public void bustPlayer(Player player){
        players.remove(player);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
