package scopadasso.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
    private Player humanPlayer;
    private Player cpuPlayer;
    private List<Card> field;
    private Deck deck;

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

    private void prepareField() {
        for (int i = 0; i < 4; i++)
            field.add(deck.extract());

        if(cardByNameOccurs(field, CardName.ACE) > 1){
            reinitialize();
            preparation();
        }
    }

    private void reinitialize() {
        humanPlayer = new Player(0);
        cpuPlayer = new Player(1);
        field = new ArrayList<>();
        deck = new Deck();
    }

    private int cardByNameOccurs(List<Card> cards, CardName cardName) {
        int counter = 0;
        for (Seed seed : Seed.values()) {
            if (cards.contains(new Card(cardName, seed)))
                counter++;
        }
        return counter;
    }

    public void giveThreeCardsToPlayers() {
        for (int i = 0; i < 3; i++) {
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
        executeMove(humanPlayer, card);
    }

    private void executeMove(Player player, Card card) {
        boolean done = false;
        if(card.getCardName().equals(CardName.ACE) && cardByNameOccurs(field, CardName.ACE) == 0){
            grabAll(player);
            player.addToMop(card);
            done = true;
        }

        if(!done) {
            done = searchAndGrabSingleCard(player, card);
        }

        if (!done) {
            done = searchAndGrabMultipleCards(player, card);
        }
    }

    private boolean searchAndGrabSingleCard(Player player, Card card) {
        for (Card card1 : field) {
            if (card.getCardName().equals(card1.getCardName())) {
                if (field.size() == 1) {
                    player.addToMop(card);
                } else {
                    player.addToBank(card);
                }
                player.addToBank(card1);
                field.remove(card1);
                return true;
            }
        }
        return false;
    }

    private void grabAll(Player player) {
        for (Card card1 : field) {
            player.addToBank(card1);
        }
        field.clear();
    }

    private boolean searchAndGrabMultipleCards(Player player, Card card) {
        List<List<Card>> possibleCardsToGrab = searchForPossibleCardsToGrab(card);
        //TODO: continue
        return false;
    }

    private List<List<Card>> searchForPossibleCardsToGrab(Card card) {
        List<List<Card>> permutations = new ArrayList<>();
        for (int i = 1; i <= field.size(); i++) {
            List<Card> combination = new ArrayList<>();
            createPermutation(permutations, combination, field, i, card.getCardName().getValue());
        }

        deleteDuplications(permutations);
        return permutations;
    }

    private void deleteDuplications(List<List<Card>> permutations) {
        for (List<Card> list : permutations) {
            Collections.sort(list);
        }

        List<List<Card>> permutationsWithoutDuplications = new ArrayList<>();
        int permutationsWithoutDuplicationsSize = 0;
        if (!permutations.isEmpty()) {
            permutationsWithoutDuplications.add(permutations.get(0));
            permutationsWithoutDuplicationsSize++;
            for (int i = 1; i < permutations.size(); i++) {
                if (!permutationsWithoutDuplications.get(permutationsWithoutDuplicationsSize - 1).containsAll(permutations.get(i))) {
                    permutationsWithoutDuplications.add(permutations.get(i));
                    permutationsWithoutDuplicationsSize++;
                }
            }
        }
    }

    private void createPermutation(List<List<Card>> result, List<Card> partial, List<Card> available, int length, int cardValue) {
        if (partial.size() == length) {
            if (calculateValueOfCards(partial) == cardValue)
                result.add(partial);
            return;
        }
        for (Card card : available) {
            List<Card> partial2 = new ArrayList<>(partial);
            partial2.add(card);
            if (calculateValueOfCards(partial2) <= cardValue) {
                List<Card> available2 = new ArrayList<>(available);
                available2.remove(card);
                createPermutation(result, partial2, available2, length, cardValue);
            }
        }
    }

    private int calculateValueOfCards(List<Card> cards) {
        int counter = 0;
        for (Card card : cards) {
            counter += card.getCardName().getValue();
        }
        return counter;
    }
}
