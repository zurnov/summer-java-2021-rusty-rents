package Listings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

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
	
    public ViewListings() {
        ImageIcon appIcon = new ImageIcon("RustyRentsIcon.png");

        
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
       
        
        table = new JTable();
        table.setModel(model);
        table.setBackground(Color.white);
        table.setForeground(Color.black);
        table.setSelectionBackground(Color.red);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        
        
        pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.WHITE);
        pane.setBounds(10,10,10,10);
        
        
        columns = new Object[] {"Име на обява", "Град", "Вид имот", "Цена"};

        
        row = new Object[4];
        
        
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,1000,700);


        this.setTitle("Преглед на обяви˜");
        this.setIconImage(appIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000,700);
        this.setVisible(true);
        this.getContentPane().add(pane);
        this.setLocationRelativeTo(null);
       
        // TODO this.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
