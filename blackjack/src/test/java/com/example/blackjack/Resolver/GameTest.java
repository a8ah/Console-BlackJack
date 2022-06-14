package com.example.blackjack.Resolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.blackjack.Bussines.Desk;
import com.example.blackjack.Model.GameStatus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class GameTest {
    
    @Autowired
    Game game;

    @Autowired
    Desk desk;

    @Test
    void newGame(){
        game = new Game();
        assertEquals(GameStatus.NOTSTARTED,game.getGameStatus());
    }

    @Test
    void initialRound(){
        game = new Game();
        desk = new Desk(3);

        game.initialRound();
        assertNotNull(desk.getPlayers().get(0).getDeck().size());
        assertEquals(1,desk.getPlayers().get(0).getDeck().size());
        assertNotNull(desk.getPlayers().get(1).getDeck().size());
        assertEquals(1,desk.getPlayers().get(1).getDeck().size());
        assertNotNull(desk.getPlayers().get(2).getDeck().size());
        assertEquals(1,desk.getPlayers().get(2).getDeck().size());

        assertNotNull(desk.getDealer().getDeck().size());
        assertEquals(1,desk.getDealer().getDeck().size());
    }

}
