package util;

import model.Data;
import model.Hotel;
import model.User;

import java.util.Set;

/**
 * @author voksus on 26.04.2017.
 */
public interface DataLoader {

    Set<Hotel> getHotels();

    Set<User> getUsers();

    boolean saveData(Data data);

}