package scopadasso.controller;

import scopadasso.model.Card;
import scopadasso.model.GameManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CardClickListener implements MouseListener {
    private final Card card;
    private final GameManager gameManager;
    private final Controller controller;

    public CardClickListener(Card card, GameManager gameManager, Controller controller) {
        this.card = card;
        this.gameManager = gameManager;
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        gameManager.humanPlayerPlayCard(card);
        gameManager.cpuPlayerPlayCard();
        gameManager.checkIfTurnOverAndRefillCards();
        controller.updateView();
        controller.updateHumanPlayerCardClickListeners();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //unused
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //unused
    }
}
