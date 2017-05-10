package group5.hotelms.model;

/**
 * @author Andrey on 24.04.2017.
 */
public class Room {
    private int number;
    private boolean available;
    private User user;

    public Room(int number) {
        this.number = number;
        this.available = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "| <" + number +
                "> " + (user == null ? "empty" : "used by " + user.getName()) +
                " |";
    }
}