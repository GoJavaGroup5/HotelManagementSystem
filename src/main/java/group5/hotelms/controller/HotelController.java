package group5.hotelms.controller;


import group5.hotelms.model.City;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.Room;
import group5.hotelms.model.User;

import java.util.Set;

public interface HotelController {

    long getHotelById();

    boolean add(Hotel hotel);

    boolean remove(Hotel hotel);

    boolean edit(Hotel hotel);

    boolean addRoom(Hotel hotel, Room room);

    boolean editRoom(Hotel hotel, Room room);

    boolean removeRoom(Hotel hotel, Room room);

    Set<Room> getFreeRooms(Hotel hotel);

    Set<Room> getBookedRooms(Hotel hotel);

    Set<Hotel> findHotelByName(String name);

    Set<Hotel> findHotelByCity(City city);

    boolean bookRoom(Hotel hotel, Room room, User user);

    boolean bookCancel(Hotel hotel, Room room);
}
