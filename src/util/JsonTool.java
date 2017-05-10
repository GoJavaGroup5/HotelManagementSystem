package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import model.Hotel;
import model.User;

import java.util.Set;

/**
 * The {@code JsonTool} class convert HMS data to/from Json-string.
 *
 * @author voksus on 04.05.2017.
 */
public class JsonTool {

    public static String generateJSON(Set<User> users, Set<Hotel> hotels) {

        // json will include Set<User> and Set<Hotel>

        Gson gson = new Gson();

        JsonObject hotelMS_JO = new JsonObject();

        JsonObject usersDB_JO = new JsonObject();
        usersDB_JO.addProperty(HMSprop.USER.toString() + HMSprop.TOTAL.toString(), users.size());
        JsonObject hotelsDB_JO = new JsonObject();
        hotelsDB_JO.addProperty(HMSprop.HOTEL.toString() + HMSprop.TOTAL.toString(), hotels.size());

        users.stream().forEach(user -> {

            JsonObject user_JO = new JsonObject();

            user_JO.addProperty(HMSprop.USER_NAME.toString(), user.getName());
            user_JO.addProperty(HMSprop.USER_LOGIN.toString(), user.getLogin());
            user_JO.addProperty(HMSprop.USER_PASSWORD.toString(), user.getPass());
            usersDB_JO.add(HMSprop.USER.toString() + "@" + user.hashCode(), user_JO);

        });

        hotels.stream().forEach(hotel -> {

            JsonObject hotel_JO = new JsonObject();

            hotel_JO.addProperty(HMSprop.HOTEL_NAME.toString(), hotel.getName());
            hotel_JO.addProperty(HMSprop.HOTEL_CITY.toString(), String.valueOf(hotel.getCity()));

            hotel.getRooms().stream().forEach(room -> {

                JsonObject room_JO = new JsonObject();

                room_JO.addProperty(HMSprop.ROOM_NUMBER.toString() + room.getNumber()
                        + HMSprop.ROOM_AVAILABLE.toString(), room.isAvailable());
                room_JO.addProperty(HMSprop.ROOM_USER.toString(), (room.getUser() != null ? room.getUser().getLogin() : null));

                hotel_JO.add(HMSprop.HOTEL_ROOMS.toString() + hotel.getRooms().hashCode(), room_JO);

            });
            hotelsDB_JO.add(HMSprop.HOTEL.toString()+ "@" + hotel.hashCode(), hotel_JO);

        });

        hotelMS_JO.add(HMSprop.USERS_DB.toString(), usersDB_JO);
        hotelMS_JO.add(HMSprop.HOTELS_DB.toString(), hotelsDB_JO);

        return gson.toJson(hotelMS_JO);
    }

    public static void parseJSON(String jsonString) {

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(jsonString);
        JsonObject hotelMS_JO = jsonElement.getAsJsonObject();

        Gson gson = new Gson();

        Set<Hotel> hotelsSet;
        Set<User> usersSet;

        usersSet = gson.fromJson(hotelMS_JO.get(HMSprop.USERS_DB.toString()), new TypeToken<Set<User>>() {
        }.getType());
        hotelsSet = gson.fromJson(hotelMS_JO.get(HMSprop.HOTELS_DB.toString()), new TypeToken<Set<Hotel>>() {
        }.getType());
        //hotelMS_JO.get(HMSprop.HOTELS_DB.toString()).getAsJsonObject().entrySet().stream().forEach();
    }

}