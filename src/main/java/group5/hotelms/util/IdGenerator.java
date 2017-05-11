package group5.hotelms.util;

import group5.hotelms.model.Data;

import java.util.TreeSet;

/**
 * @author Andey Ponomarenko
 *         This class generates id for Hotels
 */

public final class IdGenerator {

    //private static int idCount = 0;

    private IdGenerator() {
    }

    /**
     * This method generates ids for Hotel
     *
     * @return id
     */
    public static int generateId() {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Data.getHotels().stream().forEach(h -> ts.add(h.getId()));
        return ts.last() + 1;
        // return ++idCount;
    }
}
