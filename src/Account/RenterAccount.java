package Account;

import MainMenu.RenterMainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RenterAccount extends JFrame implements ActionListener {

    JButton backButton, changeEmail, changePassword;

    public RenterAccount() {
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

        changeEmail = new JButton("Смени email");
        changeEmail.setBounds(70, 560, 150, 50);
        changeEmail.setBackground(new Color(139,0,139));
        changeEmail.setForeground(Color.WHITE);
        changeEmail.setFocusable(false);

        changePassword = new JButton("Смени парола");
        changePassword.setBounds(255, 560, 150, 50);
        changePassword.setBackground(new Color(139,0,139));
        changePassword.setForeground(Color.WHITE);
        changePassword.setFocusable(false);

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
        layeredPane.add(changeEmail, Integer.valueOf(10));
        layeredPane.add(changePassword, Integer.valueOf(11));

        this.setTitle("Renter Account");
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
            new RenterMainMenu();
        }
    }
}
