package AppartmentActions;

import MainMenu.LandLordMainMenu;
import MainMenu.RenterMainMenu;
import Register.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SellAppartment extends JFrame implements ActionListener {

    JButton backButton;
    JComboBox temp1,city;
    JLayeredPane layeredPane;
    String test;
    String[] temp = {"1", "2"};

    public SellAppartment() {
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");
        ImageIcon backIcon = new ImageIcon("BackIcon.png");
        ImageIcon APIPlaceholder = new ImageIcon("GooglePlaceholder.png");

        JLabel placeholder = new JLabel();
        placeholder.setIcon(APIPlaceholder);
        placeholder.setBounds(200, 0, 300, 400);

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


        String[] cityArray = {"", "Варна", "София", "Пловдив", "Хасково"};
        city = new JComboBox(cityArray);
        city.setBounds(5, 60, 100, 50);
        city.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Object source = e.getSource();
                    if (source instanceof JComboBox) {
                        Object selectedItem = city.getSelectedItem();
                        if ("Варна".equals(selectedItem)) {
                            temp1 = new JComboBox(temp);
                            temp1.setBounds(5, 130, 100, 50);
                            layeredPane.add(temp1, Integer.valueOf(3));
                        }
                        else if ("София".equals(selectedItem)) {
                            temp1 = new JComboBox(temp);
                            temp1.setBounds(5, 130, 100, 50);
                            layeredPane.add(temp1, Integer.valueOf(3));
                        }
                        else if ("".equals(selectedItem)) {
                            temp1.setVisible(false);
                        }
                    }
                }
            }
        });

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 490, 700);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(backButton, Integer.valueOf(1));
        layeredPane.add(city, Integer.valueOf(2));
        layeredPane.add(placeholder, Integer.valueOf(4));


        this.setTitle("Sell Apartment PLACEHOLDER");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,400);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            if (Register.getCustomer().equalsIgnoreCase("LandLord")) {
                this.dispose();
                new LandLordMainMenu();
            }
            else if (Register.getCustomer().equalsIgnoreCase("Renter")) {
                this.dispose();
                new RenterMainMenu();
            }
        }
    }


}
