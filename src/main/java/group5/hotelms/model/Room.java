package group5.hotelms.model;

public class Room {
    private int number;
    private boolean available;
    private User user;

    public Room(int number) {
        this.number = number;
        available = true;
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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        //TODO:remove available from gui
        this.user = user;
        available = user == null;
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
                ", available=" + available +
                ", user=" + user +
                '}';
    }
}
