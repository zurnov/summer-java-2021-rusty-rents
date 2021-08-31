package AppartmentActions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import MainMenu.MainMenu;
import Register.*;

public class BuyAppartment extends JFrame implements ActionListener{

    JButton backButton, rentDetails, rentBuy;
    JComboBox neighborhood,city,rent;
    JLayeredPane layeredPane;
    String[] cityArray,neighborhoodArray,rentArray;

    public BuyAppartment() {
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
        String[] cityArray = {" ", "Варна", "София", "Пловдив", "Хасково"};

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
                            String[] neighborhoodArray = {"Младост", "Аспарухово", "Тракия"};
                            neighborhood = new JComboBox(neighborhoodArray);
                            neighborhood.setBounds(5, 130, 100, 50);
                            layeredPane.add(neighborhood, Integer.valueOf(3));
                            neighborhood.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    if (e.getStateChange() == ItemEvent.SELECTED) {
                                        Object source = e.getSource();
                                        if (source instanceof JComboBox) {
                                            Object selectedItem = neighborhood.getSelectedItem();
                                            if ("Младост".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №1", "Апартамент №2", "Апартамент №3"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Аспарухово".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №4", "Апартамент №5", "Апартамент №6"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Тракия".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №7", "Апартамент №8", "Апартамент №9"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Филиповци".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №10", "Апартамент №11", "Апартамент №12"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Люлин".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №13", "Апартамент №14", "Апартамент №15"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Лаута".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №16", "Апартамент №17", "Апартамент №18"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Каменица".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №19", "Апартамент №20", "Апартамент №21"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Изгрев".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №22", "Апартамент №23", "Апартамент №24"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Орфей".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №25", "Апартамент №26", "Апартамент №27"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Куба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №28", "Апартамент №29", "Апартамент №30"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Дружба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №31", "Апартамент №32", "Апартамент №33"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("".equals(selectedItem)) {
                                                rent.setVisible(false);
                                            }
                                        }
                                    }
                                }
                            });
                        }

                        else if ("София".equals(selectedItem)) {
                            String[] neighborhoodArray = {"Младост", "Филиповци", "Люлин"};
                            neighborhood = new JComboBox(neighborhoodArray);
                            neighborhood.setBounds(5, 130, 100, 50);
                            layeredPane.add(neighborhood, Integer.valueOf(3));
                            neighborhood.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    if (e.getStateChange() == ItemEvent.SELECTED) {
                                        Object source = e.getSource();
                                        if (source instanceof JComboBox) {
                                            Object selectedItem = neighborhood.getSelectedItem();
                                            if ("Младост".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №1", "Апартамент №2", "Апартамент №3"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Аспарухово".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №4", "Апартамент №5", "Апартамент №6"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Тракия".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №7", "Апартамент №8", "Апартамент №9"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Филиповци".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №10", "Апартамент №11", "Апартамент №12"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Люлин".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №13", "Апартамент №14", "Апартамент №15"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Лаута".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №16", "Апартамент №17", "Апартамент №18"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Каменица".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №19", "Апартамент №20", "Апартамент №21"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Изгрев".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №22", "Апартамент №23", "Апартамент №24"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Орфей".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №25", "Апартамент №26", "Апартамент №27"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Куба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №28", "Апартамент №29", "Апартамент №30"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Дружба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №31", "Апартамент №32", "Апартамент №33"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("".equals(selectedItem)) {
                                                rent.setVisible(false);
                                            }
                                        }
                                    }
                                }
                            });
                        }

                        else if ("Пловдив".equals(selectedItem)) {
                            String[] neighborhoodArray = {"Лаута", "Каменица", "Изгрев"};
                            neighborhood = new JComboBox(neighborhoodArray);
                            neighborhood.setBounds(5, 130, 100, 50);
                            layeredPane.add(neighborhood, Integer.valueOf(3));
                            neighborhood.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    if (e.getStateChange() == ItemEvent.SELECTED) {
                                        Object source = e.getSource();
                                        if (source instanceof JComboBox) {
                                            Object selectedItem = neighborhood.getSelectedItem();
                                            if ("Младост".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №1", "Апартамент №2", "Апартамент №3"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Аспарухово".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №4", "Апартамент №5", "Апартамент №6"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Тракия".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №7", "Апартамент №8", "Апартамент №9"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Филиповци".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №10", "Апартамент №11", "Апартамент №12"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Люлин".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №13", "Апартамент №14", "Апартамент №15"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Лаута".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №16", "Апартамент №17", "Апартамент №18"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Каменица".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №19", "Апартамент №20", "Апартамент №21"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Изгрев".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №22", "Апартамент №23", "Апартамент №24"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Орфей".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №25", "Апартамент №26", "Апартамент №27"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Куба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №28", "Апартамент №29", "Апартамент №30"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Дружба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №31", "Апартамент №32", "Апартамент №33"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("".equals(selectedItem)) {
                                                rent.setVisible(false);
                                            }
                                        }
                                    }
                                }
                            });
                        }

                        else if ("Хасково".equals(selectedItem)) {
                            String[] neighborhoodArray = {"Орфей", "Куба", "Дружба"};
                            neighborhood = new JComboBox(neighborhoodArray);
                            neighborhood.setBounds(5, 130, 100, 50);
                            layeredPane.add(neighborhood, Integer.valueOf(3));
                            neighborhood.addItemListener(new ItemListener() {
                                @Override
                                public void itemStateChanged(ItemEvent e) {
                                    if (e.getStateChange() == ItemEvent.SELECTED) {
                                        Object source = e.getSource();
                                        if (source instanceof JComboBox) {
                                            Object selectedItem = neighborhood.getSelectedItem();
                                            if ("Младост".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №1", "Апартамент №2", "Апартамент №3"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Аспарухово".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №4", "Апартамент №5", "Апартамент №6"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Тракия".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №7", "Апартамент №8", "Апартамент №9"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Филиповци".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №10", "Апартамент №11", "Апартамент №12"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Люлин".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №13", "Апартамент №14", "Апартамент №15"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Лаута".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №16", "Апартамент №17", "Апартамент №18"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Каменица".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №19", "Апартамент №20", "Апартамент №21"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Изгрев".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №22", "Апартамент №23", "Апартамент №24"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Орфей".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №25", "Апартамент №26", "Апартамент №27"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Куба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №28", "Апартамент №29", "Апартамент №30"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("Дружба".equals(selectedItem)) {
                                                String[] rentArray = {"Апартамент №31", "Апартамент №32", "Апартамент №33"};
                                                rent = new JComboBox(rentArray);
                                                rent.setBounds(5, 200, 100, 50);
                                                layeredPane.add(rent, Integer.valueOf(4));
                                            }

                                            else if ("".equals(selectedItem)) {
                                                rent.setVisible(false);
                                            }
                                        }
                                    }
                                }
                            });
                        }

                        else if (" ".equals(selectedItem)){
                            neighborhood.setVisible(false);
                            rent.setVisible(false);
                        }
                    }
                }
            }
        });

        rentDetails = new JButton("Детайли");
        rentDetails.setBounds(0,320, 90, 40);

        rentBuy = new JButton("Купи");
        rentBuy.setBounds(109,320, 90, 40);


        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 400);
        layeredPane.add(background, Integer.valueOf(0));
        layeredPane.add(backButton, Integer.valueOf(1));
        layeredPane.add(city, Integer.valueOf(2));
        layeredPane.add(placeholder, Integer.valueOf(5));
        layeredPane.add(rentDetails, Integer.valueOf(6));
        layeredPane.add(rentBuy, Integer.valueOf(7));

        this.setTitle("Купи апартамент");
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
                this.dispose();
                new MainMenu();

        }
    }
}
