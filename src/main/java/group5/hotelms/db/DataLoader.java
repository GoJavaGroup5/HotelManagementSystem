package group5.hotelms.db;

import group5.hotelms.controller.HotelController;
import group5.hotelms.controller.HotelControllerImpl;
import group5.hotelms.controller.UserController;
import group5.hotelms.controller.UserControllerImpl;
import group5.hotelms.model.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Андрей
 */

public class DataLoader {
    private static final String DIRECTORY = "d:\\Projects\\";
    private static HotelController hotels = new HotelControllerImpl();
    private static UserController users = new UserControllerImpl();

    /**
     * This method is created to geerate initial Data
     * Actually it generates Set<User> and Set<Hotel>
     */
    public static void testdata() {
        for (int i = 0; i < 10; i++) {
            users.register(new User("name" + i, "login" + i, "pass" + i));
            Set<Room> rooms = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                rooms.add(new Room(j));
            }
            hotels.add(new Hotel("name" + i, City.KHARKOV, rooms));
        }
    }

    /**
     * Saves Data to file
     */
    //TODO:add user save and read
    public static void save() {
        try {
            final FileOutputStream fos = new FileOutputStream(DIRECTORY
                    + "text.txt");
            final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hotels.getAll());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    /**
     * Loads Data from file
     */
    public static void load() {
        try (FileInputStream fin = new FileInputStream(DIRECTORY
                + "text.txt")) {
            ObjectInputStream ois = new ObjectInputStream(fin);
            HashSet<Hotel> newhotels = (HashSet<Hotel>) ois.readObject();
            Data.setHotels(newhotels);
            System.out.println(Data.getHotels());
        } catch (FileNotFoundException ex) {
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
}
