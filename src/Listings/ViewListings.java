package Listings;

import MainMenu.MainMenu;
import Database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Component;

public class ViewListings extends JFrame implements ActionListener {


    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JLayeredPane layeredPane;
    JTable table;
    Object[] columns, row;
    DefaultTableModel model;
    JScrollPane pane;
    JButton backButton;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblNewLabel_4;

    public ViewListings() {
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



        JLabel lblNewLabel = new JLabel("Град");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(54, 24, 57, 45);
        getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(44, 79, 78, 19);
        getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(150, 79, 107, 19);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Квартал");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(157, 29, 115, 35);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Вид");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_2.setBounds(309, 29, 78, 35);
        getContentPane().add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(285, 79, 91, 19);
        getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(403, 79, 78, 19);
        getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("m^2");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(413, 37, 68, 19);
        getContentPane().add(lblNewLabel_3);

        JButton btnNewButton = new JButton("Търси");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(616, 72, 107, 25);
        btnNewButton.setBackground(new Color(139,0,139));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO Filter listings
            }
        });
        getContentPane().add(btnNewButton);


        backButton = new JButton(backIcon);
        backButton.setBounds(5,5,50,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        getContentPane().add(backButton);

        JButton btnNewButton_1 = new JButton("Преглед на имот");
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        btnNewButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton_1.setBounds(527, 395, 196, 51);
        btnNewButton_1.setBackground(new Color(139,0,139));
        btnNewButton_1.setForeground(Color.WHITE);
        getContentPane().add(btnNewButton_1);

        textField_4 = new JTextField();
        textField_4.setBounds(502, 79, 91, 19);
        getContentPane().add(textField_4);
        textField_4.setColumns(10);

        lblNewLabel_4 = new JLabel("Max. цена");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setBounds(502, 37, 91, 22);
        getContentPane().add(lblNewLabel_4);
        getContentPane().setLayout(null);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== backButton) {
            this.dispose();
            new MainMenu();
        }
    }
}
