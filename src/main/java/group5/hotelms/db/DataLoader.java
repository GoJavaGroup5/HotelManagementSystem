package group5.hotelms.db;

import group5.hotelms.controller.HotelController;
import group5.hotelms.controller.HotelControllerImpl;
import group5.hotelms.controller.UserController;
import group5.hotelms.controller.UserControllerImpl;
import group5.hotelms.model.*;

import java.io.*;
import java.util.*;

/**
 * @author Andrey and voksus
 */

public class DataLoader {

    private static final String DIRECTORY = "src/main/java/group5/hotelms/";
    private static final String FILENAME = "DB.obj";
    private static Object[] DB = new Object[2];

    private static HotelController hotelController = new HotelControllerImpl();
    private static UserController userController = new UserControllerImpl();

    /**
     * This method is created to generate initial Data
     * Actually it generates Set<User> and Set<Hotel>
     */
    public static void testdata() {

        Random r = new Random();

        for (int i = 0; i < 10; i++) {

            User user = new User("Name" + i, "Login_0" + i, "p" + (r.nextInt(899) + 100));
            userController.register(user);
            Set<Room> rooms = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                rooms.add(new Room(j));
            }
            Hotel hotel = new Hotel("name" + i, City.KHARKOV, rooms);
            hotelController.add(hotel);
            if (r.nextBoolean()) {
                hotelController.bookRoom(hotel, r.nextInt(9), user);
            }
        }
    }

    /**
     * Saves Data to file
     */
    public static void save() {
        try (FileOutputStream fos = new FileOutputStream(DIRECTORY + FILENAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            DB[0] = Data.getHotels();
            DB[1] = Data.getUsers();
            oos.writeObject(DB);

        } catch (FileNotFoundException e) {
            System.out.println(e.getStackTrace());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Loads Data from file
     */
    public static void load() {
        try (FileInputStream fis = new FileInputStream(DIRECTORY + FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            DB = (Object[]) ois.readObject();

            Data.setHotels((Set<Hotel>) DB[0]);
            Data.setUsers((Set<User>) DB[1]);

        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException :(");
        } catch (IOException e) {
            System.err.println("IOException :(");
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException :(");
        }
    }

}