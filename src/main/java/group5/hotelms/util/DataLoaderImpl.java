package group5.hotelms.util;

import group5.hotelms.model.Data;
import group5.hotelms.model.Hotel;
import group5.hotelms.model.User;

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

//    private static JsonTool jsonTool;
    private static String jsonString;

    public DataLoaderImpl() {

        try {
            jsonString = loadDataFromFile();
        } catch (IOException e) {
            System.err.println("Something wrong...");
            e.printStackTrace();
        }

        System.out.println("[" + jsonString + "]");
        if (!"".equals(jsonString)) {
            JsonTool.parseJSON(jsonString);
        }

    }

    /**
     * This method has a main function to load data from the file
     * directly in HotelManagementSystem's database.
     * It used properties saved in file config.properties
     */
    private String loadDataFromFile() throws IOException {

        String result;

        // trying to load data from existing file
        try (FileInputStream fis = new FileInputStream(HMSprop.HMS_FILENAME.toString());
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            result = br.readLine();
            result = result == null ? "" : result;

        } catch (FileNotFoundException e) {
            try (FileOutputStream fos = new FileOutputStream(HMSprop.HMS_FILENAME.toString());
                 OutputStreamWriter osw = new OutputStreamWriter(fos);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.flush();
            }
//            saveData();
            System.err.println(HMSprop.MSG_FILE_NOT_FOUND.toString() + HMSprop.HMS_FILENAME.toString());
            throw e;
        } catch (IOException e) {
            System.err.println(HMSprop.MSG_FILE_USING_ERROR.toString() + HMSprop.HMS_FILENAME.toString());
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
    public boolean saveData() {

        if(Data.getUsers() == null || Data.getHotels() == null) {
            return false;
        }

        String result = JsonTool.generateJSON(Data.getUsers(), Data.getHotels());
        System.out.println(result);

        try (FileOutputStream fos = new FileOutputStream(HMSprop.HMS_FILENAME.toString());
             OutputStreamWriter osw = new OutputStreamWriter(fos);
             BufferedWriter bw = new BufferedWriter(osw)) {

            bw.write(result);

        } catch (IOException e) {
            System.err.println(HMSprop.MSG_FILE_USING_ERROR.toString() + HMSprop.HMS_FILENAME.toString());
//            System.out.println("File could not be saved.");
            return false;
        }

        return !"".equals(result);
    }

}