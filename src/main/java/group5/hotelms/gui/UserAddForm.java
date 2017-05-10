package group5.hotelms.gui;

import group5.hotelms.controller.UserController;
import group5.hotelms.controller.UserControllerImpl;
import group5.hotelms.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 07.05.2017.
 */
public class UserAddForm {
    public JPanel userAddForm;
    private JTextField nameFiled;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton addButton;

    UserController userController = new UserControllerImpl();
    public UserAddForm() {
        addButton.addActionListener(new ActionListener() {
            /**
             * Button User Add clicked
             * actually we are adding new user right now
             *
             * @param e
             */
            public void actionPerformed(ActionEvent e) {
                if ((nameFiled.getText().equals("")) || loginField.getText().equals("") || String.valueOf(passwordField.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(null, "You have to fill all fields");
                } else {
                    userController.register(new User(nameFiled.getText(),loginField.getText(),String.valueOf(passwordField.getPassword())));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new UserAddForm().userAddForm);
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(false);
    }


}
