package Listings;

import MainMenu.*;
import Database.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

public class MyListings extends JFrame implements ActionListener {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLayeredPane layeredPane;
    JTable table;
    Object[] columns, row;
    DefaultTableModel model;
    JScrollPane pane;
    JButton btnBack, btnViewProperty, btnEditProperty, btnAddProperty;


    // labels
    private JLabel lblListingNameFilter;
    private JLabel lblQuarterFilter;
    private JLabel lblCityNameFilter;
    private JLabel lblPropertyTypeFilter;
    private JLabel lblMaxPriceFilter;

    // combo boxes
    private JComboBox<String> cbCityNameFilter;
    private JComboBox<String> cbPropertyTypeFilter;

    private JTextField tfMaxPriceFilter;

    private final int LABELS_FONT_SIZE = 15;
    private final int LABELS_POSITION_Y = 40;
    private final int LABELS_WIDTH = 100;
    private final int LABELS_HEIGHT = 50;

    public MyListings() {
        setAutoRequestFocus(false);
        ImageIcon backIcon = new ImageIcon("BackIcon.png");
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");

        columns = new Object[] {"Име на обява", "Град", "Вид имот", "Цена"};

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table = new JTable();
        table.setModel(model);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(new Color(139, 0, 139));
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        pane = new JScrollPane(table);
        pane.setBounds(18, 114, 705, 262);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);

        row = new Object[4];

        //
        // Top row of window
        //

        // Listing name label
        lblListingNameFilter = new JLabel("Филтриране на резултатите:");
        lblListingNameFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblListingNameFilter.setForeground(Color.BLACK);
        lblListingNameFilter.setBounds(40, 60, 250, LABELS_HEIGHT);
        getContentPane().add(lblListingNameFilter);

        // City name filter label
        lblCityNameFilter = new JLabel("Град");
        lblCityNameFilter.setForeground(Color.BLACK);
        lblCityNameFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblCityNameFilter.setBounds(260, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblCityNameFilter);

        // City name filter combo box
        cbCityNameFilter = new JComboBox<String>();
        cbCityNameFilter.setBounds(255, 79, 130, 19);
        getContentPane().add(cbCityNameFilter);
        cbCityNameFilter.addItem("");
        ResultSet rsNameFilter = Database.getCities();
        try {
            while (rsNameFilter.next()) {
                cbCityNameFilter.addItem(rsNameFilter.getString(1));
            }
        } catch(Exception e) {System.out.println(e);}

        // Property type filter label
        lblPropertyTypeFilter = new JLabel("Вид имот");
        lblPropertyTypeFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblPropertyTypeFilter.setForeground(Color.BLACK);
        lblPropertyTypeFilter.setBounds(410, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblPropertyTypeFilter);

        // Property type filter combo box
        cbPropertyTypeFilter = new JComboBox<String>();
        cbPropertyTypeFilter.setBounds(403, 79, 115, 19);
        getContentPane().add(cbPropertyTypeFilter);

        // TODO (optional) : add the items using an array
        cbPropertyTypeFilter.addItem("");
        cbPropertyTypeFilter.addItem("Apartment");
        cbPropertyTypeFilter.addItem("Studio");
        cbPropertyTypeFilter.addItem("House");
        cbPropertyTypeFilter.addItem("Villa");
        cbPropertyTypeFilter.addItem("Office");
        cbPropertyTypeFilter.addItem("Store");

        // Max price filter label
        lblMaxPriceFilter = new JLabel("Max. цена");
        lblMaxPriceFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblMaxPriceFilter.setForeground(Color.BLACK);
        lblMaxPriceFilter.setBounds(530, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblMaxPriceFilter);
        getContentPane().setLayout(null);

        // Max price filter text field
        tfMaxPriceFilter = new JTextField();
        tfMaxPriceFilter.setBounds(530, 79, 70, 19);
        getContentPane().add(tfMaxPriceFilter);
        tfMaxPriceFilter.setColumns(10);

