package Listings;

import Database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddListing extends JFrame implements ActionListener {

    JLabel lblListingTitle, lblCityName, lblCityQuarter, lblStreetName, lblStreetNumber, lblFloor, lblDoorNumber, lblPropertyType, lblPropertyArea, lblPrice, lblPhoneNumber, lblEditMessage;
    JTextField tfListingTitle, tfCityQuarter, tfStreetName, tfStreetNumber, tfFloor, tfDoorNumber, tfPropertyArea, tfPrice, tfPhoneNumber;
    JComboBox<String> cbCity, cbPropertyType;
    JButton btnBack, btnApplyChanges;
    JLayeredPane layeredPane;
    ImageIcon backIcon, appIcon;

    // JLabel positions and dimensions
    int lx = 50;
    int lxData = 225;
    int spaceBetweenRows = 40;
    int y1 = 60;
    int y2 = y1 + spaceBetweenRows;
    int y3 = y2 + spaceBetweenRows;
    int y4 = y3 + spaceBetweenRows;
    int y5 = y4 + spaceBetweenRows;
    int y6 = y5 + spaceBetweenRows;
    int y7 = y6 + spaceBetweenRows;
    int y8 = y7 + spaceBetweenRows + 15;
    int y9 = y8 + spaceBetweenRows;
    int y10 = y9 + spaceBetweenRows;
    int y11 = y10 + spaceBetweenRows;
    final int ELEMENTS_WIDTH = 170;
    final int ELEMENTS_HEIGHT = 20;

    //JButton positions and dimensions
    int bx1 = 150;
    int by = y11 + spaceBetweenRows + 20;
    //150
    final int BUTTONS_WIDTH = 190;
    final int BUTTONS_HEIGHT = 50;

        public AddListing() {

        backIcon = new ImageIcon("BackIcon.png");
        appIcon = new ImageIcon("RustyRentsIcon.png");

        // Labels
        lblListingTitle = new JLabel("Име на обявата:");
        lblListingTitle.setBounds(lx, y1, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblCityName = new JLabel("Град:");
        lblCityName.setBounds(lx,y2, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblCityQuarter = new JLabel("Квартал на града:");
        lblCityQuarter.setBounds(lx,y3, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblStreetName = new JLabel("Име на улица:");
        lblStreetName.setBounds(lx,y4, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblStreetNumber = new JLabel("Номер на улица:");
        lblStreetNumber.setBounds(lx,y5, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblFloor = new JLabel("Етаж:");
        lblFloor.setBounds(lx,y6, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblDoorNumber = new JLabel("Номер на врата:");
        lblDoorNumber.setBounds(lx,y7, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblPropertyType = new JLabel("Вид на имота:");
        lblPropertyType.setBounds(lx,y8, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblPropertyArea = new JLabel("Квадратура (кв. м.):");
        lblPropertyArea.setBounds(lx,y9, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblPrice = new JLabel("Цена (лв.): ");
        lblPrice.setBounds(lx,y10, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblPhoneNumber = new JLabel("Телефон за връзка: ");
        lblPhoneNumber.setBounds(lx,y11, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        lblEditMessage = new JLabel("Въведете данните за Вашата нова обява:");
        lblEditMessage.setBounds(100,20,350,15);
        lblEditMessage.setForeground(Color.magenta);

        // Text fields
        tfListingTitle = new JTextField();
        tfListingTitle.setBounds(lxData,y1, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        cbCity = new JComboBox<String>();
        cbCity.setBounds(lxData,y2, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);
        cbCity.addItem("");
        ResultSet rsCities = Database.getCities();
        try {
            while (rsCities.next()) {
                cbCity.addItem(rsCities.getString(1));
            }
        } catch(Exception e) {System.out.println(e);}

        tfCityQuarter = new JTextField();
        tfCityQuarter.setBounds(lxData,y3, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfStreetName = new JTextField();
        tfStreetName.setBounds(lxData,y4, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfStreetNumber = new JTextField();
        tfStreetNumber.setBounds(lxData,y5, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfFloor = new JTextField();
        tfFloor.setBounds(lxData,y6, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfDoorNumber = new JTextField();
        tfDoorNumber.setBounds(lxData,y7, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        cbPropertyType = new JComboBox<String>();
        cbPropertyType.setBounds(lxData,y8, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);
        // TODO (optional) : add the items using an array
        cbPropertyType.addItem("");
        cbPropertyType.addItem("Apartment");
        cbPropertyType.addItem("Studio");
        cbPropertyType.addItem("House");
        cbPropertyType.addItem("Villa");
        cbPropertyType.addItem("Office");
        cbPropertyType.addItem("Store");

        tfPropertyArea = new JTextField();
        tfPropertyArea.setBounds(lxData,y9, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfPrice = new JTextField();
        tfPrice.setBounds(lxData,y10, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        tfPhoneNumber = new JTextField(Database.getCurrentUserPhoneNumber());
        tfPhoneNumber.setBounds(lxData,y11, ELEMENTS_WIDTH, ELEMENTS_HEIGHT);

        btnBack = new JButton(backIcon);
        btnBack.setBounds(5, 5, 50,50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);

        btnApplyChanges = new JButton("Добави");
        btnApplyChanges.setBounds(bx1,by, BUTTONS_WIDTH, BUTTONS_HEIGHT);
        btnApplyChanges.setBackground(new Color(125,0,139));
        btnApplyChanges.setForeground(Color.WHITE);
        btnApplyChanges.setFocusable(false);
        btnApplyChanges.addActionListener(this);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,650);
        layeredPane.setVisible(true);
        layeredPane.add(lblListingTitle, Integer.valueOf(0));
        layeredPane.add(lblCityName, Integer.valueOf(1));
        layeredPane.add(lblCityQuarter, Integer.valueOf(2));
        layeredPane.add(lblStreetName, Integer.valueOf(3));
        layeredPane.add(lblStreetNumber, Integer.valueOf(4));
        layeredPane.add(lblFloor, Integer.valueOf(5));
        layeredPane.add(lblDoorNumber, Integer.valueOf(6));
        layeredPane.add(lblPropertyType, Integer.valueOf(7));
        layeredPane.add(lblPropertyArea, Integer.valueOf(8));
        layeredPane.add(lblPrice, Integer.valueOf(9));
        layeredPane.add(tfListingTitle, Integer.valueOf(10));
        layeredPane.add(cbCity, Integer.valueOf(11));
        layeredPane.add(tfCityQuarter, Integer.valueOf(12));
        layeredPane.add(tfStreetName, Integer.valueOf(13));
        layeredPane.add(tfStreetNumber, Integer.valueOf(14));
        layeredPane.add(tfFloor, Integer.valueOf(15));
        layeredPane.add(tfDoorNumber, Integer.valueOf(16));
        layeredPane.add(cbPropertyType, Integer.valueOf(17));
        layeredPane.add(tfPropertyArea, Integer.valueOf(18));
        layeredPane.add(tfPrice, Integer.valueOf(19));
        layeredPane.add(lblPhoneNumber, Integer.valueOf(20));
        layeredPane.add(tfPhoneNumber, Integer.valueOf(21));
        layeredPane.add(btnBack, Integer.valueOf(22));
        layeredPane.add(btnApplyChanges, Integer.valueOf(23));
        layeredPane.add(lblEditMessage, Integer.valueOf(24));

        this.setTitle("Добавяне на обява");
        this.setSize(475,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnBack) {
            this.dispose();
            new MyListings();
        }

        if (e.getSource()== btnApplyChanges) {

            String title = tfListingTitle.getText();
            String city = cbCity.getSelectedItem().toString();
            String quarter = tfCityQuarter.getText();
            String streetName = tfStreetName.getText();
            String streetNumber = tfStreetNumber.getText();
            String floorNumber = tfFloor.getText();
            String doorNumber = tfDoorNumber.getText();
            String type = cbPropertyType.getSelectedItem().toString();
            String area = tfPropertyArea.getText();
            String price = tfPrice.getText();
            String phone = tfPhoneNumber.getText();

            if (title.isBlank()
                || city.isBlank()
                || quarter.isBlank()
                || streetName.isBlank()
                || streetNumber.isBlank()
                || type.isBlank()
                || area.isBlank()
                || price.isBlank()
                || phone.isBlank()) {
                System.out.println("Empty fields detected");
            }
            else {
                Database.addNewListing(title, city, quarter, streetName, streetNumber,
                        floorNumber, doorNumber, type, area, price, phone);
                this.dispose();
                new MyListings();
            }
        }
    }
}
