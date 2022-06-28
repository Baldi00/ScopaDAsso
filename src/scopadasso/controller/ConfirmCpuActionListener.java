package scopadasso.controller;

import scopadasso.model.GameManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmCpuActionListener implements ActionListener {
    private final GameManager gameManager;
    private final Controller controller;

    public ConfirmCpuActionListener(GameManager gameManager, Controller controller) {
        this.gameManager = gameManager;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameManager.executeMove(gameManager.getCpuPlayer(), gameManager.getCpuPlayer().getLastPlayedCard());
        gameManager.checkIfTurnOverAndRefillCards();
        controller.updateView();
    }
}
