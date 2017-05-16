package group5.hotelms.dao;

import group5.hotelms.model.User;

import java.util.Set;

/**
 * @author Andey Ponomarenko
 */
public interface UserDAO {

    boolean saveUser(User user);

    boolean deleteUser(User user);

    User getUser(String login);

    Set<User> getAllUsers();

}