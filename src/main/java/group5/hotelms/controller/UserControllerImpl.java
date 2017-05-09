package group5.hotelms.controller;

import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.User;

import java.util.HashSet;
import java.util.Set;


/**
 * @author by Svetlana Kahanets on 03.05.2017.
 */
public class UserControllerImpl implements UserController {


    private UserDAO userDAO = new UserDAOImpl();
    private Set<Hotel> hotels = new HashSet<>();
    private Set<User> users = new HashSet<>();

    /**
     * Save the user if it is not present in the database.
     *
     * @param user
     * @return
     */


    public boolean register(User user) {

        users = Data.getUsers();

        if (users.stream().noneMatch(t -> t.equals(user))) {


            return userDAO.saveUser(user);
        }
        return false;
    }

    /**
     * Delete user, check the room reservation by the user. Check the presence of the user in the database.
     *
     * @param user
     * @return
     */


    public boolean remove(User user) {

        hotels = Data.getHotels();
        users = Data.getUsers();

        Set<Hotel> hotelsWithUser = (Set<Hotel>) hotels.stream().filter(h -> h.getRooms().stream().anyMatch(r -> r.getUser().getLogin().equals(user.getLogin())));

        if ((userDAO.getUser(user.getLogin())==null) || users.stream().noneMatch(t -> t.equals(user))) {


            return false;
        }
        return userDAO.deleteUser(user);

    }

    /**
     * Edit the user if it is present in the database.
     *
     * @param user
     * @return
     */

    public boolean edit(User user) {

        users = Data.getUsers();

        if (users.stream().anyMatch(t -> t.equals(user))) {


            return userDAO.saveUser(user);
        }
        return false;


    }
}
