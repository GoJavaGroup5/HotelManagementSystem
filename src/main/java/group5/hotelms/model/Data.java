package group5.hotelms.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voksus
 */
public final class Data {

    private static Set<Hotel> hotelsSet = new HashSet<>();
    private static Set<User> usersSet = new HashSet<>();

    /**
     * Created just to deny creating instances
     */
    private Data() {}

    /**
     * @return the Set<Hotel>
     */
    public static Set<Hotel> getHotels() {
        return hotelsSet;
    }

    /**
     * Setter for hotels Set<Hotel>
     * @param hotels
     */
    public static void setHotels(Set<Hotel> hotels) {
        hotelsSet = hotels;
    }

    /**
     * @return the Set<User>
     */
    public static Set<User> getUsers() {
        return usersSet;
    }

    /**
     * Setter for users Set<User>
     *
     * @param users
     */
    public static void setUsers(Set<User> users) {
        usersSet = users;
    }

}