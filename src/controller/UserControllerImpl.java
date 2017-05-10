package controller;

import dao.HotelDAO;
import dao.HotelDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Data;
import model.Hotel;
import model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by Svetlana Kahanets on 03.05.2017.
 */
public class UserControllerImpl implements UserController {

    private UserDAO userDAO = new UserDAOImpl();
    private HotelDAO hotelDAO = new HotelDAOImpl();
//    private Set<Hotel> hotels;
//    private Set<User> users;

    /**
     * Save the user if it is not present in the database.
     *
     * @param user
     * @return
     */
    public boolean register(User user) {

        if (userDAO.getUser(user.getLogin()) != null) {
            return false;
        }

        return userDAO.saveUser(user);
    }

    /**
     * Delete user, check the room reservation by the user. Check the presence of the user in the database.
     *
     * @param user
     * @return
     */
    public boolean remove(User user) {

        if (hotelDAO.getAllHotels().stream()
                .anyMatch(hotel -> hotel.getRooms().stream()
                        .anyMatch(room -> room.getUser().equals(user)))
                ) {
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

        if (userDAO.getUser(user.getLogin()) != null) {
            return userDAO.saveUser(user);
        }
        return false;

    }
}