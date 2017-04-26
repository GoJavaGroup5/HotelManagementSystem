package model;

import java.util.Set;

public class Data {
    private Set<Hotel> hotels;
    private Set<User> users;

    public Data(Set<Hotel> hotels, Set<User> users) {
        this.hotels = hotels;
        this.users = users;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
