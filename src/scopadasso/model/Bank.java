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
public class Bank extends CardSet{
    public Bank() {
        super();
    }
    
    public int getResultPoints() {
        int beautifulKing = searchForBeautifulKing();
        int beautifulSeven = searchForBeautifulSeven();
        int coins = searchForCoinsMajority();
        int primiera = searchForPrimiera();
        int cardsNumber = searchForCardsNumberMajority();
        
        return beautifulKing + beautifulSeven + coins + primiera + cardsNumber;
    }
    
    private int searchForBeautifulKing() {
        return searchForCard(new Card(Value.KING, Seed.MONEY));
    }
    
    private int searchForBeautifulSeven(){
        return searchForCard(new Card(Value.SEVEN, Seed.MONEY));
    }
    
    private int searchForCard(Card card) {
        return cards.contains(card) ? 1 : 0;
    }
    
    private int searchForCoinsMajority() {
        int coinsCounter = countCoins();
        return coinsCounter>5 ? 1 : 0;
    }
    
    private int countCoins() {
        int counter = 0;
        for(Value value : Value.values()) {
            if (cards.contains(new Card(value, Seed.MONEY))) {
                counter++;
            }
        }
        return counter;
    }
    
    private int searchForPrimiera() {
        int sevenNumber = countSeven();
        int sixNumber = countSix();
        
        if(sevenNumber == 0) return 0;
        if(sevenNumber == 1) return sixNumber<4 ? 0 : 1;
        if(sevenNumber == 2) return sixNumber<3 ? 0 : 1;
        if(sevenNumber == 3) return sixNumber<1 ? 0 : 1;
        if(sevenNumber == 4) return 1;
        
        throw new IllegalStateException("Bank: There are too many seven");
    }
    
    private int countSeven() {
        int counter = 0;
        for(Seed seed : Seed.values()) {
            if (cards.contains(new Card(Value.SEVEN, seed))) {
                counter++;
            }
        }
        return counter;
    }
    
    private int countSix() {
        int counter = 0;
        for(Seed seed : Seed.values()) {
            if (cards.contains(new Card(Value.SIX, seed))) {
                counter++;
            }
        }
        return counter;
    }
    
    private int searchForCardsNumberMajority() {
        return cards.size()>20 ? 1 : 0;
    }
}
