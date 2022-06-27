/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class GameManager {
    private final Player humanPlayer;
    private final Player cpuPlayer;
    private final List<Card> field;
    private final Deck deck;
    
    public GameManager() {
        humanPlayer = new Player(0);
        cpuPlayer = new Player(1);
        field = new ArrayList<>();
        deck = new Deck();
    }
    
    public void preparation() {
        deck.shuffleDeck();
        prepareField();
        giveThreeCardsToPlayers();
    }
    
    private void prepareField(){
        for(int i=0; i<4; i++)
            field.add(deck.extract());
    }
    
    public void giveThreeCardsToPlayers(){
        for(int i=0; i<3; i++) {
            humanPlayer.receiveCard(deck.extract());
            cpuPlayer.receiveCard(deck.extract());
        }
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public Player getCpuPlayer() {
        return cpuPlayer;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Card> getField() {
        return field;
    }
}
