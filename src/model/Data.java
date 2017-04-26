package model;

import java.util.List;

public class Data {
    List<Hotel> hotels ;
    List<User> users ;

    public Data(List<Hotel> hotels, List<User> users) {
        this.hotels = hotels;
        this.users = users;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
