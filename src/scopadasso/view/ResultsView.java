package scopadasso.view;

import scopadasso.model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsView {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 150;

    private final JLabel humanPlayerPointsLabel;
    private final JLabel cpuPlayerPointsLabel;
    private final List<JLabel> humanPlayerMopsLabels;
    private final List<JLabel> cpuPlayerMopsLabels;
    private final List<JLabel> humanPlayerCardsLabels;
    private final List<JLabel> cpuPlayerCardsLabels;
    private final JPanel humanPlayerMopsPanel;
    private final JPanel cpuPlayerMopsPanel;
    private final JPanel humanPlayerCardsPanel;
    private final JPanel cpuPlayerCardsPanel;

    public ResultsView() {
        //INITIALIZATIONS
        JFrame frame = new JFrame("Risultati");
        JPanel mainPanel = new JPanel(new GridLayout(2, 3, 0, 0));
        humanPlayerMopsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        cpuPlayerMopsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        humanPlayerCardsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        cpuPlayerCardsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        humanPlayerPointsLabel = new JLabel("TU: 0 punti");
        cpuPlayerPointsLabel = new JLabel("CPU: 0 punti");

        humanPlayerMopsLabels = new ArrayList<>();
        cpuPlayerMopsLabels = new ArrayList<>();
        humanPlayerCardsLabels = new ArrayList<>();
        cpuPlayerCardsLabels = new ArrayList<>();

        //ASSEMBLY

        mainPanel.add(humanPlayerPointsLabel);
        mainPanel.add(humanPlayerMopsPanel);
        mainPanel.add(humanPlayerCardsPanel);
        mainPanel.add(cpuPlayerPointsLabel);
        mainPanel.add(cpuPlayerMopsPanel);
        mainPanel.add(cpuPlayerCardsPanel);

        frame.add(mainPanel);

        //LAST SETTINGS AND SHOW
        frame.setSize(1366, 768);
        frame.setVisible(true);
    }

    public void setHumanPlayerPoints(int points) {
        humanPlayerPointsLabel.setText("TU: " + points + " punti");
    }

    public void setCpuPlayerPoints(int points) {
        cpuPlayerPointsLabel.setText("CPU: " + points + " punti");
    }

    public void setHumanPlayerCards(List<Card> cards) {
        humanPlayerCardsLabels.clear();
        humanPlayerCardsPanel.removeAll();
        for (Card card : cards) {
            humanPlayerCardsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : humanPlayerCardsLabels) {
            humanPlayerCardsPanel.add(label);
        }
    }

    public void setCpuPlayerCards(List<Card> cards) {
        cpuPlayerCardsLabels.clear();
        cpuPlayerCardsPanel.removeAll();
        for (Card card : cards) {
            cpuPlayerCardsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : cpuPlayerCardsLabels) {
            cpuPlayerCardsPanel.add(label);
        }
    }

    public void setHumanPlayerMops(List<Card> cards) {
        humanPlayerMopsLabels.clear();
        humanPlayerMopsPanel.removeAll();
        for (Card card : cards) {
            humanPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : humanPlayerMopsLabels) {
            humanPlayerMopsPanel.add(label);
        }
    }

    public void setCpuPlayerMops(List<Card> cards) {
        cpuPlayerMopsLabels.clear();
        cpuPlayerMopsPanel.removeAll();
        for (Card card : cards) {
            cpuPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : cpuPlayerMopsLabels) {
            cpuPlayerMopsPanel.add(label);
        }
    }
}
