package group5.hotelms.dao;

import group5.hotelms.LoggerExample;
import group5.hotelms.model.Data;
import group5.hotelms.model.User;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean saveUser(User user) {

        try {
            Data.getUsers().add(user);
        } catch (Exception e) {
            LoggerExample.log(e);
            //System.err.println("User can not be saved.");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(User user) {
        return Data.getUsers().remove(user);
    }

    @Override
    public User getUser(String login) {
        //TODO:return user
        Data.getUsers().stream().filter(user -> user.getLogin().equals(login)).findFirst().ifPresent(User::get);
        return null;
    }

}