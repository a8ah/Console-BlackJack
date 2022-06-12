package com.example.blackjack.Bussines;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.blackjack.Model.Card;
import com.example.blackjack.Model.CardName;
import com.example.blackjack.Model.Player;
import com.example.blackjack.Model.Shape;

public class Desk {

    private Player[] players;
    private ArrayList<Card> deck = new  ArrayList<>();

    public Desk(int totalPlayers) {
        
        players = new Player[totalPlayers];
        for(int i=0;i<=totalPlayers-1;i++){
            players[i]= new Player("Player-" + (i+1) );
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

    public Player[] getPlayers() {
        return players;
    }

    private void generateDeckCards() {

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


}
