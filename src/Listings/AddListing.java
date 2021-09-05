package Listings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListing extends JFrame implements ActionListener {

    // Variables
    JLabel name,city,neighborhood,streetName,numberOfStreet,floor,appNumber,type,m2,price,phoneNumber,listingReq;
    JTextField nameData,cityData,neighborhoodData,streetNameData,numberOfStreetData,floorData,appNumberData,typeData,m2Data,priceData,phoneNumberData;
    JButton backButton, AddButton;
    JLayeredPane layeredPane;
    ImageIcon backIcon, appIcon;
    String temp;

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
    int lwidth = 170;
    int lheight = 15;

    //JButton positions and dimensions
    int bx1 = 150;
    int by = y11 + spaceBetweenRows + 20;
    //150
    int bwidth = 190;
    int bheight = 50;

    public AddListing() {

        backIcon = new ImageIcon("BackIcon.png");
        appIcon = new ImageIcon("RustyRentsIcon.png");

        name = new JLabel("Име на обявата: ");
        name.setBounds(lx, y1, lwidth, lheight);

        city = new JLabel("Град: ");
        city.setBounds(lx,y2, lwidth, lheight);

        neighborhood = new JLabel("Квартал на града: ");
        neighborhood.setBounds(lx,y3, lwidth, lheight);

        streetName = new JLabel("Име на улица: ");
        streetName.setBounds(lx,y4, lwidth, lheight);

        numberOfStreet = new JLabel("Номер на улица: ");
        numberOfStreet.setBounds(lx,y5, lwidth, lheight);

        floor = new JLabel("Етаж (по избор): ");
        floor.setBounds(lx,y6, lwidth, lheight);

        appNumber = new JLabel("<html>Номер на стая/апартамент: <br/>(по избор)</html>");
        appNumber.setBounds(lx,y7, lwidth, lheight + 15);

        type = new JLabel("Вид на имота: ");
        type.setBounds(lx,y8, lwidth, lheight);

        m2 = new JLabel("Квадратура: ");
        m2.setBounds(lx,y9, lwidth, lheight);

        price = new JLabel("Цена (в лв.): ");
        price.setBounds(lx,y10, lwidth, lheight);

        phoneNumber = new JLabel("Телефон за връзка: ");
        phoneNumber.setBounds(lx,y11, lwidth, lheight);

        listingReq = new JLabel("Моля, въведете данните за вашата обява: ");
        listingReq.setBounds(120,20,300,15);
        listingReq.setForeground(Color.magenta);

        nameData = new JTextField(temp);
        nameData.setBounds(lxData,y1, lwidth, lheight);

        cityData = new JTextField(temp);
        cityData.setBounds(lxData,y2, lwidth, lheight);

        neighborhoodData = new JTextField(temp);
        neighborhoodData.setBounds(lxData,y3, lwidth, lheight);

        streetNameData = new JTextField(temp);
        streetNameData.setBounds(lxData,y4, lwidth, lheight);

        numberOfStreetData = new JTextField(temp);
        numberOfStreetData.setBounds(lxData,y5, lwidth, lheight);

        floorData = new JTextField(temp);
        floorData.setBounds(lxData,y6, lwidth, lheight);

        appNumberData = new JTextField(temp);
        appNumberData.setBounds(lxData,y7, lwidth, lheight);

        typeData = new JTextField(temp);
        typeData.setBounds(lxData,y8, lwidth, lheight);

        m2Data = new JTextField(temp);
        m2Data.setBounds(lxData,y9, lwidth, lheight);

        priceData = new JTextField(temp);
        priceData.setBounds(lxData,y10, lwidth, lheight);

        phoneNumberData = new JTextField(temp);
        phoneNumberData.setBounds(lxData,y11, lwidth, lheight);


        backButton = new JButton(backIcon);
        backButton.setBounds(5, 5, 50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        AddButton = new JButton("Публикувай обявата");
        AddButton.setBounds(bx1,by,bwidth,bheight);
        AddButton.setBackground(new Color(139,0,139));
        AddButton.setForeground(Color.WHITE);
        AddButton.setFocusable(false);
        AddButton.addActionListener(this);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,650);
        layeredPane.setVisible(true);
        layeredPane.add(name, Integer.valueOf(0));
        layeredPane.add(city, Integer.valueOf(1));
        layeredPane.add(neighborhood, Integer.valueOf(2));
        layeredPane.add(streetName, Integer.valueOf(3));
        layeredPane.add(numberOfStreet, Integer.valueOf(4));
        layeredPane.add(floor, Integer.valueOf(5));
        layeredPane.add(appNumber, Integer.valueOf(6));
        layeredPane.add(type, Integer.valueOf(7));
        layeredPane.add(m2, Integer.valueOf(8));
        layeredPane.add(price, Integer.valueOf(9));
        layeredPane.add(nameData, Integer.valueOf(10));
        layeredPane.add(cityData, Integer.valueOf(11));
        layeredPane.add(neighborhoodData, Integer.valueOf(12));
        layeredPane.add(streetNameData, Integer.valueOf(13));
        layeredPane.add(numberOfStreetData, Integer.valueOf(14));
        layeredPane.add(floorData, Integer.valueOf(15));
        layeredPane.add(appNumberData, Integer.valueOf(16));
        layeredPane.add(typeData, Integer.valueOf(17));
        layeredPane.add(m2Data, Integer.valueOf(18));
        layeredPane.add(priceData, Integer.valueOf(19));
        layeredPane.add(phoneNumber, Integer.valueOf(20));
        layeredPane.add(phoneNumberData, Integer.valueOf(21));
        layeredPane.add(backButton, Integer.valueOf(22));
        layeredPane.add(AddButton, Integer.valueOf(23));
        layeredPane.add(listingReq, Integer.valueOf(24));

        this.setTitle("Публикуване на обява");
        this.setSize(500,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton) {
            this.dispose();
        }

        if (e.getSource()== AddButton) {
            //API Jframe
        }
    }
}
