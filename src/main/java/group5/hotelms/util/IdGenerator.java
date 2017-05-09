package group5.hotelms.util;

/**
 * Author by Svetlana Kahanets on 05.05.2017.
 */
public final class IdGenerator {

    private static long idCount = 0;

    private IdGenerator() {
    }


    public static long generateId() {


        return ++idCount;
    }
}
