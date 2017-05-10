package model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voksus
 */
public final class Data {

    private static Set<Hotel> hotelsSet = new HashSet<>();
    private static Set<User> usersSet = new HashSet<>();

    private Data() {
    }

    public static Set<Hotel> getHotels() {
        return hotelsSet;
    }

    public static void setHotels(Set<Hotel> hotels) {
        hotelsSet = hotels;
    }

    public static Set<User> getUsers() {
        return usersSet;
    }

    public static void setUsers(Set<User> users) {
        usersSet = users;
    }

}