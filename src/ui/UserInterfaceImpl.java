package ui;

import controller.HotelController;
import controller.HotelControllerImpl;
import dao.UserDAOImpl;
import model.*;
import util.DataLoaderImpl;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;


public class UserInterfaceImpl {
    UserHandler uh = new UserHandler();
    HotelHandler hh = new HotelHandler();

    Hotel currentHotel = null;
    User currentUser = null;
    int currentRoom = 0;

    HotelController hotelController = new HotelControllerImpl();

    public static Scanner scanner = new Scanner(System.in);

    public UserInterfaceImpl() {
        sayHello();
    }

    private static void write(Object obj) {
        System.out.println(obj);
    }

    public void sayHello() {
        write("Hello You entered the Hotel System menu");
        write("Make your choice");
        write("0-Exit program");
        write("1-Hotel Menu");
        write("2-User Menu");

        int line = scanner.nextInt();
        switch (line) {
            case 0:
                //here is program exit
                //dataLoader.saveData();
            case 1:
                this.hotelMenu();
            case 2:
                userMenu();

        }
    }


    private void hotelMenu() {

        write("hotelMenu");
        write("0 - back to Main menu");
        write("1 - find Hotel by Name ");
        write("2 - find Hotel by City");
        write("3 - delete Hotel by ID");
        write("4 - add new Hotel");
        int line = scanner.nextInt();
        switch (line) {
            case 0:
                sayHello();
            case 1:
                hh.findHotelByName();
            case 2:
                hh.findHotelByCity();
            case 3:
                hh.deleteHotelById();
            case 4:
                hh.addNewHotel();
        }
    }

    private void userMenu() {
        write("UserMenu");
        write("0 - go to Main menu");
        write("1 - find user by login");
        write("2 - add user");
        write("3 - delete user");
        int line = scanner.nextInt();
        switch (line) {
            case 0:
                sayHello();
            case 1:
                uh.findUser();
            case 2:
                uh.userAddMenu("");
            case 3:
                uh.userDelMenu();

        }
    }

    class HotelHandler {
        void findHotelByName() {
            write("enter HotelID");
            String name = scanner.nextLine();
            Set<Hotel> hotels = hotelController.findHotelByName(name);
            write("choose your room in " + name);
            hotels.stream().forEach(i -> write(i.getId() + " " + i.toString()));
            long hotelId = scanner.nextLong();
            write("free rooms im Hotel");
            hotelController.getFreeRooms(hotelController.getHotelById(hotelId)).stream().forEach(room -> write(room));
            write("make your room choice ( 0 - to go to main menu)");
        }

        void findHotelByCity() {
            write("enter City");
            String city = scanner.nextLine();
            Set<Hotel> hotels = hotelController.findHotelByCity(City.valueOf(city.toUpperCase()));
            write("choose your hotel in " + city);
            hotels.stream().forEach(i -> write(i.getId() + " " + i.toString()));
            long hotelId = scanner.nextLong();
            hotelController.getFreeRooms(hotelController.getHotelById(hotelId)).stream().forEach(room -> write(room));
        }

        void deleteHotelById() {
            write("enter Hotel id");
            hotelController.remove(hotelController.getHotelById(scanner.nextLong()));
        }
//String name, City city, Set<Room> rooms
        void addNewHotel() {
            write("Hotel Adding Guide");
            write("Enter Hotel Name");
            String hotelName = scanner.nextLine();
            write("choose your city(1,2,3..)");
            Arrays.stream(City.values()).forEach(city -> write(city.ordinal() + " " + city.name()));
            City city = City.values()[scanner.nextInt()];
            Hotel hotel = new Hotel(hotelName,city,null);
            write("add rooms to Hotel");
        }

        void roomAddMenu(Hotel hotel){
            write("enter room numbers to add or 0 to end");
            Set<Room> rooms = null;
            while (scanner.nextInt()!=0){
                rooms.add(new Room(scanner.nextInt()));
            }
            hotelController.add(new Hotel(hotel.getName(),hotel.getCity(),rooms));
        }
    }

    class UserHandler {
        DataLoaderImpl dataLoader = new DataLoaderImpl();
        UserDAOImpl userControl = new UserDAOImpl();



        void userDelMenu() {
            write("enter user login or ");
            write("0 to exit to main menu");
            String res = scanner.nextLine();
            if (res == "0") UserInterfaceImpl.this.sayHello();
            else removeUser(res);
        }

        void findUser() {
            write("0 - go to main menu");
            write("Enter user login to find");
            String login = scanner.nextLine();
            if (login == "0") UserInterfaceImpl.this.sayHello();
            else {
                User user = userControl.getUser(login);

                write("0 - go to main menu ");
                write("1 - edit user ");
                write("2 - remove user");
                switch (scanner.nextInt()) {
                    case 0:
                        UserInterfaceImpl.this.sayHello();
                    case 1:
                        userAddMenu(login);
                    case 2:
                        removeUser(login);
                }
            }
        }

        void userAddMenu(String editadd) {
            String name;
            write("User editing menu");
            if (editadd.isEmpty()) {
                write("Enter user Name");
                name = scanner.nextLine();
            } else name = editadd;
            write("Enter user Login");
            String login = scanner.nextLine();
            write("Enter user Pass");
            String pass = scanner.nextLine();
            User user = new User(name, login, pass);
            userControl.saveUser(user);
            UserInterfaceImpl.this.userMenu();

        }

        void removeUser(String login) {
            if (userControl.deleteUser(userControl.getUser(login))) {
                write("user deleted");
                UserInterfaceImpl.this.userMenu();

            } else {
                write("user not found");
                userDelMenu();
            }
        }

    }

}
