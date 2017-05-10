package group5.hotelms.controller;

import group5.hotelms.dao.HotelDAO;
import group5.hotelms.dao.HotelDAOImpl;
import group5.hotelms.model.City;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.Room;
import group5.hotelms.model.User;
import group5.hotelms.util.DataLoader;
import group5.hotelms.util.DataLoaderImpl;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is created to get access to Hotels and Rooms
 */
public class HotelControllerImpl implements HotelController {
    /**
     * @param dataLoader @see DataLoader
     * @param hotelDAO @see HotelDAO
     */
    DataLoader dataLoader = new DataLoaderImpl();
    HotelDAO hotelDAO = new HotelDAOImpl();

    /**
     * this method gets Hotel by id
     *
     * @param id
     * @return Hotel
     */
    public Hotel getHotelById(long id) {
        return hotelDAO.getAllHotels().stream().filter(h -> h.getId() == id).findFirst().get();
    }

    /**
     * This method adds hotel to the global Hotels Set
     *
     * @param hotel
     * @return the result of Hotel adding
     */
    public boolean add(Hotel hotel) {
        return hotelDAO.saveHotel(hotel);
    }

    /**
     * This method removes Hotel from global Hote's Ses
     *
     * @param hotel
     * @return the result of Hotel deleting
     */
    public boolean remove(Hotel hotel) {
        return hotelDAO.deleteHotel(hotel);
    }

    /**
     * This method edits the Hotel
     *
     * @param hotel
     * @return the result of editing the Hotel
     */
    public boolean edit(Hotel hotel) {
        return hotelDAO.saveHotel(hotel);
    }

    /**
     * This metod adds Room to the hotel
     *
     * @param hotel
     * @param room
     * @return the boolean result of adding Room
     */
    public boolean addRoom(Hotel hotel, Room room) {
        if (hotel.getRooms().contains(room)) return false;
        return hotel.getRooms().add(room);
    }

    /**
     * This method edits Room
     *
     * @param hotel
     * @param room
     * @return
     */
    public boolean editRoom(Hotel hotel, Room room) {
        if (!hotel.getRooms().contains(room)) return false;
        return hotel.getRooms().add(room);
    }

    /**
     * This is the method to remove Room from Hotel
     *
     * @param hotel
     * @param room
     * @return
     */
    public boolean removeRoom(Hotel hotel, Room room) {
        if (!hotel.getRooms().contains(room)) return false;
        return hotel.getRooms().remove(room);
    }

    /**
     * @param hotel
     * @return Set of free rooms in the hotel
     */
    public Set<Room> getFreeRooms(Hotel hotel) {
        return hotel.getRooms().stream().filter(r -> r.isAvailable()).collect(Collectors.toSet());
    }

    /**
     * @param name
     * @return Set of Hotels named by name param
     */
    public Set<Hotel> findHotelByName(String name) {
        return hotelDAO.getAllHotels().stream().filter(h -> h.getName() == name).collect(Collectors.toSet());
    }

    /**
     * @param city
     * @return Set of Hotels in the city
     */
    public Set<Hotel> findHotelByCity(City city) {

        return hotelDAO.getAllHotels().stream().filter(h -> h.getCity() == city).collect(Collectors.toSet());
    }

    /**
     * This metod makes the room booked and ads a User to the Room
     *
     * @param hotel
     * @param room
     * @param user
     * @return the boolean result
     */
    public boolean bookRoom(Hotel hotel, Room room, User user) {
        if (hotel == null || room == null || user == null) return false;
        room.setUser(user);
        return true;
    }

    /**
     * This metod Cancels Room book
     *
     * @param hotel
     * @param room
     * @return boolean result of book canceling
     */
    public boolean bookCancel(Hotel hotel, Room room) {

        if (hotel == null || room == null) return false;
        room.setUser(null);
        return true;
    }

    /**
     * This method returns all booked rooms in Hotel
     *
     * @param hotel
     * @return Set of booked Rooms
     */
    public Set<Room> getBookedRooms(Hotel hotel) {
        return hotel.getRooms().stream().filter(r -> !r.isAvailable()).collect(Collectors.toSet());
    }
}
