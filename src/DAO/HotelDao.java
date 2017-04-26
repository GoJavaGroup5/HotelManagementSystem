package DAO;

import model.Hotel;

import java.util.List;

public interface HotelDao {
    boolean saveHotel(Hotel hotel);
    boolean deleteHotel(Hotel hotel);
    Hotel getHotelById(long id);
    List<Hotel> getAllHotels();
}
