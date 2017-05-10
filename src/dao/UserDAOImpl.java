package dao;

import model.Data;
import model.Hotel;
import model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voksus on 26.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    private Set<User> users;
//    private Set<Hotel> hotels;

    @Override
    public boolean saveUser(User user) {

//        if(Data.getUsers() != null) {
//            users = Data.getUsers();
//        } else {
//            users = new HashSet<>();
//        }

        try {

//            users.add(user);
//            Data.setUsers(users);
            Data.getUsers().add(user);

        } catch (Exception e) {

            System.err.println("User can not be saved.");
            return false;

        }

        return true;

    }

    @Override
    public boolean deleteUser(User user) {

//        users = Data.getUsers();
//        hotels = Data.getHotels();
//
//        users.remove(user);
//        Data.setUsers(users);
        Data.getUsers().remove(user);
        return true;

    }

    @Override
    public User getUser(String login) {

        Data.getUsers().stream().filter(user -> user.getLogin().equals(login)).findFirst().ifPresent(User::get);
        return null;

    }

}