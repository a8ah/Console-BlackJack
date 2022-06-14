package com.example.blackjack.Bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.blackjack.Bussines.Desk;
import com.example.blackjack.Model.Card;
import com.example.blackjack.Model.Dealer;
import com.example.blackjack.Model.Player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DeskTest {

    @Autowired
    Desk desk;

    @Test
    void generateDeckCards(){
        desk = new Desk();
        desk.generateDeckCards();

        assertNotNull(desk.getDeck());
        assertEquals(52,desk.getDeck().size());
    }

    @Test
    void generateDeck(){
        desk = new Desk(3);

        assertEquals(3,desk.getPlayers().size());
        assertInstanceOf(Dealer.class,desk.getDealer());
        assertEquals(52,desk.getDeck().size());
    }

    @Test
    void getCard(){
        desk = new Desk(3);

        assertInstanceOf(Card.class,desk.getCard());
        assertNotNull(desk.getCard());

    }

    @Test
    void bustPlayer(){
        desk = new Desk(3);

        Player player = desk.getPlayers().get(0);
        desk.bustPlayer(player);

        assertNotEquals(3,desk.getPlayers().size());
        assertEquals(2,desk.getPlayers().size());
        assertNotEquals(player,desk.getPlayers().get(0));

    }
}
