package model;

import java.util.Set;

public class Hotel {

    private long id;
    private String name;
    private City city;
    private Set<Room> rooms;

    private static long newID = 0;

    public Hotel(String name, City city, Set<Room> rooms) {
        id = ++newID;
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

    public void setCity(model.City city) {
        this.city = city;
    }

    public void setRooms(Set<model.Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "H{" +
                "id=" + id +
                ", " + name +
                " , ct=" + city +
                ", rms=" + rooms +
                '}';
    }
}