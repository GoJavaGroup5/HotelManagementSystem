package group5.hotelms.model;

import java.util.Set;

public class Hotel {
    private long id;
    private String name;
    private City city;
    private Set<Room> rooms;

    public Hotel(String name, City city, Set<Room> rooms) {
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
