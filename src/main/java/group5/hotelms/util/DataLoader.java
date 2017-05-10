package group5.hotelms.util;


import group5.hotelms.model.Hotel;
import group5.hotelms.model.User;

import java.util.Set;

/**
 * @author voksus on 26.04.2017.
 */
public interface DataLoader {

    Set<Hotel> getHotels();

    Set<User> getUsers();

    boolean saveData();

}