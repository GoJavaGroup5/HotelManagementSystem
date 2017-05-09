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

        hotels = Data.getHotels();
        result = hotels.add(hotel);
        Data.setHotels(hotels);
        return result;
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
        return (Hotel) hotels.stream().filter(h -> h.getId() == id);
    }

    @Override
    public Set<Hotel> getAllHotels() {
        return Data.getHotels();
    }
}
