package group5.hotelms.dao;


import group5.hotelms.model.Hotel;
import java.util.Set;

public interface HotelDAO {
    boolean saveHotel(Hotel hotel);

    boolean deleteHotel(Hotel hotel);

    Hotel getHotelById(long id);

    Set<Hotel> getAllHotels();
}
