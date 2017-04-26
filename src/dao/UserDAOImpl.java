package dao;

import model.Data;
import model.User;

/**
 * Created by Андрей on 26.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    private Data data;

    public UserDAOImpl(Data data) {
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
