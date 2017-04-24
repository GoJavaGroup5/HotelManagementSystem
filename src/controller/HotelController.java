package controller;

import model.City;
import model.Hotel;
import model.Room;
import model.User;

import java.util.List;

public interface HotelController {
boolean add(Hotel hotel );
boolean remove(Hotel hotel);
boolean edit(Hotel hotel);

boolean addRoom(Hotel hotel, Room room);
boolean editRoom(Hotel hotel, Room room);
boolean removeRoom(Hotel hotel, Room room);

List<Room> getFreeRooms(Hotel hotel);
List<Hotel> findHotelByName(String name);
List<Hotel> findHotelByCity(City city);

boolean bookRoom(Hotel hotel, Room room, User user);
boolean bookCancel(Hotel hotel, Room room);
}
