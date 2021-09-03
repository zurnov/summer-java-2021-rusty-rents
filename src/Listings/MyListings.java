package Listings;

import MainMenu.*;
import Database.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
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
    JButton backButton, btnViewProperty;

    // Declare top row text fields
    private JTextField tfCityFilter;
    private JTextField tfQuarterFilter;
    private JTextField tfPropertyTypeFilter;
    private JTextField tfMinAreaFilter;
    private JTextField tfMaxPriceFilter;

    // Declare top row labels
    private JLabel lblCityFilter;
    private JLabel lblQuarterFilter;
    private JLabel lblPropertyTypeFilter;
    private JLabel lblMinAreaFilter;
    private JLabel lblMaxPriceFilter;

    private final int LABELS_FONT_SIZE = 15;
    private final int LABELS_POSITION_Y = 40;
    private final int LABELS_WIDTH = 100;
    private final int LABELS_HEIGHT = 50;

    public MyListings() {
        setAutoRequestFocus(false);
        ImageIcon backIcon = new ImageIcon("BackIcon.png");
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");

        //TODO replace column objects with DB values
        columns = new Object[] {"Име на обява", "Град", "Вид имот", "Цена"};


        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        //TODO Connect DB with table
        table = new JTable();
        table.setModel(model);
        table.setBackground(Color.MAGENTA);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.red);
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

        // City label
        lblCityFilter = new JLabel("Град");
        lblCityFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblCityFilter.setForeground(Color.BLACK);
        lblCityFilter.setBounds(54, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblCityFilter);

        // City text field
        tfCityFilter = new JTextField();
        tfCityFilter.setBounds(44, 79, 78, 19);
        getContentPane().add(tfCityFilter);
        tfCityFilter.setColumns(10);

        // City quarter label
        lblQuarterFilter = new JLabel("Квартал");
        lblQuarterFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblQuarterFilter.setForeground(Color.BLACK);
        lblQuarterFilter.setBounds(157, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblQuarterFilter);

        // City quarter text field
        tfQuarterFilter = new JTextField();
        tfQuarterFilter.setBounds(150, 79, 107, 19);
        getContentPane().add(tfQuarterFilter);
        tfQuarterFilter.setColumns(10);

        // Property type label
        lblPropertyTypeFilter = new JLabel("Вид имот");
        lblPropertyTypeFilter.setForeground(Color.BLACK);
        lblPropertyTypeFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblPropertyTypeFilter.setBounds(290, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblPropertyTypeFilter);

        // Property type text field
        tfPropertyTypeFilter = new JTextField();
        tfPropertyTypeFilter.setBounds(285, 79, 91, 19);
        getContentPane().add(tfPropertyTypeFilter);
        tfPropertyTypeFilter.setColumns(10);

        // Minimum area label
        lblMinAreaFilter = new JLabel("Min. m^2");
        lblMinAreaFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblMinAreaFilter.setForeground(Color.BLACK);
        lblMinAreaFilter.setBounds(410, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblMinAreaFilter);

        // Minimum area text field
        tfMinAreaFilter = new JTextField();
        tfMinAreaFilter.setBounds(403, 79, 78, 19);
        getContentPane().add(tfMinAreaFilter);
        tfMinAreaFilter.setColumns(10);

        // Max price label
        lblMaxPriceFilter = new JLabel("Max. цена");
        lblMaxPriceFilter.setFont(new Font("Tahoma", Font.PLAIN, LABELS_FONT_SIZE));
        lblMaxPriceFilter.setForeground(Color.BLACK);
        lblMaxPriceFilter.setBounds(510, LABELS_POSITION_Y, LABELS_WIDTH, LABELS_HEIGHT);
        getContentPane().add(lblMaxPriceFilter);
        getContentPane().setLayout(null);

        // Max price text field
        tfMaxPriceFilter = new JTextField();
        tfMaxPriceFilter.setBounds(502, 79, 91, 19);
        getContentPane().add(tfMaxPriceFilter);
        tfMaxPriceFilter.setColumns(10);

        //
        // Add properties from database
        //

        ResultSet rs = Database.getProperties();
        try {
            while (rs.next()) {
                row[0] = rs.getString(1);
                System.out.println(row[0]);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getInt(4);

                model.addRow(row);
            }
        } catch (Exception e) {System.out.println();}

        // Search button
        JButton btnFilterResults = new JButton("Търси");
        btnFilterResults.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnFilterResults.setBounds(616, 72, 107, 25);
        btnFilterResults.setBackground(new Color(139,0,139));
        btnFilterResults.setForeground(Color.WHITE);
        btnFilterResults.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Filter listings
            }
        });

        getContentPane().add(btnFilterResults);

        // Back button
        backButton = new JButton(backIcon);
        backButton.setBounds(5,5,50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        getContentPane().add(backButton);

        // View property button
        btnViewProperty = new JButton("Преглед на имот");
        btnViewProperty.setHorizontalTextPosition(SwingConstants.CENTER);
        btnViewProperty.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnViewProperty.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnViewProperty.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewProperty.setBounds(527, 395, 196, 51);
        btnViewProperty.setBackground(new Color(139,0,139));
        btnViewProperty.setForeground(Color.WHITE);
        getContentPane().add(btnViewProperty);

        this.setTitle("Преглед на обяви˜");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(248,240,255));
        this.getContentPane().setForeground(Color.WHITE);
        this.setResizable(false);
        this.setBounds(100,100,757,500);
        this.setVisible(true);
        this.getContentPane().add(pane);
        this.setLocationRelativeTo(null);

        // TODO this.add(layeredPane);
    }

    private void addRow() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== backButton) {
            this.dispose();
            new MainMenu();
        }

        else if (e.getSource()== btnViewProperty) {

        }
    }
}
