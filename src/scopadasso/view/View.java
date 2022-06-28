package scopadasso.view;

import scopadasso.model.Card;
import scopadasso.model.Deck;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View {

    private static final String CARDS_STRING = " carte";
    private static final int CARD_WIDTH = 150;
    private static final int CARD_HEIGHT = 250;

    private final JLabel[] humanPlayerCardsLabels;
    private final JLabel[] cpuPlayerCardsLabels;
    private final List<JLabel> humanPlayerMopsLabels;
    private final List<JLabel> cpuPlayerMopsLabels;
    private final JLabel[] fieldLabels;
    private final JLabel deckLabel;
    private final JLabel humanPlayerBankLabel;
    private final JLabel cpuPlayerBankLabel;
    private final JLabel humanPlayerAdditionalPointsLabel;
    private final JLabel cpuPlayerAdditionalPointsLabel;
    private final JButton actionButton;
    private final JPanel humanPlayerMopsPanel;
    private final JPanel cpuPlayerMopsPanel;

    public View() {
        //INITIALIZATIONS
        JFrame frame = new JFrame("Scopa d'Asso");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new BorderLayout());
        JPanel fieldCardPanel = new JPanel(new GridLayout(2, 4, 0, 0));
        JPanel humanPlayerPanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JPanel cpuPlayerPanel = new JPanel(new GridLayout(3, 1, 0, 0));
        JPanel humanPlayerCardsPanel = new JPanel(new GridLayout(1, 3, 0, 0));
        JPanel cpuPlayerCardsPanel = new JPanel(new GridLayout(1, 3, 0, 0));
        JPanel humanPlayerBankPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        JPanel cpuPlayerBankPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        humanPlayerMopsPanel = new JPanel(new GridLayout(1, 20, 0, 0));
        cpuPlayerMopsPanel = new JPanel(new GridLayout(1, 20, 0, 0));
        humanPlayerMopsPanel.setPreferredSize(new Dimension(300, 500));
        cpuPlayerMopsPanel.setPreferredSize(new Dimension(300, 500));
        actionButton = new JButton("Prosegui");

        actionButton.setEnabled(false);
        actionButton.setName("proceed");
        actionButton.setPreferredSize(new Dimension(200, 100));
        actionButton.setFont(actionButton.getFont().deriveFont(18f));

        humanPlayerCardsLabels = new JLabel[3];
        cpuPlayerCardsLabels = new JLabel[3];

        for (int i = 0; i < 3; i++) {
            humanPlayerCardsLabels[i] = new JLabel();
            cpuPlayerCardsLabels[i] = new JLabel();
            humanPlayerCardsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            cpuPlayerCardsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            humanPlayerCardsPanel.add(humanPlayerCardsLabels[i]);
            cpuPlayerCardsPanel.add(cpuPlayerCardsLabels[i]);
        }

        humanPlayerBankLabel = new JLabel();
        cpuPlayerBankLabel = new JLabel();
        humanPlayerAdditionalPointsLabel = new JLabel();
        cpuPlayerAdditionalPointsLabel = new JLabel();
        humanPlayerMopsLabels = new ArrayList<>();
        cpuPlayerMopsLabels = new ArrayList<>();

        humanPlayerBankLabel.setFont(humanPlayerBankLabel.getFont().deriveFont(18f));
        cpuPlayerBankLabel.setFont(humanPlayerBankLabel.getFont().deriveFont(18f));
        humanPlayerAdditionalPointsLabel.setFont(humanPlayerBankLabel.getFont().deriveFont(27f));
        cpuPlayerAdditionalPointsLabel.setFont(humanPlayerBankLabel.getFont().deriveFont(27f));
        humanPlayerAdditionalPointsLabel.setForeground(Color.RED);
        cpuPlayerAdditionalPointsLabel.setForeground(Color.RED);
        humanPlayerBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpuPlayerBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        humanPlayerAdditionalPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpuPlayerAdditionalPointsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        fieldLabels = new JLabel[8];
        for (int i = 0; i < 8; i++) {
            fieldLabels[i] = new JLabel();
            fieldLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            fieldCardPanel.add(fieldLabels[i]);
        }
        fieldCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        deckLabel = new JLabel();
        deckLabel.setFont(deckLabel.getFont().deriveFont(18f));
        deckLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //ASSEMBLY
        fieldPanel.add(actionButton, BorderLayout.NORTH);
        fieldPanel.add(fieldCardPanel, BorderLayout.CENTER);
        fieldPanel.add(deckLabel, BorderLayout.SOUTH);

        humanPlayerBankPanel.add(humanPlayerBankLabel);
        humanPlayerBankPanel.add(humanPlayerAdditionalPointsLabel);
        cpuPlayerBankPanel.add(cpuPlayerBankLabel);
        cpuPlayerBankPanel.add(cpuPlayerAdditionalPointsLabel);

        humanPlayerPanel.add(humanPlayerCardsPanel);
        humanPlayerPanel.add(humanPlayerMopsPanel);
        humanPlayerPanel.add(humanPlayerBankPanel);
        cpuPlayerPanel.add(cpuPlayerCardsPanel);
        cpuPlayerPanel.add(cpuPlayerMopsPanel);
        cpuPlayerPanel.add(cpuPlayerBankPanel);

        mainPanel.add(humanPlayerPanel, BorderLayout.WEST);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        mainPanel.add(cpuPlayerPanel, BorderLayout.EAST);

        frame.add(mainPanel);

        //LAST SETTINGS AND SHOW
        frame.setSize(1366, 768);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setHumanPlayerCards(List<Card> hand) {
        for (int i = 0; i < 3; i++) {
            humanPlayerCardsLabels[i].setIcon(null);
        }
        for (int i = 0; i < hand.size(); i++) {
            humanPlayerCardsLabels[i].setIcon(new ImageIcon(Utils.assetFromCard(hand.get(i)).getSprite(CARD_WIDTH, CARD_HEIGHT)));
        }
    }

    public void setHumanPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        humanPlayerMopsLabels.clear();
        humanPlayerMopsPanel.removeAll();
        for (Card card : mop) {
            humanPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : humanPlayerMopsLabels) {
            humanPlayerMopsPanel.add(label);
        }

        if (bankWithoutMop.isEmpty()) {
            humanPlayerBankLabel.setText("");
            humanPlayerBankLabel.setIcon(null);
        } else {
            humanPlayerBankLabel.setText(bankWithoutMop.size() + CARDS_STRING);
            humanPlayerBankLabel.setIcon(new ImageIcon(Asset.BACK_ROTATED.getSprite(CARD_HEIGHT, CARD_WIDTH)));
        }
    }

    public void setCpuPlayerCards(List<Card> hand, Card lastPlayedCard, boolean hasCpuPlayedCard) {
        for (int i = 0; i < 3; i++) {
            cpuPlayerCardsLabels[i].setIcon(null);
        }
        for (int i = 0; i < hand.size(); i++) {
            cpuPlayerCardsLabels[i].setIcon(new ImageIcon(Asset.BACK.getSprite(CARD_WIDTH, CARD_HEIGHT)));
        }

        if (hasCpuPlayedCard) {
            cpuPlayerCardsLabels[hand.size()].setIcon(new ImageIcon(Utils.assetFromCard(lastPlayedCard).getSprite(CARD_WIDTH, CARD_HEIGHT)));
            actionButton.setEnabled(true);
        } else {
            actionButton.setEnabled(false);
        }
    }

    public void setCpuPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        cpuPlayerMopsLabels.clear();
        cpuPlayerMopsPanel.removeAll();
        for (Card card : mop) {
            cpuPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for (JLabel label : cpuPlayerMopsLabels) {
            cpuPlayerMopsPanel.add(label);
        }

        if (bankWithoutMop.isEmpty()) {
            cpuPlayerBankLabel.setText("");
            cpuPlayerBankLabel.setIcon(null);
        } else {
            cpuPlayerBankLabel.setText(bankWithoutMop.size() + CARDS_STRING);
            cpuPlayerBankLabel.setIcon(new ImageIcon(Asset.BACK_ROTATED.getSprite(CARD_HEIGHT, CARD_WIDTH)));
        }
    }

    public void setDeck(Deck deck) {
        if (deck.size() != 0) {
            deckLabel.setText(deck.size() + CARDS_STRING);
            deckLabel.setIcon(new ImageIcon(Asset.BACK_ROTATED.getSprite(CARD_HEIGHT, CARD_WIDTH)));
        } else {
            deckLabel.setText("Mazzo vuoto");
            deckLabel.setIcon(null);
        }
    }

    public void setField(List<Card> field) {
        for (int i = 0; i < 8; i++) {
            fieldLabels[i].setIcon(null);
        }
        for (int i = 0; i < field.size(); i++) {
            fieldLabels[i].setIcon(new ImageIcon(Utils.assetFromCard(field.get(i)).getSprite(CARD_WIDTH, CARD_HEIGHT)));
        }
    }

    public void setHumanPlayerAdditionalPoints(List<Integer> points) {
        if(!points.isEmpty()) {
            humanPlayerAdditionalPointsLabel.setText("CUSA: ");
            for (Integer i : points) {
                humanPlayerAdditionalPointsLabel.setText(humanPlayerAdditionalPointsLabel.getText() + i + " ");
            }
        }else{
            humanPlayerAdditionalPointsLabel.setText("");
        }
    }

    public void setCpuPlayerAdditionalPoints(List<Integer> points) {
        if(!points.isEmpty()) {
            cpuPlayerAdditionalPointsLabel.setText("CUSA: ");
            for (Integer i : points) {
                cpuPlayerAdditionalPointsLabel.setText(cpuPlayerAdditionalPointsLabel.getText() + i + " ");
            }
        }else{
            cpuPlayerAdditionalPointsLabel.setText("");
        }
    }

    public JLabel[] getHumanPlayerCardsLabels() {
        return humanPlayerCardsLabels;
    }

    public JButton getActionButton() {
        return actionButton;
    }

    public void setActionButton(String name, String text, boolean enabled){
        actionButton.setName(name);
        actionButton.setText(text);
        actionButton.setEnabled(enabled);
    }
}
