/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Deck {
    private final List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        fillDeck();
    }
    
    private void fillDeck() {
        for(Value value : Value.values()) {
            for(Seed seed : Seed.values()) {
                deck.add(new Card(value, seed));
            }
        }
    }
    
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
    
    /**
     * Extract a card and removes it from deck
     * @return the extracted card
     * @throws IllegalStateException if deck is empty
     */
    public Card extract() {
        if(deck.isEmpty())
            throw new IllegalStateException("Cannot extract card, the deck is empty");
        
        Card extracted = deck.get(0);
        deck.remove(0);
        return extracted;
    }
    
    public int size() {
        return deck.size();
    }
}
