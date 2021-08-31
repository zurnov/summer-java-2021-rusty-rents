package LogIn;

import MainMenu.MainMenu;
import Register.Register;
import Database.Database;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame implements ActionListener {
    JButton logInButton;
    JButton registerButton;

    JTextField usernameTextField;
    JPasswordField passwordTextField;

    public LogIn(){
        ImageIcon appIcon = new ImageIcon ("RustyRentsIcon.png");
        ImageIcon logInIcon=new ImageIcon("RustyRentsLogo.png");
        Image rustyRentsLogo=logInIcon.getImage();
        Image newing = rustyRentsLogo.getScaledInstance(100,100,Image.SCALE_SMOOTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(appIcon.getImage());
        this.setSize(500,500);
        this.setLayout(new BorderLayout());

        logInIcon= new ImageIcon(newing);

        JPanel headerPanel=new JPanel();
        JPanel bodyPanel=new JPanel();
        JPanel footerPanel=new JPanel();

        headerPanel.setPreferredSize(new Dimension(100,100));
        bodyPanel.setPreferredSize(new Dimension(100,100));
        footerPanel.setPreferredSize(new Dimension(100,70));
        headerPanel.setBackground(new Color(248,240,255));
        bodyPanel.setBackground(new Color(248,240,255));
        footerPanel.setBackground(new Color(248,240,255));


        this.add(headerPanel,BorderLayout.NORTH);
        this.add(bodyPanel,BorderLayout.CENTER);
        this.add(footerPanel,BorderLayout.SOUTH);
        this.setSize(270,500);
        this.setResizable(false);

        JLabel headerImage = new JLabel(logInIcon);
        headerPanel.add(headerImage,BorderLayout.CENTER);
        headerImage.setPreferredSize(new Dimension(100,100));

        JLabel usernameLabel=new JLabel("Username: ");
        usernameLabel.setPreferredSize(new Dimension(100,100));
        bodyPanel.add(usernameLabel,BorderLayout.CENTER);

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(100,20));
        bodyPanel.add(usernameTextField);

        JLabel passwordLabel=new JLabel("Password: ");
        passwordLabel.setPreferredSize(new Dimension(100,100));
        bodyPanel.add(passwordLabel);

        passwordTextField=new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(100,20));
        passwordTextField.setEchoChar('*');
        bodyPanel.add(passwordTextField);

        logInButton = new JButton("Log In");
        logInButton.addActionListener(this);
        logInButton.setToolTipText("Log into your existing account");
        logInButton.setBackground(new Color(139,0,139));
        logInButton.setForeground(Color.WHITE);
        footerPanel.add(logInButton);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registerButton.setToolTipText("Create a account for our platform");
        registerButton.setBackground(new Color(139,0,139));
        registerButton.setForeground(Color.WHITE);
        footerPanel.add(registerButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton){
            this.dispose();
            new Register();
        }
        if(e.getSource()==logInButton){
            // Username and Password combination exist in Database i.e. Login is successful
            if (Database.isValidLogin(usernameTextField.getText(), new String(passwordTextField.getPassword()))) {
                Database.setCurrentUser(1);
                this.dispose();
                new MainMenu();
            }
            else {
                // TODO SWING : Red label for failed login attempt ("Неправилно въведени данни")
            }
        }
    }
}