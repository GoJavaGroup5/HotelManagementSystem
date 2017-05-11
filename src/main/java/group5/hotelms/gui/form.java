package group5.hotelms.gui;

import group5.hotelms.db.DataLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrey Ponomarenko
 */
public class form {
    private JButton addUserButton;
    private JPanel mainPanel;
    private JComboBox userCombo;
    private JComboBox hotelCombo;

    public form() {
        userCombo.addItem("Add User");
        userCombo.addItem("Edit/Delete User");

        hotelCombo.addItem("Add Hotel");
        hotelCombo.addItem("Edit/Delete Hotel");
        hotelCombo.addItem("Hotel Menu");

        userCombo.addActionListener(new ActionListener() {
            /**
             * Here the user menu selection happens
             * Add User opens UserAddForm
             * "Edit/Delete User" opens UserHandler form
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedBook = (String) userCombo.getSelectedItem();
                if (selectedBook.equals("Add User")) {
                    JFrame jFrame = new JFrame();
                    jFrame.setContentPane(new UserAddForm().userAddForm);
                    jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
                    jFrame.pack();
                    jFrame.setVisible(true);
                } else {
                    JFrame jFrame = new JFrame();
                    jFrame.setContentPane(new UserHandler().userHandler);
                    jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
                    jFrame.pack();
                    jFrame.setVisible(true);
                }
            }
        });
        /**
         * Here the hotel menu selection happens
         * Add Hotel opens HotelAddForm
         * Edit/Delete Hotel opens HotelHandler form
         * Hotel Menu is for bookings
         */

        hotelCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = (String) hotelCombo.getSelectedItem();
                if (selectedBook.equals("Add Hotel")) {
                    JFrame jFrame = new JFrame();
                    jFrame.setContentPane(new HotelAddForm().hotelAddForm);
                    jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
                    jFrame.pack();
                    jFrame.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("for1");
        jFrame.setContentPane(new form().mainPanel);
        jFrame.setDefaultCloseOperation(close());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    /**
     * Here Data saves before exit
     * @return 3 like EXIT_ON_CLOSE
     */
    public static int close() {
        DataLoader.save();
        return 3;
    }
}
