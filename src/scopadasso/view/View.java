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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Andrea
 */
public class View {
    private JFrame frame;
    private JPanel mainPanel, centralPanel, humanPlayerPanel, cpuPlayerPanel;
    
    public View(){
        //INITIALIZATIONS
        frame = new JFrame("Scopa d'Asso");
        mainPanel = new JPanel(new BorderLayout());
        centralPanel = new JPanel(new GridLayout(2, 4, 0, 0));
        humanPlayerPanel = new JPanel(new GridLayout(1, 3, 0, 0));
        cpuPlayerPanel = new JPanel(new GridLayout(1, 3, 0, 0));
        
        cpuPlayerPanel.add(new JLabel("Card1"));
        cpuPlayerPanel.add(new JLabel("Card2"));
        cpuPlayerPanel.add(new JLabel("Card3"));
        
        //ASSEMBLY
        mainPanel.add(humanPlayerPanel, BorderLayout.WEST);
        mainPanel.add(centralPanel, BorderLayout.CENTER);
        mainPanel.add(cpuPlayerPanel, BorderLayout.EAST);
        
        frame.add(mainPanel);
        
        //LAST SETTINGS AND SHOW
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
