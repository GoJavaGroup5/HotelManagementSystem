package group5.hotelms.rework.Impl;

import group5.hotelms.rework.Dao;
import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;

import java.util.Set;

/**
 * Created by Андрей on 16.05.2017.
 */
public class HotelDao implements Dao<Hotel> {
    @Override
    public boolean add(Hotel e) {
        return (Data.getHotels().contains(e))?false:Data.getHotels().add(e);
    }

    @Override
    public boolean remove(Hotel e) {
        return(!Data.getHotels().contains(e))?false:Data.getHotels().remove(e);

    }

    @Override
    public boolean update(Hotel e) {
        return !Data.getHotels().contains(e)?false:Data.getHotels().add(e);
    }

    @Override
    public Hotel get(Hotel e) {
        return !Data.getHotels().contains(e)?null:Data.getHotels().stream().filter(h->h.equals(e)).findFirst().get();
    }

    @Override
    public Set<Hotel> getlAll() {
        return Data.getHotels();
    }
}
