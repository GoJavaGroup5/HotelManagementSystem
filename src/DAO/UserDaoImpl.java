package DAO;

import model.Data;
import model.User;

/**
 * Created by Андрей on 26.04.2017.
 */
public class UserDaoImpl implements UserDao {
    Data data;

    public UserDaoImpl(Data data) {
        this.data = data;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public User getUser(String login) {
        return null;
    }
}
