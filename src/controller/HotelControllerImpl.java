package controller;

import model.City;
import model.Hotel;
import model.Room;
import model.User;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelControllerImpl implements HotelController {

    @Override
    public Hotel getHotelById(Long id) {
        return null;
    }

    @Override
    public boolean add(Hotel hotel) {
        return false;
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
        return false;
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
