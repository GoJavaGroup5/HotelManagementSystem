package group5.hotelms.model;

import java.io.Serializable;

public class Room implements Serializable{

    private int number;
    private User user;

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return user == null;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        return number == room.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                (isAvailable() ? ", available to book" : ", reserved by " + user.getLogin()) +
                '}';
    }
}