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

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return city
     */
    public City getCity() {
        return city;
    }

    /**
     * @return rooms
     */
    public Set<Room> getRooms() {
        return rooms;
    }

    /**
     * Setter for name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for city
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Setter for rooms
     *
     * @param rooms
     */
    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     * Overrides equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        return id == hotel.id;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public String toString() {
        String roomNumbers = "";
        for (Room room : rooms) {
            roomNumbers += " " + room.getNumber() + (room.isAvailable() ? "+" : "-");
        }
        return "ID=" + id +
                " '" + name + "'" +
                " in " + city +
                ". Rooms: " + (roomNumbers.equals("")?" -no rooms-":roomNumbers);
    }
}
