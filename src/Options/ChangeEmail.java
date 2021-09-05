package Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.Database;

public class ChangeEmail extends JFrame implements ActionListener {

    JButton changeEmail, cancelOperation;
    Boolean isCurrentEmailCorrect, isConfirmationSuccessful;
    JPanel background;
    JLabel currentEmail, newEmail, emailsNotMatching, confirmEmail;
    JTextField currentEmailData, newEmailData, confirmEmailData;
    String getNewEmail, getConfirmEmail;
    JLayeredPane layeredPane;
    ImageIcon appIcon;

    public ChangeEmail() {
        appIcon = new ImageIcon("RustyRentsIcon.png");


        background = new JPanel();
        background.setBounds(0,0,500,700);
        background.setBackground(new Color(248,240,255));
        background.setVisible(true);


        currentEmail = new JLabel("Сегашен email: ");
        currentEmail.setBounds(120, 21, 120, 15);

        newEmail = new JLabel("Нов email: ");
        newEmail.setBounds(150, 80, 120, 15);

        confirmEmail = new JLabel("Потвърди email: ");
        confirmEmail.setBounds(115, 140, 150, 15);

        emailsNotMatching = new JLabel("Имейлите не съвпадат.");
        emailsNotMatching.setBounds(170,170,150,30);
        emailsNotMatching.setForeground(Color.RED);
        emailsNotMatching.setVisible(false);


        currentEmailData = new JTextField();
        currentEmailData.setBounds(220, 16, 195, 30);

        newEmailData = new JTextField();
        newEmailData.setBounds(220, 75, 195, 30);

        confirmEmailData = new JTextField();
        confirmEmailData.setBounds(220, 135, 195, 30);


        changeEmail = new JButton("Смени email");
        changeEmail.setBounds(70, 200, 150, 50);
        changeEmail.setFocusable(false);
        changeEmail.addActionListener(this);
        changeEmail.setBackground(new Color(139,0,139));
        changeEmail.setForeground(Color.WHITE);

        cancelOperation = new JButton("Отказ");
        cancelOperation.setBounds(260, 200, 150 , 50);
        cancelOperation.setFocusable(false);
        cancelOperation.addActionListener(this);
        cancelOperation.setBackground(new Color(139,0,139));
        cancelOperation.setForeground(Color.WHITE);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 300);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(currentEmail, Integer.valueOf(1));
        layeredPane.add(newEmail, Integer.valueOf(2));
        layeredPane.add(confirmEmail, Integer.valueOf(3));
        layeredPane.add(currentEmailData, Integer.valueOf(4));
        layeredPane.add(newEmailData, Integer.valueOf(5));
        layeredPane.add(confirmEmailData, Integer.valueOf(6));
        layeredPane.add(changeEmail, Integer.valueOf(7));
        layeredPane.add(cancelOperation, Integer.valueOf(8));
        layeredPane.add(emailsNotMatching, Integer.valueOf(9));


        this.setTitle("Смяна на email");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,300);
        this.add(layeredPane);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==changeEmail) {

            getNewEmail = newEmailData.getText();
            getConfirmEmail = confirmEmailData.getText();

            isConfirmationSuccessful = (getNewEmail.equals(getConfirmEmail));

            if (isConfirmationSuccessful && Database.checkEmailMatch(currentEmailData.getText())){
                Database.changeEmail(getNewEmail);
            }
            else {
                // TODO SWING : Label "Грешно въведен настоящ имейл" under text field for current email
                System.out.println("Current email does not match with input data");
            }

            if (!isConfirmationSuccessful) {
                emailsNotMatching.setVisible(true);
            }
            else {
                emailsNotMatching.setVisible(false);
            }

        }
        else if (e.getSource()==cancelOperation) {
            this.dispose();
        }
    }
}
