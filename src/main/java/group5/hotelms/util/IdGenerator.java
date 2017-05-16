package group5.hotelms.util;

import group5.hotelms.model.Data;

import java.util.TreeSet;

/**
 * @author Andey Ponomarenko
 *         This class generates id for Hotels
 */
public final class IdGenerator {

    private IdGenerator() {}

    /**
     * This method generates ids for Hotel
     *
     * @return id
     */
    public static int generateId() {
        TreeSet<Integer> ts = new TreeSet<Integer>();
        if (Data.getHotels().isEmpty()) {
            return 0;
        }
        Data.getHotels().stream().forEach(h -> ts.add(h.getId()));
        return ts.last() + 1;
    }

}