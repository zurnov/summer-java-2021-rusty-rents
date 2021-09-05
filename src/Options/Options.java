package Options;

import MainMenu.MainMenu;
import Register.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame implements ActionListener {
    JButton resolutionButton=new JButton();
    JButton termsAndConditionsButton=new JButton();
    JButton changeEmailButton=new JButton();
    JButton changePasswordButton=new JButton();
    JButton changeThemeButton=new JButton();
    JButton backButton=new JButton();


    JLayeredPane layeredPane=new JLayeredPane();
    public Options(){
        ImageIcon optionsIcon=new ImageIcon("RustyRentsLogo.png");
        ImageIcon backIcon = new ImageIcon("BackIcon.png");

        layeredPane.setBounds(0,0,500,500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(optionsIcon.getImage());
        this.setSize(500,500);


        resolutionButton.setBounds(120,50,250,50);
        resolutionButton.setText("Resolution");
        resolutionButton.setBackground(new Color(139,0,139));
        resolutionButton.setForeground(Color.white);
        resolutionButton.setFocusable(false);

        changeThemeButton.setBounds(120,130,250,50);
        changeThemeButton.setText("Change Theme");
        changeThemeButton.setBackground(new Color(139,0,139));
        changeThemeButton.setForeground(Color.white);
        changeThemeButton.setFocusable(false);

        changeEmailButton.setBounds(120,210,250,50);
        changeEmailButton.setText("Change Email");
        changeEmailButton.addActionListener(this);
        changeEmailButton.setBackground(new Color(139,0,139));
        changeEmailButton.setForeground(Color.white);
        changeEmailButton.setFocusable(false);

        changePasswordButton.setBounds(120,290,250,50);
        changePasswordButton.setText("ChangePassword");
        changePasswordButton.addActionListener(this);
        changePasswordButton.setBackground(new Color(139,0,139));
        changePasswordButton.setForeground(Color.white);
        changePasswordButton.setFocusable(false);

        termsAndConditionsButton.setBounds(120,370,250,50);
        termsAndConditionsButton.setText("Terms and Conditions");
        termsAndConditionsButton.setBackground(new Color(139,0,139));
        termsAndConditionsButton.setForeground(Color.white);
        termsAndConditionsButton.setFocusable(false);

        backButton = new JButton(backIcon);
        backButton.setBounds(0,0,50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        layeredPane.add(backButton,Integer.valueOf(0));
        layeredPane.add(resolutionButton,Integer.valueOf(1));
        layeredPane.add(changeThemeButton,Integer.valueOf(2));
        layeredPane.add(changeEmailButton,Integer.valueOf(3));
        layeredPane.add(changePasswordButton,Integer.valueOf(4));
        layeredPane.add(termsAndConditionsButton,Integer.valueOf(5));
        layeredPane.setVisible(true);

        layeredPane.setBackground(new Color(248,240,255));
        layeredPane.setOpaque(true);
//        optionsPanel.add(layeredPane);
        this.add(layeredPane);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==changeEmailButton) {
            new ChangeEmail();
        }

        else if (e.getSource()==changePasswordButton) {
            new ChangePassword();
        }

        else if (e.getSource() == backButton) {
                this.dispose();
                new MainMenu();
        }
    }
}