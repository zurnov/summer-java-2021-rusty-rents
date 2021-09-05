package Register;

import LogIn.LogIn;
import Database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Register extends JFrame implements ActionListener {

    private final boolean debugMode = false;

    JPanel panelContainer=new JPanel();
    //JPanel chooseUserTypePanel =new JPanel();
    JPanel mainRegisterPanel =new JPanel();
    JPanel secondaryRegisterPanel =new JPanel();
    CardLayout cardLayout = new CardLayout();

    JButton customerButton=new JButton("Renter");
    JButton landlordButton=new JButton("Landlord");
    JButton backToLogInScreenButton=new JButton("Back to Log in");
    JButton btnMainPanelNext =new JButton("Напред");
    JButton btnMainPanelBack =new JButton("Назад");
    JButton btnSecondaryPanelNext =new JButton("Напред");

    JTextField tfUsername;
    JPasswordField tfPassword;
    JPasswordField tfConfirmPassword;
    JTextField tfEmail;

    JTextField tfFirstName;
    JTextField tfLastName;
    JTextField tfPhoneNumber;

    public Register(){
        ImageIcon appIcon = new ImageIcon ("RustyRentsIcon.png");
        ImageIcon registrationIcon=new ImageIcon("RustyRentsLogo.png");
        ImageIcon secondPanelLogo=new ImageIcon("RustyRentsLogo.png");
        ImageIcon thirdPanelLogo=new ImageIcon("RustyRentsLogo.png");
        Image rustyRentsLogo=registrationIcon.getImage();
        Image newing = rustyRentsLogo.getScaledInstance(100,100,Image.SCALE_SMOOTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(appIcon.getImage());
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        registrationIcon=new ImageIcon(newing);
        secondPanelLogo=new ImageIcon(newing);
        thirdPanelLogo=new ImageIcon(newing);

        panelContainer.setLayout(cardLayout);
        //panelContainer.add(chooseUserTypePanel,"1");
        panelContainer.add(mainRegisterPanel,"2");
        panelContainer.add(secondaryRegisterPanel,"3");
        cardLayout.show(panelContainer,"1");

        // choose user type panel (deprecated)
        /*chooseUserTypePanel.setLayout(new BorderLayout());
        JLabel headerImage= new JLabel(registrationIcon);
        headerImage.setPreferredSize(new Dimension(100,100));
        JLabel accountOptionLabel=new JLabel("Choose your preferred option");

        customerButton.setForeground(Color.white);
        customerButton.setFocusable(false);
        customerButton.setBackground(new Color(139,0,139));
        customerButton.addActionListener(this);

        landlordButton.setForeground(Color.white);
        landlordButton.setFocusable(false);
        landlordButton.setBackground(new Color(139,0,139));
        landlordButton.addActionListener(this);

        backToLogInScreenButton.setForeground(Color.white);
        backToLogInScreenButton.setFocusable(false);
        backToLogInScreenButton.setBackground(new Color(139,0,139));
        backToLogInScreenButton.addActionListener(this);

        //subPanels
        JPanel subPanelForFirstPanel1=new JPanel();
        JPanel subPanelForFirstPanel2=new JPanel();
        JPanel subPanelForFirstPanel3=new JPanel();

        initializeSubPanels(subPanelForFirstPanel1,subPanelForFirstPanel2,subPanelForFirstPanel3);

        subPanelForFirstPanel1.add(headerImage);
        subPanelForFirstPanel2.add(accountOptionLabel,BorderLayout.SOUTH);
        subPanelForFirstPanel2.add(customerButton,BorderLayout.SOUTH);
        subPanelForFirstPanel2.add(landlordButton,BorderLayout.SOUTH);
        subPanelForFirstPanel3.add(backToLogInScreenButton);

        chooseUserTypePanel.add(subPanelForFirstPanel1,BorderLayout.NORTH);
        chooseUserTypePanel.add(subPanelForFirstPanel2,BorderLayout.CENTER);
        chooseUserTypePanel.add(subPanelForFirstPanel3,BorderLayout.SOUTH);

         */

        // main register panel
        mainRegisterPanel.setLayout(new BorderLayout());

        JLabel headerImageForSecondPanel=new JLabel(secondPanelLogo);
        JLabel usernameLabel= new JLabel("Потребителско име:");
        JLabel passwordLabel=new JLabel("Парола:                       ");
        JLabel confirmPasswordLabel=new JLabel("Повторете парола:  ");
        JLabel emailLabel=new JLabel("E-mail:                          ");

        tfUsername = new JTextField();
        tfUsername.setPreferredSize(new Dimension(70,20));
        tfPassword =new JPasswordField();
        tfPassword.setPreferredSize(new Dimension(70,20));
        tfPassword.setEchoChar('*');
        tfConfirmPassword =new JPasswordField();
        tfConfirmPassword.setPreferredSize(new Dimension(70,20));
        tfConfirmPassword.setEchoChar('*');
        tfEmail =new JTextField();
        tfEmail.setPreferredSize(new Dimension(70,20));

        btnMainPanelNext.addActionListener(this);
        btnMainPanelNext.setForeground(Color.white);
        btnMainPanelNext.setBackground(new Color(139,0,139));
        btnMainPanelBack.addActionListener(this);
        btnMainPanelBack.setForeground(Color.white);
        btnMainPanelBack.setBackground(new Color(139,0,139));

        //subPanels
        JPanel subPanelForSecondPanel1=new JPanel();
        JPanel subPanelForSecondPanel2=new JPanel();
        JPanel subPanelForSecondPanel3=new JPanel();
        initializeSubPanels(subPanelForSecondPanel1,subPanelForSecondPanel2,subPanelForSecondPanel3);

        subPanelForSecondPanel1.add(headerImageForSecondPanel);

        subPanelForSecondPanel2.add(usernameLabel);
        subPanelForSecondPanel2.add(tfUsername);
        subPanelForSecondPanel2.add(passwordLabel);
        subPanelForSecondPanel2.add(tfPassword);
        subPanelForSecondPanel2.add(confirmPasswordLabel);
        subPanelForSecondPanel2.add(tfConfirmPassword);
        subPanelForSecondPanel2.add(emailLabel);
        subPanelForSecondPanel2.add(tfEmail);

        subPanelForSecondPanel3.add(btnMainPanelNext);
        subPanelForSecondPanel3.add(btnMainPanelBack);

        mainRegisterPanel.add(subPanelForSecondPanel1,BorderLayout.NORTH);
        mainRegisterPanel.add(subPanelForSecondPanel2,BorderLayout.CENTER);
        mainRegisterPanel.add(subPanelForSecondPanel3,BorderLayout.SOUTH);

        // secondary register panel
        secondaryRegisterPanel.setLayout(new BorderLayout());

        // labels
        JLabel headerForThirdPanel=new JLabel(thirdPanelLogo);
        JLabel lblFirstName=new JLabel("Име:             ");
        JLabel lblLastName=new JLabel("Фамилия:   ");
        JLabel lblPhoneNumber=new JLabel("Тел. номер:");

        // text fields
        tfFirstName=new JTextField();
        tfFirstName.setPreferredSize(new Dimension(120,20));
        tfLastName=new JTextField();
        tfLastName.setPreferredSize(new Dimension(120,20));
        tfPhoneNumber=new JTextField();
        tfPhoneNumber.setPreferredSize(new Dimension(120,20));

        btnSecondaryPanelNext.addActionListener(this);
        btnSecondaryPanelNext.setForeground(Color.white);
        btnSecondaryPanelNext.setBackground(new Color(139,0,139));

        //subPanels
        JPanel subPanelForThirdPanel1=new JPanel();
        JPanel subPanelForThirdPanel2=new JPanel();
        JPanel subPanelForThirdPanel3=new JPanel();

        initializeSubPanels(subPanelForThirdPanel1,subPanelForThirdPanel2,subPanelForThirdPanel3);

        subPanelForThirdPanel1.add(headerForThirdPanel);

        subPanelForThirdPanel2.add(lblFirstName);
        subPanelForThirdPanel2.add(tfFirstName);
        subPanelForThirdPanel2.add(lblLastName);
        subPanelForThirdPanel2.add(tfLastName);
        subPanelForThirdPanel2.add(lblPhoneNumber);
        subPanelForThirdPanel2.add(tfPhoneNumber);

        subPanelForThirdPanel3.add(btnSecondaryPanelNext);

        secondaryRegisterPanel.add(subPanelForThirdPanel1,BorderLayout.NORTH);
        secondaryRegisterPanel.add(subPanelForThirdPanel2,BorderLayout.CENTER);
        secondaryRegisterPanel.add(subPanelForThirdPanel3,BorderLayout.SOUTH);

        this.add(panelContainer);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private static void initializeSubPanels(JPanel panel1,JPanel panel2,JPanel panel3){
        panel1.setBackground(new Color(248,240,255));
        panel2.setBackground(new Color(248,240,255));
        panel3.setBackground(new Color(248,240,255));

        panel1.setPreferredSize(new Dimension(200,130));
        panel2.setPreferredSize(new Dimension(160,150));
        panel3.setPreferredSize(new Dimension(200,50));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==customerButton){
            cardLayout.show(panelContainer,"2");
        }
        if(e.getSource()==landlordButton){
            cardLayout.show(panelContainer,"2");
        }
        if(e.getSource()==backToLogInScreenButton){
            this.dispose();
            new LogIn();
        }
        if(e.getSource()== btnMainPanelBack){
            //cardLayout.show(panelContainer,"1");
            this.dispose();
            new LogIn();
        }
        if(e.getSource()== btnMainPanelNext){

            if (!debugMode) {
                // Case when there is an empty field
                if (tfUsername.getText().equals("")
                        || tfPassword.getPassword().length == 0
                        || tfConfirmPassword.getPassword().length == 0
                        || tfEmail.getText().equals("")) {
                    // TODO SWING : Label "Има непопълнени полета"
                    System.out.println("Empty fields.");
                }
                // Case when Password and Confirm Password do not match
                else if (!Arrays.equals(tfPassword.getPassword(), tfConfirmPassword.getPassword())) {
                    // TODO SWING : Label "Паролата не съвпада с горната"
                    System.out.println("Password and Confirm password do not match.");
                } else {
                    Database.addNewUser(tfUsername.getText(), new String(tfPassword.getPassword()), tfEmail.getText());
                    //Database.addNewLandlord(usernameTextField.getText(), new String(passwordTextField.getPassword()), emailTextField.getText());
                    cardLayout.show(panelContainer, "3");
                }
            }
            else {
                cardLayout.show(panelContainer, "3");
            }

        }

        if(e.getSource()== btnSecondaryPanelNext){

            if (tfFirstName.getText().isBlank() || tfLastName.getText().isBlank() || tfPhoneNumber.getText().isBlank())
                System.out.println("Empty fields detected.");
            else {
                Database.addUserProfileFor(tfUsername.getText(), tfFirstName.getText(), tfLastName.getText(), tfPhoneNumber.getText());
                this.dispose();
                new PopUpWindow();
            }

        }

    }
}
