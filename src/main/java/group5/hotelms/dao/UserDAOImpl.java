package group5.hotelms.dao;

import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class UserDAOImpl implements UserDAO {

    private Set<User> users;
    private Set<Hotel> hotels;

    public UserDAOImpl() {
        users = new HashSet<>(Data.getUsers());
        hotels = new HashSet<>(Data.getHotels());
    }

    @Override
    public boolean saveUser(User user) {

        try {

            users.add(user);

        } catch (Exception e) {

            return false;

        }

        return true;

    }

    @Override
    public boolean deleteUser(User user) {

        if(users.contains(user)) {

            users.remove(user);
            Data.setUsers(users);
            return true;

        }

        return false;

    }

    @Override
    public User getUser(String login) {
//        if(users != null && users.stream().filter(user -> user.getLogin().equals(login)) != null) {
//            return users.stream().filter(login::equals).findFirst().get();
//        }

        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst().get();
    }

}