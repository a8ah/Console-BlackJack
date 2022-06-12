package com.example.blackjack.Model;

public  class Card {

    private int value;
    private CardName name;
    private Shape shape;

    public Card(Shape shape, CardName cardName){
        this.shape = shape;
        this.name = cardName;

        switch (cardName) {
            case ACE: 
                value = 11;
                break;
            
            case J,Q,K: 
                value = 10;
                break;
        
            default:
                value =  Integer. parseInt(cardName.getName()); 
                break;
        }
    }

    public int getValue() {
        return value;
    }

    public CardName getName() {
        return name;
    }

    public Shape getShape() {
        return shape;
    }

    public String getFullName(){
        return name.getName() + " " + shape.getName();
    }

}
