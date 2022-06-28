package scopadasso.view;

import scopadasso.model.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsView {

    private static final int CARD_WIDTH = 80;
    private static final int CARD_HEIGHT = 130;

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
        frame.setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JPanel titlesPanel = new JPanel(new BorderLayout());
        JPanel humanPanel = new JPanel(new BorderLayout());
        JPanel cpuPanel = new JPanel(new BorderLayout());
        JLabel playerLabel = new JLabel("GIOCATORE");
        JLabel cardsLabel = new JLabel("CARTE");
        JLabel mopsLabel = new JLabel("SCOPE");
        humanPlayerPointsLabel = new JLabel("TU: 0 punti");
        cpuPlayerPointsLabel = new JLabel("CPU: 0 punti");
        humanPlayerMopsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        cpuPlayerMopsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        humanPlayerCardsPanel = new JPanel(new GridLayout(1, 40, 0, 0));
        cpuPlayerCardsPanel = new JPanel(new GridLayout(1, 40, 0, 0));

        humanPlayerMopsLabels = new ArrayList<>();
        cpuPlayerMopsLabels = new ArrayList<>();
        humanPlayerCardsLabels = new ArrayList<>();
        cpuPlayerCardsLabels = new ArrayList<>();

        humanPlayerCardsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cpuPlayerCardsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        humanPlayerPointsLabel.setFont(playerLabel.getFont().deriveFont(15f));
        cpuPlayerPointsLabel.setFont(playerLabel.getFont().deriveFont(15f));

        playerLabel.setFont(playerLabel.getFont().deriveFont(18f));
        cardsLabel.setFont(playerLabel.getFont().deriveFont(18f));
        mopsLabel.setFont(playerLabel.getFont().deriveFont(18f));
        playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mopsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //ASSEMBLY

        titlesPanel.add(playerLabel, BorderLayout.WEST);
        titlesPanel.add(cardsLabel, BorderLayout.CENTER);
        titlesPanel.add(mopsLabel, BorderLayout.EAST);

        humanPanel.add(humanPlayerPointsLabel, BorderLayout.WEST);
        humanPanel.add(humanPlayerCardsPanel, BorderLayout.CENTER);
        humanPanel.add(humanPlayerMopsPanel, BorderLayout.EAST);

        cpuPanel.add(cpuPlayerPointsLabel, BorderLayout.WEST);
        cpuPanel.add(cpuPlayerCardsPanel, BorderLayout.CENTER);
        cpuPanel.add(cpuPlayerMopsPanel, BorderLayout.EAST);

        mainPanel.add(humanPanel);
        mainPanel.add(cpuPanel);

        frame.add(titlesPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        //LAST SETTINGS AND SHOW
        frame.setSize(1366, 768);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setHumanPlayerPoints(int points, int beautifulKing, int beautifulSeven, int coins, int primiera, int cardsNumber) {
        humanPlayerPointsLabel.setText("<html>TU: " + points + " punti<br>");
        if (beautifulKing == 1) humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "| Re Bello |");
        if (beautifulSeven == 1) humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "| Sette Bello |");
        if (coins == 1) humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "| Denari |");
        if (primiera == 1) humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "| Primiera |");
        if (cardsNumber == 1) humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "| Carte |");
        humanPlayerPointsLabel.setText(humanPlayerPointsLabel.getText() + "</html>");
    }

    public void setCpuPlayerPoints(int points, int beautifulKing, int beautifulSeven, int coins, int primiera, int cardsNumber) {
        cpuPlayerPointsLabel.setText("<html>CPU: " + points + " punti<br>");
        if (beautifulKing == 1) cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "| Re Bello |");
        if (beautifulSeven == 1) cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "| Sette Bello |");
        if (coins == 1) cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "| Denari |");
        if (primiera == 1) cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "| Primiera |");
        if (cardsNumber == 1) cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "| Carte |");
        cpuPlayerPointsLabel.setText(cpuPlayerPointsLabel.getText() + "</html>");
    }

    public void setHumanPlayerCards(List<Card> cards) {
        humanPlayerCardsLabels.clear();
        humanPlayerCardsPanel.removeAll();
        for (Card card : cards) {
            humanPlayerCardsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : humanPlayerCardsLabels) {
            humanPlayerCardsPanel.add(label);
        }
    }

    public void setCpuPlayerCards(List<Card> cards) {
        cpuPlayerCardsLabels.clear();
        cpuPlayerCardsPanel.removeAll();
        for (Card card : cards) {
            cpuPlayerCardsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : cpuPlayerCardsLabels) {
            cpuPlayerCardsPanel.add(label);
        }
    }

    public void setHumanPlayerMops(List<Card> cards) {
        humanPlayerMopsLabels.clear();
        humanPlayerMopsPanel.removeAll();
        for (Card card : cards) {
            humanPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : humanPlayerMopsLabels) {
            humanPlayerMopsPanel.add(label);
        }
    }

    public void setCpuPlayerMops(List<Card> cards) {
        cpuPlayerMopsLabels.clear();
        cpuPlayerMopsPanel.removeAll();
        for (Card card : cards) {
            cpuPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : cpuPlayerMopsLabels) {
            cpuPlayerMopsPanel.add(label);
        }
    }
}
