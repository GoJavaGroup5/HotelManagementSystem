package gui;

import controller.HotelController;
import controller.HotelControllerImpl;
import model.City;
import model.Hotel;
import model.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by Андрей on 08.05.2017.
 */
public class HotelAddForm {

    public JPanel hotelAddForm;
    HotelController hotelController = new HotelControllerImpl();
    private JTextField nameField;
    private JComboBox cityBox;
    private JButton addButton;
    private JTextField roomField;

    public HotelAddForm() {
        Arrays.stream(City.values()).forEach(c -> cityBox.addItem(c));

        addButton.addActionListener(new ActionListener() {
            /**
             * Add button pressed
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty() || cityBox.getSelectedIndex() == -1 || roomField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You have to fill all fields");
                } else {
                    Set<Room> rooms = null;
                    for (String str : roomField.getText().split(",")) {
                        rooms.add(new Room(Integer.getInteger(str)));
                    }
                    hotelController.add(new Hotel(nameField.getText(), City.valueOf((String) cityBox.getSelectedItem()), rooms));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new HotelAddForm().hotelAddForm);
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(false);
    }
}
