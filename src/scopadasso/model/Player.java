package scopadasso.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Card> hand;
    private final Bank bank;
    private Card lastPlayedCard;
    private int points;

    public Player() {
        hand = new ArrayList<>();
        bank = new Bank();
        points = 0;
    }

    /**
     * Removes the card from the hand
     *
     * @param card the card you want to play
     * @throws IllegalStateException if player doesn't have the given card
     */
    public void playCard(Card card) {
        if (!hand.contains(card))
            throw new IllegalStateException("Player doesn't have " + card);

        hand.remove(card);
        lastPlayedCard = card;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Bank getBank() {
        return bank;
    }
}
