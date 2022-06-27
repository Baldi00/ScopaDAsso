/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.controller;

import scopadasso.model.GameManager;
import scopadasso.view.View;

/**
 *
 * @author Andrea
 */
public class Controller {
    private final GameManager gameManager;
    private final View view;
    
    public Controller(GameManager gameManager, View view){
        this.gameManager = gameManager;
        this.view = view;
        updateView();
    }
    
    private void updateView() {
        view.setHumanPlayerCards(gameManager.getHumanPlayer().getHand());
//        view.setHumanPlayerBank(gameManager.getHumanPlayer().getBankWithoutMop());
//        view.setHumanPlayerMop(gameManager.getHumanPlayer().getMop());
        view.setCpuPlayerCards(gameManager.getCpuPlayer().getHand());
//        view.setCpuPlayerBank(gameManager.getCpuPlayer().getBankWithoutMop());
//        view.setCpuPlayerMop(gameManager.getCpuPlayer().getMop());
        view.setDeck(gameManager.getDeck());
        view.setField(gameManager.getField());
    }
}
