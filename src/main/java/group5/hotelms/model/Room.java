package group5.hotelms.model;

import java.io.Serializable;

/**
 * @author Andrey Ponomarenko
 */
public class Room implements Serializable {

    /**
     * The number of a room
     */
    private int number;

    /**
     * The user Room contains
     */
    private User user;

    /**
     * New Room creates with only number available
     * @param number
     */
    public Room(int number) {
        this.number = number;
    }

    /**
     *
     * @return number of a room
     */
    public int getNumber() {
        return number;
    }

    /**
     * Just a Setter for a Room number
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return availability of a room
     */
    public boolean isAvailable() {
        return user == null;
    }

    /**
     *
     * @return user from a Room
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * equality calculates by number only
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return number == room.number;
    }

    /**
     * Overrides hashcode which is just a room number
     * @return
     */
    @Override
    public int hashCode() {
        return number;
    }

    /**
     * Overrides toString method
     * @return
     */
    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                (isAvailable() ? ", available to book" : ", reserved by " + user.getLogin()) +
                '}';
    }

}