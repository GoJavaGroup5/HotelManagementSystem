package util;

import model.Hotel;
import model.User;

import java.util.List;

/**
 * Created by Андрей on 26.04.2017.
 */
public interface DataLoader {
    List<Hotel> getHotels();
    List<User> getUsers();
}
