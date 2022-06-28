package scopadasso.controller;

import scopadasso.model.Card;
import scopadasso.model.GameManager;
import scopadasso.model.Player;
import scopadasso.view.ResultsView;
import scopadasso.view.View;

import javax.swing.*;
import java.util.List;

public class Controller {
    private final GameManager gameManager;
    private final View view;
    private final CardClickListener[] cardClickListeners;

    public Controller(GameManager gameManager, View view) {
        this.gameManager = gameManager;
        this.view = view;
        cardClickListeners = new CardClickListener[3];
        updateView();
        addConfirmCpuActionButtonListener();
    }

    public void updateView() {
        view.setHumanPlayerCards(gameManager.getHumanPlayer().getHand());
        view.setHumanPlayerBank(gameManager.getHumanPlayer().getBankWithoutMop(), gameManager.getHumanPlayer().getMop());
        view.setHumanPlayerAdditionalPoints(gameManager.getHumanPlayer().getAdditionalPoints());
        view.setCpuPlayerCards(gameManager.getCpuPlayer().getHand(), gameManager.getCpuPlayer().getLastPlayedCard(), gameManager.hasCpuPlayedCard());
        view.setCpuPlayerBank(gameManager.getCpuPlayer().getBankWithoutMop(), gameManager.getCpuPlayer().getMop());
        view.setCpuPlayerAdditionalPoints(gameManager.getCpuPlayer().getAdditionalPoints());
        view.setDeck(gameManager.getDeck());
        view.setField(gameManager.getField());
        updateHumanPlayerCardClickListeners();
    }

    private void updateHumanPlayerCardClickListeners() {
        JLabel[] humanPlayerCardsLabels = view.getHumanPlayerCardsLabels();
        List<Card> humanPlayerCards = gameManager.getHumanPlayer().getHand();
        for (int i = 0; i < humanPlayerCards.size(); i++) {
            humanPlayerCardsLabels[i].removeMouseListener(cardClickListeners[i]);

            cardClickListeners[i] = new CardClickListener(humanPlayerCards.get(i), gameManager, this);
            humanPlayerCardsLabels[i].addMouseListener(cardClickListeners[i]);
        }
        for (int i = humanPlayerCards.size(); i < 3; i++) {
            humanPlayerCardsLabels[i].removeMouseListener(cardClickListeners[i]);
        }
    }

    private void addConfirmCpuActionButtonListener() {
        view.getConfirmCpuActionButton().addActionListener(new ConfirmCpuActionListener(gameManager, this));
    }

    public void showMatchResults() {
        ResultsView resultsView = new ResultsView();
        Player humanPlayer = gameManager.getHumanPlayer();
        Player cpuPlayer = gameManager.getCpuPlayer();
        resultsView.setHumanPlayerPoints(
                humanPlayer.getPoints(),
                humanPlayer.getBank().searchForBeautifulKing(),
                humanPlayer.getBank().searchForBeautifulSeven(),
                humanPlayer.getBank().searchForCoinsMajority(),
                humanPlayer.getBank().searchForPrimiera(),
                humanPlayer.getBank().searchForCardsNumberMajority());
        resultsView.setHumanPlayerCards(humanPlayer.getBankWithoutMop());
        resultsView.setHumanPlayerMops(humanPlayer.getMop());
        resultsView.setCpuPlayerPoints(
                cpuPlayer.getPoints(),
                cpuPlayer.getBank().searchForBeautifulKing(),
                cpuPlayer.getBank().searchForBeautifulSeven(),
                cpuPlayer.getBank().searchForCoinsMajority(),
                cpuPlayer.getBank().searchForPrimiera(),
                cpuPlayer.getBank().searchForCardsNumberMajority());
        resultsView.setCpuPlayerCards(cpuPlayer.getBankWithoutMop());
        resultsView.setCpuPlayerMops(cpuPlayer.getMop());
    }
}
