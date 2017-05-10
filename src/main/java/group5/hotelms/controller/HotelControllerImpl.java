package group5.hotelms.controller;


import group5.hotelms.dao.HotelDAO;
import group5.hotelms.dao.HotelDAOImpl;
import group5.hotelms.model.City;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.Room;
import group5.hotelms.model.User;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelControllerImpl implements HotelController {

    HotelDAO hotelDAO = new HotelDAOImpl();

    @Override
    public long getHotelById() {
        return Long.parseLong(null);
    }

    @Override
    public boolean add(Hotel hotel) {

        if (hotel == null) {
            return false;
        }

        return hotelDAO.saveHotel(hotel);
    }

    @Override
    public boolean remove(Hotel hotel) {
        return false;
    }

    @Override
    public boolean edit(Hotel hotel) {
        return false;
    }

    @Override
    public boolean addRoom(Hotel hotel, Room room) {
        return false;
    }

    @Override
    public boolean editRoom(Hotel hotel, Room room) {
        return false;
    }

    @Override
    public boolean removeRoom(Hotel hotel, Room room) {
        return false;
    }

    @Override
    public Set<Room> getFreeRooms(Hotel hotel) {
        return null;
    }

    @Override
    public Set<Hotel> findHotelByName(String name) {
        return null;
    }

    @Override
    public Set<Hotel> findHotelByCity(City city) {
        return null;
    }

    @Override
    public boolean bookRoom(Hotel hotel, Room room, User user) {
        try {
            room.setAvailable(false);
            room.setUser(user);
            Set<Room> rooms = hotel.getRooms();
            rooms.add(room);
            hotel.setRooms(rooms);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean bookCancel(Hotel hotel, Room room) {
        return false;
    }

    @Override
    public Set<Room> getBookedRooms(Hotel hotel) {
        return null;
    }
}
