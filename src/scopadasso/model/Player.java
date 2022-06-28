package scopadasso.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int id;
    private final List<Card> hand;
    private final Bank bank;
    private Card lastPlayedCard;

    public Player(int id) {
        this.id = id;
        hand = new ArrayList<>();
        bank = new Bank();
    }

    /**
     * Removes the card from the hand
     *
     * @param card the card you want to play
     * @return the played card
     * @throws IllegalStateException if player doesn't have the given card
     */
    public Card playCard(Card card) {
        if (!hand.contains(card))
            throw new IllegalStateException("Player " + id + " doesn't have " + card);

        hand.remove(card);
        lastPlayedCard = card;
        return card;
    }

    public void receiveCard(Card card) {
        if (hand.size() >= 3)
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

    public void addToMop(Card card) {
        bank.addToMop(card);
    }

    public void addToBank(Card card) {
        bank.addToBank(card);
    }

    public Card getLastPlayedCard() {
        return lastPlayedCard;
    }

}
