package model;

import java.util.Set;

public final class Data {

    private static Set<Hotel> hotelsSet;
    private static Set<User> usersSet;

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