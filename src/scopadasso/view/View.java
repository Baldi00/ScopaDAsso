/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

import scopadasso.model.Card;
import scopadasso.model.Deck;

/**
 *
 * @author Andrea
 */
public class View {
    private JFrame frame;
    private JPanel mainPanel, fieldPanel, humanPlayerPanel, cpuPlayerPanel;
    private JLabel [] humanPlayerCardsLabels, cpuPlayerCardsLabels, fieldLabels;
    private JLabel deckLabel, humanPlayerBankLabel, cpuPlayerBankLabel;
    
    public View(){
        //INITIALIZATIONS
        frame = new JFrame("Scopa d'Asso");
        mainPanel = new JPanel(new BorderLayout());
        fieldPanel = new JPanel(new GridLayout(2, 4, 3, 3));
        humanPlayerPanel = new JPanel(new GridLayout(2, 3, 3, 3));
        cpuPlayerPanel = new JPanel(new GridLayout(2, 3, 3, 3));
        
        humanPlayerCardsLabels = new JLabel[3];
        cpuPlayerCardsLabels = new JLabel[3];
        
        for(int i=0; i<3; i++) {
            humanPlayerCardsLabels[i] = new JLabel();
            cpuPlayerCardsLabels[i] = new JLabel();
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
        for(int i=0; i<8; i++) {
            fieldLabels[i] = new JLabel();
            fieldPanel.add(fieldLabels[i]);
        }
        
        deckLabel = new JLabel();
        
        //ASSEMBLY
        mainPanel.add(humanPlayerPanel, BorderLayout.WEST);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        mainPanel.add(cpuPlayerPanel, BorderLayout.EAST);
        
        frame.add(mainPanel);
        
        //LAST SETTINGS AND SHOW
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setHumanPlayerCards(List<Card> hand) {
        for (int i = 0; i < 3; i++) {
            humanPlayerCardsLabels[i].setText("");
        }
        for (int i = 0; i < hand.size(); i++) {
            humanPlayerCardsLabels[i].setText(hand.get(i).getValue() + " " + hand.get(i).getSeed());
        }
    }

    public void setHumanPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        humanPlayerBankLabel.setText(bankWithoutMop.size() + " carte e " + mop.size() + " scope");
    }

    public void setCpuPlayerCards(List<Card> hand) {
        for (int i = 0; i < 3; i++) {
            cpuPlayerCardsLabels[i].setText("");
        }
        for (int i = 0; i < hand.size(); i++) {
            cpuPlayerCardsLabels[i].setText("Card"+i);
        }
    }

    public void setCpuPlayerBank(List<Card> bankWithoutMop, List<Card> mop) {
        cpuPlayerBankLabel.setText(bankWithoutMop.size() + " carte e " + mop.size() + " scope");
    }

    public void setDeck(Deck deck) {
        deckLabel.setText(""+deck.size());
    }

    public void setField(List<Card> field) {
        for (int i = 0; i < 8; i++) {
            fieldLabels[i].setText("");
        }
        for (int i = 0; i < field.size(); i++) {
            fieldLabels[i].setText(field.get(i).getValue() + " " + field.get(i).getSeed());
        }
    }

    public JLabel[] getHumanPlayerCardsLabels() {
        return humanPlayerCardsLabels;
    }
}
