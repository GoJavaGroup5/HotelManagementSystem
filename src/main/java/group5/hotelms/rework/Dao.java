package group5.hotelms.rework;

import java.util.Set;

/**
 * Created by Андрей on 16.05.2017.
 */
public interface Dao<T> {
    boolean add(T e);

    boolean remove(T e);

    boolean update(T e);

    T get( T e);

    Set<T> getlAll();

}

