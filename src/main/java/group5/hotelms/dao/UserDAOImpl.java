package group5.hotelms.dao;

import group5.hotelms.model.Data;
import group5.hotelms.model.User;

import java.util.Set;

public class UserDAOImpl implements UserDAO {
    /**
     * This method adds and edits users
     *
     * @param user
     * @return the result of user adding/editing
     */
    @Override
    public boolean saveUser(User user) {
        try {
            Data.getUsers().add(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * This method deletes User
     *
     * @param user
     * @return the result of user deleting
     */
    @Override
    public boolean deleteUser(User user) {
        return Data.getUsers().remove(user);
    }

    /**
     * gets user by login
     *
     * @param login
     * @return User by login
     */
    @Override
    public User getUser(String login) {
        if (!Data.getUsers().stream().filter(user -> user.getLogin().equals(login)).findFirst().isPresent()) {
            return null;
        }
        return Data.getUsers().stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

    @Override
    public Set<User> getAllUsers() {
        return Data.getUsers();
    }
}