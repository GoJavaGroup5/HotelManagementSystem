package model;

import java.util.List;

public class Hotel {
    private long id;
    private String name;
    private City city;
    private List<Room> rooms;

    public Hotel(String name, model.City city, List<Room> rooms) {
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(model.City city) {
        this.city = city;
    }

    public void setRooms(List<model.Room> rooms) {
        this.rooms = rooms;
    }
}
