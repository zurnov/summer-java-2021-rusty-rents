package Listings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListingDetails extends JFrame implements ActionListener {

    // Variables

    public ListingDetails() {

        this.setTitle("Детайли на обява");
        this.setSize(500,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
