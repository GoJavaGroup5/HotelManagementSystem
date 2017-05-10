package group5.hotelms.dao;

import group5.hotelms.model.User;

public interface UserDAO {
    boolean saveUser(User user);

    boolean deleteUser(User user);

    User getUser(String login);
}
