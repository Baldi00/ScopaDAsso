/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.controller;

import scopadasso.model.Card;
import scopadasso.model.GameManager;
import scopadasso.view.View;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Controller {
    private final GameManager gameManager;
    private final View view;
    private CardClickListener[] cardClickListeners;
    
    public Controller(GameManager gameManager, View view){
        this.gameManager = gameManager;
        this.view = view;
        cardClickListeners = new CardClickListener[3];
        updateView();
        updateHumanPlayerCardClickListeners();
    }

    public void updateView() {
        view.setHumanPlayerCards(gameManager.getHumanPlayer().getHand());
        view.setHumanPlayerBank(gameManager.getHumanPlayer().getBankWithoutMop(), gameManager.getHumanPlayer().getMop());
        view.setCpuPlayerCards(gameManager.getCpuPlayer().getHand());
        view.setCpuPlayerBank(gameManager.getCpuPlayer().getBankWithoutMop(), gameManager.getCpuPlayer().getMop());
        view.setDeck(gameManager.getDeck());
        view.setField(gameManager.getField());
    }

    public void updateHumanPlayerCardClickListeners() {
        JLabel[] humanPlayerCardsLabels = view.getHumanPlayerCardsLabels();
        List<Card> humanPlayerCards = gameManager.getHumanPlayer().getHand();
        for (int i=0; i<humanPlayerCards.size(); i++){
            humanPlayerCardsLabels[i].removeMouseListener(cardClickListeners[i]);

            cardClickListeners[i] = new CardClickListener(humanPlayerCards.get(i), gameManager, this);
            humanPlayerCardsLabels[i].addMouseListener(cardClickListeners[i]);
        }
        for (int i=humanPlayerCards.size(); i<3; i++){
            humanPlayerCardsLabels[i].removeMouseListener(cardClickListeners[i]);
        }
    }


}
