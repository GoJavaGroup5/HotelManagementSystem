package group5.hotelms.gui;

import group5.hotelms.util.DataLoader;
import group5.hotelms.util.DataLoaderImpl;

import javax.swing.*;

/**
 * Created by Андрей on 07.05.2017.
 */
public class form {
    private JButton addUserButton;
    private JPanel mainPanel;
    private JComboBox userCombo;
    private JComboBox hotelCombo;

    public form() {
        userCombo.addItem("Add User");
        userCombo.addItem("Edit User");
        userCombo.addItem("Delete User");

        hotelCombo.addItem("Add Hotel");
        hotelCombo.addItem("Delete Hotel");
        hotelCombo.addItem("Hotel Menu");

        userCombo.addActionListener(new ActionListener() {
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
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new form().mainPanel);
        jFrame.setDefaultCloseOperation(close());
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static int close() {
        DataLoader exiter = new DataLoaderImpl();
        exiter.saveData();
        return 3 ;
    }
}
