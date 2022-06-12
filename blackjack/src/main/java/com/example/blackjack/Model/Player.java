package com.example.blackjack.Model;

import java.util.ArrayList;

public class Player {

    private String name;
    private int deckValue;
    private String deckAsString=null;
    private ArrayList<Card> deck = new ArrayList<>();

    public Player(String name){
        this.name = name;
        this.deckValue = 0;
    }
    public String getDeckAsString() {
        return deckAsString;
    }
    public void setDeckAsString(String deckAsString) {
        if(null != this.deckAsString)
            this.deckAsString += ", " + deckAsString;
        else this.deckAsString = deckAsString;        
    }
    public int getDeckValue() {
        return deckValue;
    }

    public void setDeckValue(int deckValue) {
        this.deckValue += deckValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    // public void updateDeckValue(){

    // }
}
