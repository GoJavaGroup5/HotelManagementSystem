package group5.hotelms.util;

/**
 * @author by Svetlana Kahanets on 05.05.2017.
 */

public final class IdGenerator {

    private static int idCount = 0;

    private IdGenerator() {
    }

    public static int generateId() {

        return ++idCount;
    }
}
