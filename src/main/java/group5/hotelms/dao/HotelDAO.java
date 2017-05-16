package group5.hotelms.dao;

import group5.hotelms.model.Hotel;
import java.util.Set;
/**
 * @author Andey Ponomarenko
 */

/**
 * @author Andey Ponomarenko
 */
public interface HotelDAO {

    boolean saveHotel(Hotel hotel);

    boolean deleteHotel(Hotel hotel);

    Hotel getHotelById(int id);

    Set<Hotel> getAllHotels();

}