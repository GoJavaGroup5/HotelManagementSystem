package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Hotel;
import model.User;

import com.google.gson.Gson;

import java.util.Map;
import java.util.Set;

/**
 * The {@code JsonTool} class convert HMS data to/from Json-string.
 *
 * @author voksus on 04.05.2017.
 */
public class JsonTool {

    public JsonTool() {
//        preparePropertyAccess();
    }

//    private Properties property = new Properties(); // to get properties

//    private String hDB, h, hName, hCity, hRL;       // markers for Hotel's fields ID/name/city
//    private String r, rN, rAv, rUser;               // markers for Room's fields number/available/user
//    private String uDB, u, uName, uLogin, uPass;         // markers for User's fields name/login/password

    public String generateJSON(Set<User> users, Set<Hotel> hotels) {

        // json will include Set<User> and Set<Hotel>

        Gson gson = new Gson();
//        hotels.stream().forEach(hotel -> {
//            str.append(hotel.getName());
//            str.append(hotel.getCity());
//            str.append(hotel.getRooms().stream().forEach(room -> new StringBuilder().append(room.getNumber())));
//        });

        // Json string with object description for Set<Hotel> (it's fields and Set<Room> inside with it's fields)
//        str = gson.toJson(hotels);
//        str += "\n";

        // ...and object with Set<User> (with it's fields)
//        str += gson.toJson(users);
        JsonObject hotelMS_JO = new JsonObject();

        JsonObject usersDB_JO = new JsonObject();
        JsonObject hotelsDB_JO = new JsonObject();

        users.stream().forEach(user -> {

            JsonObject user_JO = new JsonObject();

            user_JO.addProperty(HMSprop.USER_NAME.toString(), user.getName());
            user_JO.addProperty(HMSprop.USER_LOGIN.toString(), user.getLogin());
            user_JO.addProperty(HMSprop.USER_PASSWORD.toString(), user.getPass());
            usersDB_JO.add(HMSprop.USER.toString(), user_JO);

        });

        hotels.stream().forEach(hotel -> {

            JsonObject hotel_JO = new JsonObject();

            hotel_JO.addProperty(HMSprop.HOTEL_NAME.toString(), hotel.getName());
            hotel_JO.addProperty(HMSprop.HOTEL_CITY.toString(), String.valueOf(hotel.getCity()));

            hotel.getRooms().stream().forEach(room -> {

                JsonObject room_JO = new JsonObject();

                room_JO.addProperty(HMSprop.ROOM_NUMBER.toString(), room.getNumber());
                room_JO.addProperty(HMSprop.ROOM_USER.toString(), room.getUser().getLogin());
                room_JO.addProperty(HMSprop.ROOM_AVAILABLE.toString(), room.isAvailable());

                hotel_JO.add(HMSprop.HOTEL_ROOMS.toString(), room_JO);

            });

        });

        hotelMS_JO.add(HMSprop.USERS_DB.toString(), usersDB_JO);
        hotelMS_JO.add(HMSprop.HOTELS_DB.toString(), hotelsDB_JO);

        return gson.toJson(hotelMS_JO);
    }

    public Map<Set<Hotel>, Set<User>> parseJSON(String str) {

        String hotels = str.substring(0, str.indexOf("\n") - 1);
        String users = str.substring(str.indexOf("\n"));

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(hotels);
        JsonObject rootObject = jsonElement.getAsJsonObject();

        Set<Hotel> hotelsSet;
        Set<User> usersSet;

        return null; //new HashMap<hotelsSet, usersSet>;
    }

    /**
     * The {@code preparePropertyAccess} method preparing fields to parse JSON-data
     * with correct signature using data from config.properties file.
     */

    private void preparePropertyAccess() {

//        hDB = property.getProperty("hotels.DB");
//        h = property.getProperty("hotel");
//        hName = property.getProperty("hotel.name");
//        hCity = property.getProperty("hotel.city");
//        hRL = property.getProperty("hotel.rooms");

//        r = property.getProperty("room");
//        rN = property.getProperty("room.number");
//        rAv = property.getProperty("room.available");
//        rUser = property.getProperty("room.user");

//        uDB = property.getProperty("users.DB");
//        u = property.getProperty("user");
//        uName = property.getProperty("user.name");
//        uLogin = property.getProperty("user.login");
//        uPass = property.getProperty("user.pass");

    }

}