package group5.hotelms.controller;

import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.Data;
import group5.hotelms.model.User;
import group5.hotelms.util.DataLoader;
import group5.hotelms.util.DataLoaderImpl;


/**
 * Author by Svetlana Kahanets on 03.05.2017.
 */
public class UserControllerImpl implements UserController {


    private DataLoader dataLoader = new DataLoaderImpl();
    private UserDAO userDAO = new UserDAOImpl(new Data(dataLoader.getHotels(), dataLoader.getUsers()));


    public boolean register(User user) {


        return userDAO.saveUser(user);
    }

    public boolean remove(User user) {


        return userDAO.deleteUser(user);
    }

    public boolean edit(User user) {


        return userDAO.saveUser(user);
    }
}
