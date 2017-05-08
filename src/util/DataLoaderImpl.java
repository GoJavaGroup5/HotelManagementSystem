package util;

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

    private static JsonTool jsonTool;
    private static String jsonString;

    private Hotel hotel;

    private Set<Hotel> hotels;                          // local collection to store hotels
    private Room room;

    private Set<Room> rooms;                            // local collection to store rooms
    private User user;

    private Set<User> users;                            // local collection to store users and reserved room

    public DataLoaderImpl() {

        try {
            jsonString = loadDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonTool.parseJSON(jsonString);
//        data = new Data(getHotels(), getUsers());

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