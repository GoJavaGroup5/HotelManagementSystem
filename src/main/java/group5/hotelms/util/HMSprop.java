package group5.hotelms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author voksus on 08.05.2017.
 */
public enum HMSprop {

    HMS_FILENAME,
    HOTELS_DB, HOTEL, HOTEL_NAME, HOTEL_CITY, HOTEL_ROOMS,
    ROOM, ROOM_NUMBER, ROOM_AVAILABLE, ROOM_USER,
    USERS_DB, USER, USER_NAME, USER_LOGIN, USER_PASSWORD,
    MSG_FILE_NOT_FOUND, MSG_FILE_USING_ERROR,TOTAL;

    private Properties property = new Properties();

    private String HMSfilename;                     // marker for Json-filename of DataBase
    private String msgFileNotFound;                 // text message to say The file was not found
    private String msgFileReadError;                // text message to say The file unable to read or store
    private String total;                           // informs 'bout capacity of total objects

    private String hDB, h, hName, hCity, hRL;       // markers for Hotel's fields ID/name/city
    private String r, rN, rAv, rUser;               // markers for Room's fields number/available/user
    private String uDB, u, uName, uLogin, uPass;    // markers for User's fields name/login/password

    @Override
    public String toString() {
        String result = null;

        switch (this) {
            case HMS_FILENAME:
                result = HMSfilename;
                break;
            case MSG_FILE_NOT_FOUND:
                result = msgFileNotFound;
                break;
            case MSG_FILE_USING_ERROR:
                result = msgFileReadError;
                break;
            case TOTAL:
                result = total;
                break;
            case HOTELS_DB:
                result = hDB;
                break;
            case HOTEL:
                result = h;
                break;
            case HOTEL_NAME:
                result = hName;
                break;
            case HOTEL_CITY:
                result = hCity;
                break;
            case HOTEL_ROOMS:
                result = hRL;
                break;
            case ROOM:
                result = r;
                break;
            case ROOM_NUMBER:
                result = rN;
                break;
            case ROOM_AVAILABLE:
                result = rAv;
                break;
            case ROOM_USER:
                result = rUser;
                break;
            case USERS_DB:
                result = uDB;
                break;
            case USER:
                result = u;
                break;
            case USER_NAME:
                result = uName;
                break;
            case USER_LOGIN:
                result = uLogin;
                break;
            case USER_PASSWORD:
                result = uPass;
                break;
        }
        return result;
    }

    HMSprop() {

        try {
            preparePropertyAccess();

            HMSfilename = property.getProperty("filename.HMS.DB");

            msgFileNotFound = property.getProperty("msg.file.not.found");
            msgFileReadError = property.getProperty("msg.file.unable.to.read");
            total = property.getProperty("count");

            hDB = property.getProperty("hotels.DB");
            h = property.getProperty("hotel");
            hName = property.getProperty("hotel.name");
            hCity = property.getProperty("hotel.city");
            hRL = property.getProperty("hotel.rooms");

            r = property.getProperty("room");
            rN = property.getProperty("room.number");
            rAv = property.getProperty("room.available");
            rUser = property.getProperty("room.user");

            uDB = property.getProperty("users.DB");
            u = property.getProperty("user");
            uName = property.getProperty("user.name");
            uLogin = property.getProperty("user.login");
            uPass = property.getProperty("user.pass");
        } catch (IOException e) {
            System.err.println("!!! IMPOSSIBLE TO LOAD PROPERTIES !!!\n");
            e.printStackTrace();
        }
    }

    private void preparePropertyAccess() throws IOException {

        // trying to get properties for this app
        try (FileInputStream pf = new FileInputStream("src/config.properties")) {

            property.load(pf);

        } catch (FileNotFoundException e) {
            System.err.println("ERROR! Property-file was not found.");
            throw e;
        } catch (IOException e) {
            System.err.println("ERROR! Unable to reed the properties from the file.");
            throw e;
        }

    }
}