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
    private Data() {
    }

    /**
     * @return the Set of Hotels
     */
    public static Set<Hotel> getHotels() {
        return hotelsSet;
    }

    /**
     * Just a Setter for hotels Set
     *
     * @param hotels
     */
    public static void setHotels(Set<Hotel> hotels) {
        hotelsSet = hotels;
    }

    /**
     * @return the Set of Userr
     */
    public static Set<User> getUsers() {
        return usersSet;
    }

    /**
     * Just a Setter for users
     *
     * @param users
     */
    public static void setUsers(Set<User> users) {
        usersSet = users;
    }

}