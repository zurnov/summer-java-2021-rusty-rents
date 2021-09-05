package Listings;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.sql.ResultSet;

public class ListingDetails extends JFrame implements ActionListener {

    // Variables
    JLabel name,city,neighborhood,streetName,numberOfStreet,floor,appNumber,type,m2,price,phoneNumber,listingReq;
    JLabel nameData,cityData,neighborhoodData, addressData,numberOfStreetData,floorData, doorNumberData,typeData,m2Data,priceData,phoneNumberData;
    JButton backButton, apiButton;
    JLayeredPane layeredPane;
    ImageIcon backIcon, appIcon;
    String temp = "PLACEHOLDER";

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
    int bx1 = 175;
    int by = y11 + spaceBetweenRows + 20;
    int bwidth = 150;
    int bheight = 50;

    // constructor
    public ListingDetails(ResultSet rs) {

        backIcon = new ImageIcon("BackIcon.png");
        appIcon = new ImageIcon("RustyRentsIcon.png");

        name = new JLabel("Име на обявата: ");
        name.setBounds(lx, y1, lwidth, lheight);

        city = new JLabel("Град: ");
        city.setBounds(lx,y2, lwidth, lheight);

        neighborhood = new JLabel("Квартал: ");
        neighborhood.setBounds(lx,y3, lwidth, lheight);

        streetName = new JLabel("Име на улица: ");
        streetName.setBounds(lx,y4, lwidth, lheight);

        //numberOfStreet = new JLabel("Номер на улица: ");
        //numberOfStreet.setBounds(lx,y5, lwidth, lheight);

        floor = new JLabel("Етаж: ");
        floor.setBounds(lx,y6, lwidth, lheight);

        appNumber = new JLabel("Номер на врата:");
        appNumber.setBounds(lx,y7, lwidth, lheight + 15);

        type = new JLabel("Вид на имота: ");
        type.setBounds(lx,y8, lwidth, lheight);

        m2 = new JLabel("Квадратура (кв. м.): ");
        m2.setBounds(lx,y9, lwidth, lheight);

        price = new JLabel("Цена (лв.): ");
        price.setBounds(lx,y10, lwidth, lheight);

        phoneNumber = new JLabel("Телефон за връзка: ");
        phoneNumber.setBounds(lx,y11, lwidth, lheight);

        listingReq = new JLabel("Подробности за обява:");
        listingReq.setBounds(120,20,300,15);
        listingReq.setForeground(Color.magenta);

        try {
            if (rs.next()) {
                nameData = new JLabel(rs.getString(1));
                nameData.setBounds(lxData, y1, lwidth, lheight);

                cityData = new JLabel(rs.getString(2));
                cityData.setBounds(lxData, y2, lwidth, lheight);

                neighborhoodData = new JLabel(rs.getString(3));
                neighborhoodData.setBounds(lxData, y3, lwidth, lheight);

                addressData = new JLabel(rs.getString(4));
                addressData.setBounds(lxData, y4, lwidth, lheight);

                //numberOfStreetData = new JLabel(rs.getString(5));
                //numberOfStreetData.setBounds(lxData, y5, lwidth, lheight);

                floorData = new JLabel(rs.getString(5));
                floorData.setBounds(lxData, y6, lwidth, lheight);

                doorNumberData = new JLabel(rs.getString(6));
                doorNumberData.setBounds(lxData, y7, lwidth, lheight);

                typeData = new JLabel(rs.getString(7));
                typeData.setBounds(lxData, y8, lwidth, lheight);

                m2Data = new JLabel(rs.getString(8));
                m2Data.setBounds(lxData, y9, lwidth, lheight);

                priceData = new JLabel(rs.getString(9));
                priceData.setBounds(lxData, y10, lwidth, lheight);

                phoneNumberData = new JLabel(rs.getString(10));
                phoneNumberData.setBounds(lxData, y11, lwidth, lheight);
            }
            else {
                System.out.println("ResultSet for ListingDetails is null.");
            }
        }
        catch (Exception e) {System.out.println(e);}


        backButton = new JButton(backIcon);
        backButton.setBounds(5, 5, 50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);

        apiButton = new JButton("Виж на картата");
        apiButton.setBounds(bx1,by,bwidth,bheight);
        apiButton.setBackground(new Color(139,0,139));
        apiButton.setForeground(Color.WHITE);
        apiButton.setFocusable(false);
        apiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (rs.getString(11).isEmpty()) {
                        System.out.println("No map url for given listing");
                    }
                    else {
                        Desktop desktop = java.awt.Desktop.getDesktop();
                        URI oURL = new URI(rs.getString(11));
                        desktop.browse(oURL);
                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,650);
        layeredPane.setVisible(true);
        layeredPane.add(name, Integer.valueOf(0));
        layeredPane.add(city, Integer.valueOf(1));
        layeredPane.add(neighborhood, Integer.valueOf(2));
        layeredPane.add(streetName, Integer.valueOf(3));
        //layeredPane.add(numberOfStreet, Integer.valueOf(4));
        layeredPane.add(floor, Integer.valueOf(5));
        layeredPane.add(appNumber, Integer.valueOf(6));
        layeredPane.add(type, Integer.valueOf(7));
        layeredPane.add(m2, Integer.valueOf(8));
        layeredPane.add(price, Integer.valueOf(9));
        layeredPane.add(nameData, Integer.valueOf(10));
        layeredPane.add(cityData, Integer.valueOf(11));
        layeredPane.add(neighborhoodData, Integer.valueOf(12));
        layeredPane.add(addressData, Integer.valueOf(13));
        //layeredPane.add(numberOfStreetData, Integer.valueOf(14));
        layeredPane.add(floorData, Integer.valueOf(15));
        layeredPane.add(doorNumberData, Integer.valueOf(16));
        layeredPane.add(typeData, Integer.valueOf(17));
        layeredPane.add(m2Data, Integer.valueOf(18));
        layeredPane.add(priceData, Integer.valueOf(19));
        layeredPane.add(phoneNumber, Integer.valueOf(20));
        layeredPane.add(phoneNumberData, Integer.valueOf(21));
        layeredPane.add(backButton, Integer.valueOf(22));
        layeredPane.add(apiButton, Integer.valueOf(23));
        layeredPane.add(listingReq, Integer.valueOf(24));

        this.setTitle("Подробности за обява");
        this.setSize(500,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton) {
            this.dispose();
            // not needed; ViewListings will stay open
            //new ViewListings();
        }

        if (e.getSource()==apiButton) {
            //API Jframe
        }
    }
}
