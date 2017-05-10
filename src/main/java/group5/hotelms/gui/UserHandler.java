package group5.hotelms.gui;

import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Андрей on 08.05.2017.
 */
public class UserHandler {
    public JPanel userHandler;
    UserDAO userDAO = new UserDAOImpl();
    private JTextField loginField;
    private JButton findButton;
    private JTextField editLogin;
    private JTextField editName;
    public JPanel userEditor;
    private JPasswordField editPass;
    private JButton removeButton;
    private JButton editButton;


    public UserHandler() {
        findButton.addActionListener(new ActionListener() {
            /**
             * Find button pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField lloginEditor = new JTextField("aaa");
                lloginEditor.setVisible(true);
                userHandler.add(lloginEditor);

                if (loginField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Login is not entered");
                } else {
                    String login = loginField.getText();
                    User user = userDAO.getUser(login);
                    if(user==null){
                        JOptionPane.showMessageDialog(null,"User not found");
                    }
                    else{
                        userEditor.setVisible(true);
                        editLogin.setText(user.getLogin());
                        editName.setText(user.getName());
                        editPass.setText(user.getPass());

                    }
                }
            }
        });

        userEditor.setVisible(false);
        editButton.addActionListener(new ActionListener() {
            /**
             *Edit button pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(editName.getText().isEmpty()||String.valueOf(editPass.getPassword()).equals("")){
                    JOptionPane.showMessageDialog(null,"Empty fields are not allowed");
                }
                else{
                    userDAO.saveUser(new User(editName.getText(),editLogin.getText(),String.valueOf(editPass.getPassword())));
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when delete button pressed
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                if(JOptionPane.showConfirmDialog(null,"Confirm deleting user")==0){
                    userDAO.deleteUser(userDAO.getUser(editLogin.getText()));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new UserHandler().userHandler);
        jFrame.setDefaultCloseOperation(jFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(false);


    }

}
