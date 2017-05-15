package group5.hotelms.dao;

import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;

import java.util.Set;

/**
 * @author Andey Ponomarenko
 */
public class HotelDAOImpl implements HotelDAO {

    /**
     * This method is used to add and to edit Hotel
     * @param hotel
     * @return the result of Hotel Saving
     */
    @Override
    public boolean saveHotel(Hotel hotel) {
        return Data.getHotels().add(hotel);
    }

    /**
     * This method deletes Hotel
     * @param hotel
     * @return the result of deleting Hotel
     */
    @Override
    public boolean deleteHotel(Hotel hotel) {
        return Data.getHotels().remove(hotel);
    }

    /**
     * This method returns Hotel by ID
     * @param id
     * @return Hotel by id
     */
    @Override
    public Hotel getHotelById(int id) {
        return Data.getHotels().stream().filter(h -> h.getId() == id).findFirst().get();
    }

    /**
     *
     * @return all Hotels as a Set
     */
    @Override
    public Set<Hotel> getAllHotels() {
        return Data.getHotels();
    }

}