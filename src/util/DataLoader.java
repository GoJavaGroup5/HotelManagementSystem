package util;

import model.Hotel;
import model.User;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public interface DataLoader {
    Set<Hotel> getHotels();

    Set<User> getUsers();

    boolean saveData();
}
