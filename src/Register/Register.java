package Register;

import LogIn.LogIn;
import Database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Register extends JFrame implements ActionListener {
    static String customer;

    JPanel panelContainer=new JPanel();
    JPanel firstPanel=new JPanel();
    JPanel secondPanel=new JPanel();
    JPanel thirdPanel=new JPanel();
    CardLayout cardLayout = new CardLayout();

    JButton customerButton=new JButton("Renter");
    JButton landlordButton=new JButton("Landlord");
    JButton backToLogInScreenButton=new JButton("Back to Log in");
    JButton nextStepButton=new JButton("Next");
    JButton backButton=new JButton("Back");
    JButton finalNextButton=new JButton("Next");

    JComboBox customerStatusComboBox;
    JComboBox preferredLocationComboBox;

    JTextField usernameTextField;
    JPasswordField passwordTextField;
    JPasswordField confirmPasswordTextField;
    JTextField emailTextField;

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
        panelContainer.add(firstPanel,"1");
        panelContainer.add(secondPanel,"2");
        panelContainer.add(thirdPanel,"3");
        cardLayout.show(panelContainer,"1");

        //firstPanel
        firstPanel.setLayout(new BorderLayout());
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

        firstPanel.add(subPanelForFirstPanel1,BorderLayout.NORTH);
        firstPanel.add(subPanelForFirstPanel2,BorderLayout.CENTER);
        firstPanel.add(subPanelForFirstPanel3,BorderLayout.SOUTH);




        //secondPanel
        secondPanel.setLayout(new BorderLayout());

        JLabel headerImageForSecondPanel=new JLabel(secondPanelLogo);
        JLabel usernameLabel= new JLabel("Username:");
        JLabel passwordLabel=new JLabel("Password:");
        JLabel confirmPasswordLabel=new JLabel("Confirm password:");
        JLabel emailLabel=new JLabel("E-mail:");

        usernameTextField= new JTextField();
        usernameTextField.setPreferredSize(new Dimension(70,20));
        passwordTextField=new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(70,20));
        passwordTextField.setEchoChar('*');
        confirmPasswordTextField=new JPasswordField();
        confirmPasswordTextField.setPreferredSize(new Dimension(70,20));
        confirmPasswordTextField.setEchoChar('*');
        emailTextField=new JTextField();
        emailTextField.setPreferredSize(new Dimension(70,20));

        nextStepButton.addActionListener(this);
        nextStepButton.setForeground(Color.white);
        nextStepButton.setBackground(new Color(139,0,139));
        backButton.addActionListener(this);
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(139,0,139));

        //subPanels
        JPanel subPanelForSecondPanel1=new JPanel();
        JPanel subPanelForSecondPanel2=new JPanel();
        JPanel subPanelForSecondPanel3=new JPanel();
        initializeSubPanels(subPanelForSecondPanel1,subPanelForSecondPanel2,subPanelForSecondPanel3);

        subPanelForSecondPanel1.add(headerImageForSecondPanel);

        subPanelForSecondPanel2.add(usernameLabel);
        subPanelForSecondPanel2.add(usernameTextField);
        subPanelForSecondPanel2.add(passwordLabel);
        subPanelForSecondPanel2.add(passwordTextField);
        subPanelForSecondPanel2.add(confirmPasswordLabel);
        subPanelForSecondPanel2.add(confirmPasswordTextField);
        subPanelForSecondPanel2.add(emailLabel);
        subPanelForSecondPanel2.add(emailTextField);;

        subPanelForSecondPanel3.add(nextStepButton);
        subPanelForSecondPanel3.add(backButton);

        secondPanel.add(subPanelForSecondPanel1,BorderLayout.NORTH);
        secondPanel.add(subPanelForSecondPanel2,BorderLayout.CENTER);
        secondPanel.add(subPanelForSecondPanel3,BorderLayout.SOUTH);



        //thirdPanel
        thirdPanel.setLayout(new BorderLayout());

        JLabel headerForThirdPanel=new JLabel(thirdPanelLogo);
        JLabel cityLabel=new JLabel("City:");
        JLabel provinceLabel=new JLabel("Province:");
        JLabel customerStatusLabel=new JLabel("Status:");
        JLabel prefLocationLabel=new JLabel("Preferred location:");

        JTextField cityTextField=new JTextField();
        cityTextField.setPreferredSize(new Dimension(120,20));
        JTextField provinceTextField=new JTextField();
        provinceTextField.setPreferredSize(new Dimension(120,20));


        String[] customerStatus={"Student","Average class","Wealthy","Poor"};
        customerStatusComboBox=new JComboBox(customerStatus);
        String[] desiredLocation={"Near Universities","Near the center","Wealthy neighbourhood","Suburbs","Calm neighbourhood"};
        preferredLocationComboBox=new JComboBox(desiredLocation);

        finalNextButton.addActionListener(this);
        finalNextButton.setForeground(Color.white);
        finalNextButton.setBackground(new Color(139,0,139));

        //subPanels
        JPanel subPanelForThirdPanel1=new JPanel();
        JPanel subPanelForThirdPanel2=new JPanel();
        JPanel subPanelForThirdPanel3=new JPanel();

        initializeSubPanels(subPanelForThirdPanel1,subPanelForThirdPanel2,subPanelForThirdPanel3);

        subPanelForThirdPanel1.add(headerForThirdPanel);

        subPanelForThirdPanel2.add(cityLabel);
        subPanelForThirdPanel2.add(cityTextField);
        subPanelForThirdPanel2.add(provinceLabel);
        subPanelForThirdPanel2.add(provinceTextField);
        subPanelForThirdPanel2.add(customerStatusLabel);
        subPanelForThirdPanel2.add(customerStatusComboBox);
        subPanelForThirdPanel2.add(prefLocationLabel);
        subPanelForThirdPanel2.add(preferredLocationComboBox);

        subPanelForThirdPanel3.add(finalNextButton);

        thirdPanel.add(subPanelForThirdPanel1,BorderLayout.NORTH);
        thirdPanel.add(subPanelForThirdPanel2,BorderLayout.CENTER);
        thirdPanel.add(subPanelForThirdPanel3,BorderLayout.SOUTH);

        this.add(panelContainer);
        this.pack();
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

    public static String getCustomer() {
        return customer;
    }
    public static void setCustomer(String newVal) {
        customer = newVal;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==customerButton){
            customer="Renter";
            cardLayout.show(panelContainer,"2");
        }
        if(e.getSource()==landlordButton){
            customer="Landlord";
            cardLayout.show(panelContainer,"2");
        }
        if(e.getSource()==backToLogInScreenButton){
            this.dispose();
            new LogIn();
        }
        if(e.getSource()==backButton){
            cardLayout.show(panelContainer,"1");
        }
        if(e.getSource()==nextStepButton){

            // check if any empty fields
            if (usernameTextField.getText().equals("")
                    || passwordTextField.getPassword().length == 0
                    || confirmPasswordTextField.getPassword().length == 0
                    || emailTextField.getText().equals(""))
                System.out.println("Empty fields.");
            else if (!Arrays.equals(passwordTextField.getPassword(), confirmPasswordTextField.getPassword())) {
                // TODO : Turn this into a label
                System.out.println("Password and Confirm password do not match.");
            }
            else {
                if (customer.equals("Renter")) {
                    Database.addNewUser(usernameTextField.getText(), new String(passwordTextField.getPassword()), emailTextField.getText());
                    cardLayout.show(panelContainer, "3");
                }
                if (customer.equals("Landlord")) {
                    Database.addNewLandlord(usernameTextField.getText(), new String(passwordTextField.getPassword()), emailTextField.getText());
                    this.dispose();
                    new PopUpWindow();
                }
            }
        }
        if(e.getSource()==finalNextButton){
            this.dispose();
            new PopUpWindow();

            //need to add pop-up window to inform the user that
            //their account is successfully created and they need to log into it
        }
    }
}
