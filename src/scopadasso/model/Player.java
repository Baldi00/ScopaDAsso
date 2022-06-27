/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.model;

/**
 *
 * @author Andrea
 */
public class Player extends CardSet {
    private final int id;

    public Player(int id) {
        super();
        this.id = id;
    }
    
    /**
     * Removes the card from the hand
     * @param card the card you want to play
     * @return the played card
     * @throws IllegalStateException if player doesn't have the given card
     */
    public Card playCard(Card card) {
        if(!cards.contains(card))
            throw new IllegalStateException("Player " + id + " doesn't have " + card);
        
        cards.remove(card);
        return card;
    }
}
