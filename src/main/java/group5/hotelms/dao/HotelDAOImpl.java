package group5.hotelms.dao;

import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelDAOImpl implements HotelDAO {
    private Set<Hotel> hotels;
    private boolean result;

    @Override
    public boolean saveHotel(Hotel hotel) {

        try {

            Data.getHotels().add(hotel);

        } catch (Exception e) {

            System.err.println("Hotel can not be saved.");
            return false;

        }

        return true;
    }

    @Override
    public boolean deleteHotel(Hotel hotel) {
        hotels = Data.getHotels();
        result = hotels.remove(hotel);
        return result;
    }

    @Override
    public Hotel getHotelById(long id) {
        hotels = Data.getHotels();
        return hotels.stream().filter(hotel -> hotel.getId() == id).findFirst().get();   //.stream().filter(h -> h.getId() == id);
    }

    @Override
    public Set<Hotel> getAllHotels() {
        return Data.getHotels();
    }
}