package dao;

import model.Data;
import model.Hotel;

import java.util.Set;

/**
 * Created by Андрей on 26.04.2017.
 */
public class HotelDAOImpl implements HotelDAO {

    private Data data;

    public HotelDAOImpl(Data data) {
        this.data = data;
    }

    @Override
    public boolean saveHotel(Hotel hotel) {
        return false;
    }

    @Override
    public boolean deleteHotel(Hotel hotel) {
        return false;
    }

    @Override
    public Hotel getHotelById(long id) {
        return null;
    }

    @Override
    public Set<Hotel> getAllHotels() {
        return null;
    }
}
