package group5.hotelms.controller;

import group5.hotelms.dao.HotelDAO;
import group5.hotelms.dao.HotelDAOImpl;
import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.User;

import java.util.HashSet;
import java.util.Set;


/**
 * Author by Svetlana Kahanets on 03.05.2017.
 */
public class UserControllerImpl implements UserController {


    private UserDAO userDAO = new UserDAOImpl();
    private HotelDAO hotelDAO = new HotelDAOImpl();
    private Set<Hotel> hotels = hotelDAO.getAllHotels();
    private Set<User> users = new HashSet<>(Data.getUsers());


    public boolean register(User user) {


        return userDAO.saveUser(user);
    }

    /**
     * Delete user, check the room reservation by the user. Check the presence of the user in the database
     *
     * @param user
     * @return
     */

    public boolean remove(User user) {

        Set<Hotel> hotelsWithUser = (Set<Hotel>) hotels.stream().filter(h -> h.getRooms().stream().anyMatch(r -> r.getUser().getLogin().equals(user.getLogin())));

        if (!hotelsWithUser.isEmpty() || !users.stream().equals(user)) {


            return false;
        }
        return userDAO.deleteUser(user);

    }


    public boolean edit(User user) {


        return userDAO.saveUser(user);
    }
}
