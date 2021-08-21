package PLACEHOLDER;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellAppartment extends JFrame implements ActionListener {

    JButton backButton;

    SellAppartment() {
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon backIcon = new ImageIcon("BackIcon.png");

        backButton = new JButton(backIcon);
        backButton.setBounds(5,5,50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 490, 700);
        layeredPane.add(backButton, Integer.valueOf(0));

        this.setTitle("Sell Apartment PLACEHOLDER");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,700);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
