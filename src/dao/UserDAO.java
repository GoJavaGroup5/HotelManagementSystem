package dao;

import model.User;

public interface UserDAO {

    boolean saveUser(User user);

    boolean deleteUser(User user);

    User getUser(String login);

}