package group5.hotelms.controller;

import group5.hotelms.dao.HotelDAO;
import group5.hotelms.dao.HotelDAOImpl;
import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.Room;
import group5.hotelms.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author by Svetlana Kahanets on 03.05.2017.
 */
public class UserControllerImpl implements UserController {

    private UserDAO userDAO = new UserDAOImpl();
    private HotelDAO hotelDAO = new HotelDAOImpl();

    /**
     * Save the user if it is not present in the database.
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {

        if (userDAO.getUser(user.getLogin()) == null) {

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
    @Override
    public boolean remove(User user) {

        boolean roomsBookedByUser = hotelDAO.getAllHotels().stream()
                .allMatch(hotel -> hotel.getRooms().stream()
                        .allMatch(room -> room.getUser() != user));

        if ((userDAO.getUser(user.getLogin()) != null) && roomsBookedByUser) {
            return userDAO.deleteUser(user);
        }

        return false;

    }

    /**
     * Edit the user if it is present in the database.
     *
     * @param user
     * @return tru if operation success
     */
    @Override
    public boolean edit(User user) {

        if (userDAO.getUser(user.getLogin()) != null) {
            userDAO.getUser(user.getLogin()).setName(user.getName());
            userDAO.getUser(user.getLogin()).setPass(user.getPass());
            return true;
        }
        return false;

    }

    /**
     * Return the user if it is present in the database.
     *
     * @param login
     * @return the user or null
     */
    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUser(login);
    }

    /**
     * Return all users from database
     *
     * @return Set<User> or null
     */
    @Override
    public Set<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

}