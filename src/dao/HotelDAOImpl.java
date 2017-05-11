package dao;

import model.Data;
import model.Hotel;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelDAOImpl implements HotelDAO {
    private Set<Hotel> hotels;
    private boolean result;

    @Override
    public boolean saveHotel(Hotel hotel) {
        return Data.getHotels().add(hotel);
    }

    @Override
    public boolean deleteHotel(Hotel hotel) {
        return Data.getHotels().remove(hotel);
    }

    @Override
    public Hotel getHotelById(long id) {
        return Data.getHotels().stream().filter(h -> h.getId() == id).findFirst().get();
    }

    @Override
    public Set<Hotel> getAllHotels() {
        return Data.getHotels();
    }
}
