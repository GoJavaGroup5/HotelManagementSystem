package util;

import controller.UserControllerImpl;
import model.*;

import java.io.*;
import java.util.Set;

/**
 * The {@code DataLoaderImpl} class represents a solution to load
 * data in Hotel Management System from a file and store to it in
 * JSON format. Also it using property-file with self configuration.
 *
 * @author voksus on 26.04.2017.
 */
public class DataLoaderImpl implements DataLoader {

    private static Data data;
    private static JsonTool jsonTool;
    private static String jsonString;

    private Hotel hotel;

    private Set<Hotel> hotels;                          // local collection to store hotels
    private Room room;

    private Set<Room> rooms;                            // local collection to store rooms
    private User user;

    private Set<User> users;                            // local collection to store users and reserved room

//    private Properties property = new Properties();     // to get properties

//    private String fileHMSDB;
//    private String msgFileNotFound;                     // text message to say The file was not found
//    private String msgFileUnableToRead;                 // text message to say The file unable to read or store

//    private String h, hName, hCity, hRL;                // markers for Hotel and it's fields ID/name/city
//    private String r, rN, rAv, rUser;                   // markers for Room and it's fields number/available/user
//    private String u, uName, uLogin, uPass;             // markers for User and it's fields name/login/password

    public DataLoaderImpl() {

        try {
            jsonString = loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        data = new Data(getHotels(), getUsers());

    }

    /**
     * This method has a main function to load data from the file
     * directly in HotelManagementSystem's database.
     * It used properties saved in file config.properties
     */
    private String loadDataFromFile() throws IOException {

        String result = null;

        // trying to load data from existing file
        try (FileInputStream fis = new FileInputStream(HMSprop.HMS_FILENAME.toString());
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            result = br.readLine();

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }

        return result;
    }

    private Room createRoom() {
        room = new Room(Integer.valueOf(HMSprop.ROOM_NUMBER.toString()));
        room.setAvailable(Boolean.valueOf(HMSprop.ROOM_AVAILABLE.toString()));
        room.setUser(user);
        return room;
    }

    /**
     * The {@code createUser} method creates the user directly in Data.users collection
     *
     * @return created user or null
     */
    private User createUser() {
        boolean isCreated = new UserControllerImpl().register(user);
        if (isCreated) {
            users.add(user);
        }
        return user;
    }

    /**
     * The {@code preparePropertyAccess} method preparing fields to parse JSON-data
     * with correct signature using data from config.properties file.
     */
    private void preparePropertyAccess() {

//        fileHMSDB = property.getProperty("fileNameHMSDataBase");
//        msgFileNotFound = property.getProperty("fileNotFound");
//        msgFileUnableToRead = property.getProperty("fileUnableToRead");

//        h = property.getProperty("hotel");
//        hName = property.getProperty("hotel.name");
//        hCity = property.getProperty("hotel.city");
//        hRL = property.getProperty("hotel.rooms");

//        r = property.getProperty("room");
//        rN = property.getProperty("room.number");
//        rAv = property.getProperty("room.available");
//        rUser = property.getProperty("room.user");

//        u = property.getProperty("user");
//        uName = property.getProperty("user.name");
//        uLogin = property.getProperty("user.login");
//        uPass = property.getProperty("user.pass");

    }

    @Override
    public Set<Hotel> getHotels() {
        return Data.getHotels();
    }

    @Override
    public Set<User> getUsers() {
        return Data.getUsers();
    }

    @Override
    public boolean saveData(Data data) {

        String result = jsonTool.generateJSON(users, hotels);

        try (FileOutputStream fos = new FileOutputStream(HMSprop.HMS_FILENAME.toString());
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write(result);

        } catch (IOException e) {
            System.err.println(HMSprop.MSG_FILE_USING_ERROR.toString() + HMSprop.HMS_FILENAME.toString());
            return false;
        }

        return !"".equals(result);
    }
}