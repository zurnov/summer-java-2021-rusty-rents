package Account;

import MainMenu.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfile extends JFrame implements ActionListener {

    JButton backButton;

    public MyProfile() {
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon backIcon = new ImageIcon("BackIcon.png");

        JPanel background = new JPanel();
        background.setBounds(0,0,500,700);
        background.setBackground(new Color(248,240,255));
        background.setVisible(true);

        backButton = new JButton(backIcon);
        backButton.setBounds(5,5,50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);


        JLabel moneySpent = new JLabel("Похарчени пари: ");
        moneySpent.setBounds(135,170, 150, 15);

        JLabel positiveRating = new JLabel("% Позитивен рейтинг: ");
        positiveRating.setBounds(135, 220, 150, 15);

        JLabel username = new JLabel("Username: ");
        username.setBounds(135, 270, 130, 15);

        JLabel email = new JLabel("Email: ");
        email.setBounds(135, 320, 130, 15);


        JLabel moneySpentData = new JLabel("PLACEHOLDER");
        moneySpentData.setBounds(245, 170, 100, 15);

        JLabel positiveRatingData = new JLabel("PLACEHOLDER");
        positiveRatingData.setBounds(275, 220, 100, 15);

        JLabel usernameData = new JLabel("PLACEHOLDER");
        usernameData.setBounds(205, 270, 100, 15);

        JLabel emailData = new JLabel("PLACEHOLDER");
        emailData.setBounds(175, 320, 100, 15);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 700);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(backButton, Integer.valueOf(1));
        layeredPane.add(moneySpent, Integer.valueOf(2));
        layeredPane.add(positiveRating, Integer.valueOf(3));
        layeredPane.add(username, Integer.valueOf(4));
        layeredPane.add(email, Integer.valueOf(5));
        layeredPane.add(moneySpentData, Integer.valueOf(6));
        layeredPane.add(positiveRatingData, Integer.valueOf(7));
        layeredPane.add(usernameData, Integer.valueOf(8));
        layeredPane.add(emailData, Integer.valueOf(9));

        this.setTitle("Renter MyProfile");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,700);
        this.setVisible(true);
        this.add(layeredPane);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton) {
            this.dispose();
            new MainMenu();
        }
    }
}
