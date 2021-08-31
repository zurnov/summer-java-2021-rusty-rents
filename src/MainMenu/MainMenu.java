package MainMenu;

import Account.MyProfile;
import AppartmentActions.BuyAppartment;
import LogIn.LogIn;
import Options.Options;
import Register.Register;
import AppartmentActions.SellAppartment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener{

    JButton settingsButton, myProfileButton, myListingsButton, viewListingsButon, logOutButton;
    JLabel label2 = new JLabel();

    public MainMenu() {

        ImageIcon backgroundImage = new ImageIcon("CityBackgroundImage.jpg");
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon settingsIcon = new ImageIcon("SettingsIcon.png");
        ImageIcon appLogo = new ImageIcon("RustyRentsLogo.png");
        ImageIcon logOutImage = new ImageIcon("LogOutImage.png");

        logOutButton = new JButton(logOutImage);
        logOutButton.setBounds(5,5,50,50);
        logOutButton.setFocusable(false);
        logOutButton.addActionListener(this);
        logOutButton.setOpaque(false);
        logOutButton.setContentAreaFilled(false);
        logOutButton.setBorderPainted(false);

        settingsButton = new JButton(settingsIcon);
        settingsButton.setBounds(427, 5, 50, 50);
        settingsButton.setFocusable(false);
        settingsButton.addActionListener(this);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);

        myProfileButton = new JButton();
        myProfileButton.setText("МОЯТ ПРОФИЛ");
        myProfileButton.setFocusable(false);
        myProfileButton.setBounds(325, 550, 150, 100);
        myProfileButton.addActionListener(this);
        myProfileButton.setBackground(new Color(139,0,139));
        myProfileButton.setForeground(Color.white);

        myListingsButton = new JButton();
        myListingsButton.setText("МОИТЕ ОБЯВИ");
        myListingsButton.setFocusable(false);
        myListingsButton.setBounds(165, 550, 150, 100);
        myListingsButton.addActionListener(this);
        myListingsButton.setBackground(new Color(139,0,139));
        myListingsButton.setForeground(Color.white);

        viewListingsButon = new JButton();
        viewListingsButon.setText("ВИЖ ОБЯВИ");
        viewListingsButon.setFocusable(false);
        viewListingsButon.setBounds(5, 550, 150, 100);
        viewListingsButon.addActionListener(this);
        viewListingsButon.setBackground(new Color(139,0,139));
        viewListingsButon.setForeground(Color.white);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, 490, 700);

        JLabel logoImage = new JLabel();
        logoImage.setIcon(appLogo);
        logoImage.setBounds(130, 0, 300, 300);

        JLabel greetingsText = new JLabel("ДОБРЕ ДОШЪЛ, PLACEHOLDER!");
        greetingsText.setBounds(150, 230, 200, 50);
        greetingsText.setForeground(new Color(139,0,139));

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.add(backgroundLabel);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 490, 700);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));
        layeredPane.add(logoImage, Integer.valueOf(1));
        layeredPane.add(settingsButton, Integer.valueOf(2));
        layeredPane.add(myListingsButton, Integer.valueOf(3));
        layeredPane.add(viewListingsButon, Integer.valueOf(4));
        layeredPane.add(myProfileButton, Integer.valueOf(5));
        layeredPane.add(logOutButton, Integer.valueOf(6));
        layeredPane.add(greetingsText, Integer.valueOf(7));

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
            this.dispose();
            new Options();
        }
        else if (e.getSource()== myListingsButton) {
            this.dispose();
            new BuyAppartment();
        }
        else if (e.getSource()== viewListingsButon) {
            this.dispose();
            new SellAppartment();
        }
        else if (e.getSource()== myProfileButton) {
            this.dispose();
            new MyProfile();
        }
        else if (e.getSource()==logOutButton) {
            Register.setCustomer("");
            this.dispose();
            new LogIn();
        }
    }
}
