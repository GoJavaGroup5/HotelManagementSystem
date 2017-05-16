package group5.hotelms.controller;

import group5.hotelms.model.User;
/**
 * @author Andey Ponomarenko
 */

import java.util.Set;

/**
 * @author Andey Ponomarenko
 */

public interface UserController {

    boolean register(User user);

    boolean remove(User user);

    boolean edit(User user);

    User getUserByLogin(String login);

    Set<User> getAllUsers();

}