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
public class Player {
    private final int id;
    private final List<Card> hand;
    private final Bank bank;

    public Player(int id) {
        this.id = id;
        hand = new ArrayList<>();
        bank = new Bank();
    }
    
    /**
     * Removes the card from the hand
     * @param card the card you want to play
     * @return the played card
     * @throws IllegalStateException if player doesn't have the given card
     */
    public Card playCard(Card card) {
        if(!hand.contains(card))
            throw new IllegalStateException("Player " + id + " doesn't have " + card);

        System.out.println("Played " + card);

        hand.remove(card);
        return card;
    }
    
    public void receiveCard(Card card) {
        if(hand.size() >= 3)
            throw new IllegalStateException("Trying to add card to a player that has already 3 cards");
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getBankWithoutMop() {
        return bank.getBankWithoutMop();
    }

    public List<Card> getMop() {
        return bank.getMop();
    }
}
