package group5.hotelms.dao;


import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelDAOImpl implements HotelDAO {

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
