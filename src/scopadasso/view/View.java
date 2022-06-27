package scopadasso.view;

import scopadasso.model.Card;
import scopadasso.model.Deck;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View {
    private final JFrame frame;
    private final JPanel mainPanel;
    private final JPanel fieldPanel;
    private final JPanel humanPlayerPanel;
    private final JPanel cpuPlayerPanel;
    private final JLabel[] humanPlayerCardsLabels;
    private final JLabel[] cpuPlayerCardsLabels;
    private final JLabel[] fieldLabels;
    private final JLabel deckLabel;
    private final JLabel humanPlayerBankLabel;
    private final JLabel cpuPlayerBankLabel;

    private final static int CARD_WIDTH = 150;
    private final static int CARD_HEIGHT = 250;

    public View() {
        //INITIALIZATIONS
        frame = new JFrame("Scopa d'Asso");
        mainPanel = new JPanel(new BorderLayout());
        fieldPanel = new JPanel(new GridLayout(2, 4, 3, 3));
        humanPlayerPanel = new JPanel(new GridLayout(2, 3, 3, 3));
        cpuPlayerPanel = new JPanel(new GridLayout(2, 3, 3, 3));

        humanPlayerCardsLabels = new JLabel[3];
        cpuPlayerCardsLabels = new JLabel[3];

        for (int i = 0; i < 3; i++) {
            humanPlayerCardsLabels[i] = new JLabel();
            cpuPlayerCardsLabels[i] = new JLabel();
            humanPlayerCardsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            cpuPlayerCardsLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            humanPlayerPanel.add(humanPlayerCardsLabels[i]);
            cpuPlayerPanel.add(cpuPlayerCardsLabels[i]);
        }

        humanPlayerBankLabel = new JLabel("0 carte e 0 scope");
        cpuPlayerBankLabel = new JLabel("0 carte e 0 scope");
        humanPlayerPanel.add(humanPlayerBankLabel);
        cpuPlayerPanel.add(cpuPlayerBankLabel);

        // dummy
        humanPlayerPanel.add(new JLabel(""));
        humanPlayerPanel.add(new JLabel(""));
        cpuPlayerPanel.add(new JLabel(""));
        cpuPlayerPanel.add(new JLabel(""));

        fieldLabels = new JLabel[8];
        for (int i = 0; i < 8; i++) {
            fieldLabels[i] = new JLabel();
            fieldLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            fieldPanel.add(fieldLabels[i]);
        }
        fieldPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        deckLabel = new JLabel();

        //ASSEMBLY
        mainPanel.add(humanPlayerPanel, BorderLayout.WEST);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        mainPanel.add(cpuPlayerPanel, BorderLayout.EAST);

        frame.add(mainPanel);

        //LAST SETTINGS AND SHOW
        frame.setSize(1800, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        humanPlayerBankLabel.setText(bankWithoutMop.size() + " carte e " + mop.size() + " scope");
    }

    public void setCpuPlayerCards(List<Card> hand) {
        for (int i = 0; i < 3; i++) {
            cpuPlayerCardsLabels[i].setIcon(null);
        }
        for (int i = 0; i < hand.size(); i++) {
            cpuPlayerCardsLabels[i].setIcon(new ImageIcon(Asset.BACK.getSprite(CARD_WIDTH, CARD_HEIGHT)));
        }
    }

    public void setCpuPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        cpuPlayerBankLabel.setText(bankWithoutMop.size() + " carte e " + mop.size() + " scope");
    }

    public void setDeck(Deck deck) {
        deckLabel.setText("" + deck.size());
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
}
