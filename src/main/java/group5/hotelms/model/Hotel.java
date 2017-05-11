package group5.hotelms.model;

import group5.hotelms.util.IdGenerator;

import java.io.Serializable;
import java.util.Set;

public class Hotel implements Serializable {
    private int id;
    private String name;
    private City city;
    private Set<Room> rooms;

    public Hotel(String name, City city, Set<Room> rooms) {
        id = IdGenerator.generateId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        return id == hotel.id;
    }

    @Override
    public int hashCode() {
        return (int)id;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", rooms=" + rooms +
                '}';
    }
}
