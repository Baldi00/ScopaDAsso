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
public class CardSet {
    protected final List<Card> cards;
    
    public CardSet() {
        cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public List<Card> getCards(){
        return new ArrayList<>(cards);
    }
}