        //
        // Add properties from database
        //

        // TODO write getPropertiesForUser()
        ResultSet rs = Database.getCurrentUserProperties();
        try {
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);

                model.addRow(row);
            }
        } catch (Exception e) {System.out.println(e);}

        // Search button
        JButton btnFilterResults = new JButton("Търси");
        btnFilterResults.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnFilterResults.setBounds(616, 72, 107, 25);
        btnFilterResults.setBackground(new Color(139,0,139));
        btnFilterResults.setForeground(Color.WHITE);
        btnFilterResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0);

                String cityFilter = cbCityNameFilter.getSelectedItem().toString();
                String typeFilter = cbPropertyTypeFilter.getSelectedItem().toString();
                String priceFilter = tfMaxPriceFilter.getText();

                ResultSet rs = Database.getFilteredProperties(cityFilter, typeFilter, priceFilter, false);

                try {
                    while (rs.next()) {
                        row[0] = rs.getString(1);
                        row[1] = rs.getString(2);
                        row[2] = rs.getString(3);
                        row[3] = rs.getInt(4);

                        model.addRow(row);
                    }
                } catch (Exception exc) {System.out.println(exc);}

            }
        });

        getContentPane().add(btnFilterResults);

        // Back button
        btnBack = new JButton(backIcon);
        btnBack.setBounds(5,5,50,50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);
        btnBack.setOpaque(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setBorderPainted(false);
        getContentPane().add(btnBack);

        // Add listing button
        btnAddProperty = new JButton("Добавяне");
        btnAddProperty.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAddProperty.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddProperty.setBounds(113, 395, 196, 51);
        btnAddProperty.setBackground(new Color(139,0,139));
        btnAddProperty.setForeground(Color.WHITE);
        getContentPane().add(btnAddProperty);
        btnAddProperty.addActionListener(this);

        // Edit listing button
        btnEditProperty = new JButton("Редактиране");
        btnEditProperty.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEditProperty.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnEditProperty.setBounds(320, 395, 196, 51);
        btnEditProperty.setBackground(new Color(139,0,139));
        btnEditProperty.setForeground(Color.WHITE);
        getContentPane().add(btnEditProperty);
        btnEditProperty.addActionListener(this);

        // View listing button
        btnViewProperty = new JButton("Преглед на имот");
        btnViewProperty.setHorizontalTextPosition(SwingConstants.CENTER);
        btnViewProperty.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewProperty.setBounds(527, 395, 196, 51);
        btnViewProperty.setBackground(new Color(139,0,139));
        btnViewProperty.setForeground(Color.WHITE);
        getContentPane().add(btnViewProperty);
        btnViewProperty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    System.out.println("No row selected.");
                    return;
                }
                String selectedRowTitle = model.getValueAt(selectedRow, 0).toString();
                System.out.println(selectedRowTitle);

                new ListingDetails(Database.getPropertyDetails(selectedRowTitle));
            }
        });

        this.setTitle("Преглед на обяви˜");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,240,255));
        this.getContentPane().setForeground(Color.WHITE);
        this.setResizable(false);
        this.setBounds(100,100,757,500);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().add(pane);

        // TODO this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btnBack) {
            this.dispose();
            new MainMenu();
        }

        if (e.getSource()== btnViewProperty) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                System.out.println("No row selected.");
                return;
            }
            String selectedRowTitle = model.getValueAt(selectedRow, 0).toString();
            System.out.println(selectedRowTitle);

            new ListingDetails(Database.getPropertyDetails(selectedRowTitle));
        }

        if (e.getSource() == btnEditProperty) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                System.out.println("No row selected.");
                return;
            }
            String selectedRowTitle = model.getValueAt(selectedRow, 0).toString();
            System.out.println(selectedRowTitle);

            new EditListingDetails(Database.getPropertyDetails(selectedRowTitle));
        }

        if (e.getSource() == btnAddProperty) {
            this.dispose();
            new AddListing();
        }
    }
}
