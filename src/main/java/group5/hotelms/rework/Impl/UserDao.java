package group5.hotelms.rework.Impl;

import group5.hotelms.rework.Dao;
import group5.hotelms.model.Data;
import group5.hotelms.model.User;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Андрей on 16.05.2017.
 */
public class UserDao implements Dao<User> {
    @Override
    public boolean add(User e) {
        return Data.getUsers().contains(e)?false:Data.getUsers().add(e);
    }

    @Override
    public boolean remove(User e) {
        return !Data.getUsers().contains(e)?false:Data.getUsers().remove(e);
    }

    @Override
    public boolean update(User e) {
        return !Data.getUsers().contains(e)?false:Data.getUsers().add(e);
    }

    @Override
    public User get(User entity) {
        Optional<User> optional = Data.getUsers().stream().filter(u->u.equals(entity)).findFirst();
       return optional.isPresent()?optional.get():null;
    }

    @Override
    public Set<User> getlAll() {
        return Data.getUsers();
    }

}
