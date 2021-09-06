package Account;

import Database.*;
import MainMenu.*;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfile extends JFrame implements ActionListener {

    JButton btnBack, btnEditDetails;

    private final int LEFT_LABELS_X = 127;
    private final int RIGHT_LABELS_X = 225;

    public MyProfile() {
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon backIcon = new ImageIcon("BackIcon.png");

        JPanel background = new JPanel();
        background.setBounds(0,0,500,700);
        background.setBackground(new Color(248,240,255));
        background.setVisible(true);

        btnBack = new JButton(backIcon);
        btnBack.setBounds(5,5,50,50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);

        // left labels
        JLabel lblFirstName = new JLabel("Име:");
        lblFirstName.setBounds(LEFT_LABELS_X,170, 150, 15);

        JLabel lblLastName = new JLabel("Фамилия:");
        lblLastName.setBounds(LEFT_LABELS_X, 220, 150, 15);

        JLabel lblPhoneNumber = new JLabel("Телефон:");
        lblPhoneNumber.setBounds(LEFT_LABELS_X, 270, 130, 15);

        JLabel lblNumOfListings = new JLabel("Брой обяви:");
        lblNumOfListings.setBounds(LEFT_LABELS_X, 320, 130, 15);

        // right labels
        JLabel lbl2FirstName = new JLabel(Database.getCurrentUserFirstName());
        lbl2FirstName.setBounds(RIGHT_LABELS_X, 170, 150, 15);

        JLabel lbl2LastName = new JLabel(Database.getCurrentUserLastName());
        lbl2LastName.setBounds(RIGHT_LABELS_X, 220, 150, 15);

        JLabel lbl2PhoneNumber = new JLabel(Database.getCurrentUserPhoneNumber());
        lbl2PhoneNumber.setBounds(RIGHT_LABELS_X, 270, 150, 15);

        JLabel lbl2NumOfListings = new JLabel(Integer.toString(Database.getCurrentUserListingCount()));
        lbl2NumOfListings.setBounds(RIGHT_LABELS_X, 320, 150, 15);


        btnEditDetails = new JButton("Телефон:");
        btnEditDetails.setBounds(100,265, 110, 25);
        btnEditDetails.setBackground(new Color(139,0,139));
        btnEditDetails.setForeground(Color.WHITE);
        btnEditDetails.setFocusable(false);
        btnEditDetails.addActionListener(this);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 700);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(btnBack, Integer.valueOf(1));
        layeredPane.add(lblFirstName, Integer.valueOf(2));
        layeredPane.add(lblLastName, Integer.valueOf(3));
        layeredPane.add(lblPhoneNumber, Integer.valueOf(4));
        layeredPane.add(lblNumOfListings, Integer.valueOf(5));
        layeredPane.add(lbl2FirstName, Integer.valueOf(6));
        layeredPane.add(lbl2LastName, Integer.valueOf(7));
        layeredPane.add(lbl2PhoneNumber, Integer.valueOf(8));
        layeredPane.add(lbl2NumOfListings, Integer.valueOf(9));
        layeredPane.add(btnEditDetails, Integer.valueOf(10));

        this.setTitle("Моят профил");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(460,570);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(layeredPane);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnBack) {
            this.dispose();
            new MainMenu();
        }
    }
}
