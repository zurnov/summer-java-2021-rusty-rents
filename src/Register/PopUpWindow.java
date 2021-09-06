package Register;

import LogIn.LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpWindow extends JFrame implements ActionListener {

    JButton backToLogInButton;
    PopUpWindow() {
        ImageIcon logo = new ImageIcon("RustyRentsIcon.png");

        backToLogInButton = new JButton();
        backToLogInButton.setBounds(200, 60, 100, 50);
        backToLogInButton.setText("ОК");
        backToLogInButton.addActionListener(this);
        backToLogInButton.setFocusable(false);
        backToLogInButton.setBackground(new Color(139,0,139));
        backToLogInButton.setForeground(Color.WHITE);

        JLabel text = new JLabel("Вие се регистрирахте успешно! Моля, логнете се с Вашите данни.");
        text.setBounds(10, 0,500,30);

        JPanel background = new JPanel();
        background.setBounds(0,0,500,160);
        background.setBackground(new Color(248,240,255));
        background.setVisible(true);

        JLayeredPane pain = new JLayeredPane();
        pain.setBounds(0, 0, 470, 300);
        pain.add(background, Integer.valueOf(0));
        pain.add(text, Integer.valueOf(1));
        pain.add(backToLogInButton, Integer.valueOf(2));
        pain.setOpaque(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setIconImage(logo.getImage());
        this.setTitle("Успешна регистрация");

        this.setSize(500, 160);
        this.setResizable(false);

        this.add(pain);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backToLogInButton) {
            this.dispose();
            new LogIn();
        }
    }
}
