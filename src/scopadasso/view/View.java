package scopadasso.view;

import scopadasso.model.Card;
import scopadasso.model.Deck;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class View {

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
    private final JButton confirmCpuActionButton;
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
        humanPlayerMopsPanel = new JPanel(new GridLayout(1, 20, 0, 0));
        cpuPlayerMopsPanel = new JPanel(new GridLayout(1, 20, 0, 0));
        humanPlayerMopsPanel.setPreferredSize(new Dimension(300, 500));
        cpuPlayerMopsPanel.setPreferredSize(new Dimension(300, 500));
        confirmCpuActionButton = new JButton("Prosegui");

        confirmCpuActionButton.setEnabled(false);
        confirmCpuActionButton.setPreferredSize(new Dimension(200, 100));

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
        humanPlayerMopsLabels = new ArrayList<>();
        cpuPlayerMopsLabels = new ArrayList<>();

        humanPlayerBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpuPlayerBankLabel.setHorizontalAlignment(SwingConstants.CENTER);

        fieldLabels = new JLabel[8];
        for (int i = 0; i < 8; i++) {
            fieldLabels[i] = new JLabel();
            fieldLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            fieldCardPanel.add(fieldLabels[i]);
        }
        fieldCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        deckLabel = new JLabel();
        deckLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //ASSEMBLY
        fieldPanel.add(confirmCpuActionButton, BorderLayout.NORTH);
        fieldPanel.add(fieldCardPanel, BorderLayout.CENTER);
        fieldPanel.add(deckLabel, BorderLayout.SOUTH);

        humanPlayerPanel.add(humanPlayerCardsPanel);
        humanPlayerPanel.add(humanPlayerMopsPanel);
        humanPlayerPanel.add(humanPlayerBankLabel);
        cpuPlayerPanel.add(cpuPlayerCardsPanel);
        cpuPlayerPanel.add(cpuPlayerMopsPanel);
        cpuPlayerPanel.add(cpuPlayerBankLabel);

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
        for(Card card : mop) {
            humanPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : humanPlayerMopsLabels) {
            humanPlayerMopsPanel.add(label);
        }

        if(bankWithoutMop.isEmpty()) {
            humanPlayerBankLabel.setText("");
            humanPlayerBankLabel.setIcon(null);
        } else {
            humanPlayerBankLabel.setText(bankWithoutMop.size() + " carte");
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
            confirmCpuActionButton.setEnabled(true);
        } else {
            confirmCpuActionButton.setEnabled(false);
        }
    }

    public void setCpuPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        cpuPlayerMopsLabels.clear();
        cpuPlayerMopsPanel.removeAll();
        for(Card card : mop) {
            cpuPlayerMopsLabels.add(new JLabel(new ImageIcon(Utils.assetFromCard(card).getSprite(CARD_WIDTH, CARD_HEIGHT))));
        }
        for(JLabel label : cpuPlayerMopsLabels) {
            cpuPlayerMopsPanel.add(label);
        }

        if(bankWithoutMop.isEmpty()) {
            cpuPlayerBankLabel.setText("");
            cpuPlayerBankLabel.setIcon(null);
        } else {
            cpuPlayerBankLabel.setText(bankWithoutMop.size() + " carte");
            cpuPlayerBankLabel.setIcon(new ImageIcon(Asset.BACK_ROTATED.getSprite(CARD_HEIGHT, CARD_WIDTH)));
        }
    }

    public void setDeck(Deck deck) {
        if(deck.size() != 0) {
            deckLabel.setText(deck.size() + " carte");
            deckLabel.setIcon(new ImageIcon(Asset.BACK_ROTATED.getSprite(CARD_HEIGHT, CARD_WIDTH)));
        }else{
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

    public JLabel[] getHumanPlayerCardsLabels() {
        return humanPlayerCardsLabels;
    }

    public JButton getConfirmCpuActionButton() {
        return confirmCpuActionButton;
    }
}
