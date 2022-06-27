package scopadasso.model;

import java.util.ArrayList;
import java.util.List;

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

    public void humanPlayerPlayCard(Card card) {
        humanPlayer.playCard(card);
    }
}
