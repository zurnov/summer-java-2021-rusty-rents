package test;

import test.LandLordMainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenterMainMenu extends JFrame implements ActionListener{


    JButton settingsButton, accountButton, buyAppartmentButton, rentAppartmentButton;
    JLabel label2 = new JLabel();

    RenterMainMenu() {

        ImageIcon backgroundImage = new ImageIcon("CityBackgroundImage.jpg");
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon settingsIcon = new ImageIcon("SettingsIcon.png");
        ImageIcon appLogo = new ImageIcon("RustyRentsLogo.png");

        settingsButton = new JButton(settingsIcon);
        settingsButton.setBounds(427, 5, 50, 50);
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);

        accountButton = new JButton();
        accountButton.setText("АКАУНТ");
        accountButton.setFocusable(false);
        accountButton.setOpaque(false);
        accountButton.setContentAreaFilled(true);
        accountButton.setBorderPainted(true);
        accountButton.setBounds(325, 550, 150, 100);
        accountButton.addActionListener(this);

        buyAppartmentButton = new JButton();
        buyAppartmentButton.setText("КУПИ");
        buyAppartmentButton.setFocusable(false);
        buyAppartmentButton.setOpaque(false);
        buyAppartmentButton.setContentAreaFilled(true);
        buyAppartmentButton.setBorderPainted(true);
        buyAppartmentButton.setBounds(165, 550, 150, 100);
        buyAppartmentButton.addActionListener(this);

        rentAppartmentButton = new JButton();
        rentAppartmentButton.setText("НАЕМИ");
        rentAppartmentButton.setFocusable(false);
        rentAppartmentButton.setOpaque(false);
        rentAppartmentButton.setContentAreaFilled(true);
        rentAppartmentButton.setBorderPainted(true);
        rentAppartmentButton.setBounds(5, 550, 150, 100);
        rentAppartmentButton.addActionListener(this);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, 490, 700);

        JLabel logoImage = new JLabel();
        logoImage.setIcon(appLogo);
        logoImage.setBounds(130, 0, 300, 300);

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.add(backgroundLabel);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 700);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(logoImage, Integer.valueOf(1));
        layeredPane.add(settingsButton, Integer.valueOf(2));
        layeredPane.add(buyAppartmentButton, Integer.valueOf(3));
        layeredPane.add(rentAppartmentButton, Integer.valueOf(4));
        layeredPane.add(accountButton, Integer.valueOf(5));

        this.setIconImage(appIcon.getImage());
        this.setTitle("Rusty Rents test.Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,700);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==settingsButton) {
            LandLordMainMenu test = new LandLordMainMenu();
            test.add(label2);
        }
    }
}
