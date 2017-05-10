package group5.hotelms;

import group5.hotelms.controller.HotelController;
import group5.hotelms.controller.HotelControllerImpl;
import group5.hotelms.controller.UserController;
import group5.hotelms.controller.UserControllerImpl;
import group5.hotelms.dao.HotelDAO;
import group5.hotelms.dao.HotelDAOImpl;
import group5.hotelms.dao.UserDAO;
import group5.hotelms.dao.UserDAOImpl;
import group5.hotelms.model.City;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.Room;
import group5.hotelms.model.User;
import group5.hotelms.util.DataLoader;
import group5.hotelms.util.DataLoaderImpl;

import java.util.HashSet;
import java.util.Set;


/**
 * @author voksus on 09.05.2017.
 */
public class Main {


    public static void main(String[] args) {

        MakeNewDemoData.create1stHotelMS();

    }

    /**
     * @author voksus on 09.05.2017.
     */
    private static class MakeNewDemoData {

        static void create1stHotelMS() {

            HotelDAO hotelDAO = new HotelDAOImpl();
            UserController userController = new UserControllerImpl();
            UserDAO userDAO = new UserDAOImpl();
            HotelController hotelController = new HotelControllerImpl();

            userController.register(new User("Vasya", "vas", "123"));
            userController.register(new User("Galya", "gaga2017", "0000"));
            userController.register(new User("Osiya", "o0o0o", "oo00"));
            userController.register(new User("Vetal", "vvvvvvvv", "vv99"));
            userController.register(new User("Alexa", "al2000", "ja[gje1i4w#nq"));
            userController.register(new User("Patap", "lPatap", "pPatap"));
            userController.register(new User("Stasi", "zato4ka", "zszsz777"));

//            System.out.println(Data.getUsers());

            hotelController.add(new Hotel("ABC", City.KIEV, makeNewRooms()));
            hotelController.add(new Hotel("Ququ", City.KIEV, makeNewRooms()));
            hotelController.add(new Hotel("Zupelstakinoff", City.KHARKOV, makeNewRooms()));
            hotelController.add(new Hotel("Plaza", City.KHARKOV, makeNewRooms()));
            hotelController.add(new Hotel("ABC", City.ODESSA, makeNewRooms()));
            hotelController.add(new Hotel("Karnaval", City.ODESSA, makeNewRooms()));

//            System.out.println(Data.getHotels());

            hotelController.bookRoom(hotelDAO.getHotelById(1), new Room(1), userDAO.getUser("vas"));
            hotelController.bookRoom(hotelDAO.getHotelById(2), new Room(1), userDAO.getUser("gaga2017"));
            hotelController.bookRoom(hotelDAO.getHotelById(3), new Room(1), userDAO.getUser("o0o0o"));
            hotelController.bookRoom(hotelDAO.getHotelById(4), new Room(1), userDAO.getUser("vvvvvvvv"));
            hotelController.bookRoom(hotelDAO.getHotelById(5), new Room(1), userDAO.getUser("al2000"));
            hotelController.bookRoom(hotelDAO.getHotelById(6), new Room(1), userDAO.getUser("lPatap"));
            hotelController.bookRoom(hotelDAO.getHotelById(1), new Room(1), userDAO.getUser("zato4ka"));

//            System.out.println(Data.getHotels());

            DataLoader dataLoader = new DataLoaderImpl();
            dataLoader.saveData();

        }

        static Set<Room> makeNewRooms() {

            Set<Room> rooms = new HashSet<>();
            int defaultRoomsCount = 10;

            for (int i = 0; i < defaultRoomsCount; i++) {
                rooms.add(new Room(i + 1));
            }

            return rooms;
        }

    }
}