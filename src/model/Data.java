package model;

import java.util.Set;

public class Data {

    private static Set<Hotel> hotels;
    private static Set<User> users;

    public Data(Set<Hotel> hotels, Set<User> users) {
        this.hotels = hotels;
        this.users = users;
    }

    public static Set<Hotel> getHotels() {
        return hotels;
    }

    public static void setHotels(Set<Hotel> hotels_Set) {
        hotels = hotels_Set;
    }

    public static Set<User> getUsers() {
        return users;
    }

    public static void setUsers(Set<User> users_Set) {
        users = users_Set;
    }
}
