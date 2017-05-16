package group5.hotelms.gui;

import group5.hotelms.controller.HotelController;
import group5.hotelms.controller.HotelControllerImpl;
import group5.hotelms.controller.UserController;
import group5.hotelms.controller.UserControllerImpl;
import group5.hotelms.model.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Андрей and voksus 11.05.2017
 */
public class form {

    UserController userController = new UserControllerImpl();
    HotelController hotelController = new HotelControllerImpl();

    private User user;
    private Hotel hotel;
    private Set<Room> rooms;
    private Room room;

    private JPanel mainPanel;
    private JTextField userNameField;
    private JTextField userLoginField;
    private JPasswordField userPasswordField;
    private JButton addUserButton;
    private JButton findButton;
    private JTextField userLoginToFindField;
    private JTextField userLoginToEditField;
    private JTextField userNameToEditField;
    private JPasswordField userPassToEditField;
    private JButton removeButton;
    private JButton editButton;
    private JComboBox cityBox;
    private JTextField hotelRoomsSequenceField;
    private JButton addHotelButton;
    private JTextField hotelNameField;
    private JTextField hotelIdToSearchField;
    private JButton findHotelButton;
    private JComboBox roomSetComboBox;
    private JButton unbookRoomButton;
    private JTextField hotelSetNameField;
    private JButton hotelSetNameButton;
    private JButton removeRoomButton;
    private JButton showAllHotelsButton;
    private JButton showAllUsersButton;
    private JTextPane logArea;
    private JTextField hotelNameToSearch;
    private JButton findByNameButton;
    private JComboBox cityToSearchBox;
    private JButton findByCityButton;
    private JTextField userLoginToBook;
    private JButton bookUserButton;
    private JButton removeHotelButton;
    private JButton addRoomsButton;
    private JTextField addRoomsField;

    /**
     * Here the hotel menu selection happens
     * Add Hotel opens HotelAddForm
     * Edit/Delete Hotel opens HotelHandler form
     * Hotel Menu is for bookings
     */
    public form() {

        Arrays.stream(City.values()).forEach(c -> cityBox.addItem(c));
        Arrays.stream(City.values()).forEach(c -> cityToSearchBox.addItem(c));

        logArea.setText(String.valueOf(userController.getAllUsers().size()) + " user(s) loaded.\n"
                + hotelController.getAllHotels().size() + " hotel(s) loaded.");
        showAllUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllUsers();
            }
        });

        userNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkUserCreatorFields();
            }
        });

        userLoginField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkUserCreatorFields();
            }
        });

        userPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkUserCreatorFields();
            }
        });

        hotelNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkHotelCreatorFields();
            }
        });

        hotelRoomsSequenceField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkHotelCreatorFields();
            }
        });

        userLoginToFindField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (userLoginToFindField.getText().equals("")) {
                    findButton.setEnabled(false);
                } else {
                    findButton.setEnabled(true);
                }
            }
        });

        userNameToEditField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkUserEditFields();
            }
        });

        userPassToEditField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                checkUserEditFields();
            }
        });

        findButton.addActionListener(new ActionListener() {
            /**
             * Find button pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = userLoginToFindField.getText();
                user = userController.getUserByLogin(login);
                userJElementRefresh();
            }
        });

        editButton.addActionListener(new ActionListener() {
            /**
             *Edit button pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userNameToEditField.getText().trim().isEmpty()
                        || String.valueOf(userPassToEditField.getPassword()).trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Empty name or password are not allowed");
                } else {
                    user = new User(userNameToEditField.getText().trim(),
                            userLoginToEditField.getText().trim(),
                            String.valueOf(userPassToEditField.getPassword()).trim());
                    logArea.setText(user.toString());
                    userController.edit(user);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            /**
             * Invoked when button to remove user was pressed
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                if (JOptionPane.showConfirmDialog(null,
                        "Warning! Are you sure to remove user:  " + user.getName() + "  ?",
                        "Confirm to remove the user.",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    if (!userController.remove(user)) {
                        logArea.setText("User " + user.getName() + " reserves some room(s) and can not be removed.\n"
                                + "Please cancel all his reserved rooms.");
                        return;
                    }
                    user = null;
                    userJElementRefresh();
                } else {
                    return;
                }
                showAllUsers();
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            /**
             * Button User Add clicked
             * actually we are adding new user right now
             */
            public void actionPerformed(ActionEvent e) {
                if (!userController.register(new User(userNameField.getText(),
                        userLoginField.getText(),
                        String.valueOf(userPasswordField.getPassword())))) {
                    logArea.setText("User can not be created.");
                    return;
                }
                showAllUsers();
            }
        });

        addHotelButton.addActionListener(new ActionListener() {
            /**
             * 'Create hotel' button pressed action
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Room> rooms = new HashSet<>();
                for (String str : hotelRoomsSequenceField.getText().split(" ")) {
                    rooms.add(new Room(Integer.valueOf(str)));
                }
                hotelController.add(new Hotel(hotelNameField.getText(),
                        City.valueOf(cityBox.getSelectedItem().toString()),
                        rooms));
                showAllHotels();
            }
        });

        showAllHotelsButton.addActionListener(new ActionListener() {
            /**
             * 'Show all hotels' button pressed action
             *
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllHotels();
            }
        });

        findHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = 0;
                try {
                    id = Integer.valueOf(hotelIdToSearchField.getText());
                } catch (NumberFormatException nfe) {
                    logArea.setText("Please type correct ID.");
                    return;
                }

                hotelIdToSearchField.setText(String.valueOf(id));
                if (hotel != null && hotel.getId() > id && roomSetComboBox.getItemCount() > 0) {
                    roomSetComboBox.setSelectedIndex(hotelController.getHotelById(id).getRooms().size() - 1);
                }
                hotel = hotelController.getHotelById(id);
                boolean hotelFound = hotel != null;

                hotelSetNameField.setEnabled(hotelFound);
                hotelSetNameButton.setEnabled(hotelFound);
                removeHotelButton.setEnabled(hotelFound);
                userLoginToBook.setEnabled(hotelFound);
                addRoomsField.setEnabled(hotelFound);

                if (!hotelFound) {
                    logArea.setText("No hotel found with this ID.");
                    userLoginToBook.setText("");
                    return;
                }

                hotelSetNameField.setText(hotel.getName());

                checkRooms();
                logArea.setText(hotel.toString());
            }
        });

        hotelIdToSearchField.addKeyListener(new KeyAdapter() {
            /**
             * This listener make button 'Find hotel' enabled if typed some chars
             * or disabled when it's empty
             *
             */
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (hotelIdToSearchField.getText().isEmpty()) {
                    findHotelButton.setEnabled(false);
                } else {
                    findHotelButton.setEnabled(true);
                }
            }
        });

        hotelSetNameButton.addActionListener(new ActionListener() {
            /**
             * 'Set name' button pressed action
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                hotel.setName(hotelSetNameField.getText());
                logArea.setText(hotel.toString());
            }
        });

        hotelSetNameField.addKeyListener(new KeyAdapter() {
            /**
             * Listener looking for some texts to be entered and make
             * button 'Set name' enabled or disabled
             */
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (hotelSetNameField.getText().isEmpty()) {
                    hotelSetNameButton.setEnabled(false);
                } else {
                    hotelSetNameButton.setEnabled(true);
                }
            }
        });

        hotelNameToSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (hotelNameToSearch.getText().isEmpty()) {
                    findByNameButton.setEnabled(false);
                } else {
                    findByNameButton.setEnabled(true);
                }
            }
        });

        findByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Hotel> h = hotelController.findHotelByName(hotelNameToSearch.getText());
                if (h == null) {
                    logArea.setText("No hotels found.");
                    return;
                }
                String text = "";
                for (Hotel hotel : h) {
                    text += hotel + "\n";
                }
                logArea.setText(text);
            }
        });

        findByCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Hotel> h = hotelController.findHotelByCity(City.valueOf(cityToSearchBox.getSelectedItem().toString()));
                if (h.size() == 0) {
                    logArea.setText("No hotels found.");
                    return;
                }
                String text = "";
                for (Hotel hotel : h) {
                    text += hotel + "\n";
                }
                logArea.setText(text);
            }
        });

        removeHotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null,
                        "Warning! Are you sure to remove hotel:  " + hotel.getName() + "  ?",
                        "Confirm to remove the hotel.",
                        JOptionPane.YES_NO_OPTION) == 0) {
                    hotelController.remove(hotel);

                    findHotelButton.setEnabled(false);
                    hotelIdToSearchField.setText("");
                    hotelSetNameField.setEnabled(false);
                    hotelSetNameField.setText("");
                    hotelSetNameButton.setEnabled(false);
                    roomSetComboBox.removeAllItems();
                    roomSetComboBox.setEnabled(false);
                    unbookRoomButton.setEnabled(false);
                    removeRoomButton.setEnabled(false);
                    removeHotelButton.setEnabled(false);
                    userLoginToBook.setText("");
                    userLoginToBook.setEnabled(false);
                    bookUserButton.setEnabled(false);
                    addRoomsField.setEnabled(false);

                } else {
                    return;
                }
                showAllHotels();
            }
        });

        userLoginToBook.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                bookUserButton.setEnabled(!userLoginToBook.getText().isEmpty());
            }
        });

        roomSetComboBox.addActionListener(new ActionListener() {
            /**
             * Listener looks the events with rooms checkbox if changed selection f.e.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rooms.size() > 0 && roomSetComboBox.getSelectedIndex() >= 0) {
                    room = rooms.stream()
                            .skip(roomSetComboBox.getSelectedIndex())
                            .findFirst().get();
                }
                unbookRoomButton.setEnabled(!room.isAvailable());
                removeRoomButton.setEnabled(room.isAvailable());
            }
        });

        unbookRoomButton.addActionListener(new ActionListener() {
            /**
             * 'Unbook user' button pressed action
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                rooms = hotel.getRooms();
                if (!hotelController.bookCancel(hotel, room)) {
                    logArea.setText("The room #" + room.getNumber() + " can not to unbook!");
                    return;
                }
                room.setUser(null);
                checkRooms();
            }
        });

        bookUserButton.addActionListener(new ActionListener() {
            /**
             * 'Book user' button pressed action
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = userController.getUserByLogin(userLoginToBook.getText());
                if (u == null) {
                    logArea.setText("User '" + userLoginToBook.getText() + "' not found.\n" +
                            "Please type correct login.");
                    return;
                }
                if (hotelController.bookRoom(hotel, room.getNumber(), u)) {
                    logArea.setText("User '" + u.getName() + "' booked in hotel [ID " + hotel.getId() + "] '"
                            + hotel.getName() + "' in " + hotel.getCity().toString() + " city.");
                    checkRooms();
                } else {
                    logArea.setText("User '" + u.getName() + "' can not be booked in room #" + room.getNumber() + "\n"
                            + "Try to book in another room or hotel.");
                }
            }
        });

        removeRoomButton.addActionListener(new ActionListener() {
            /**
             * 'Remove room' button pressed action
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomNumber = String.valueOf(room.getNumber());

                if (hotelController.removeRoom(hotel, room)) {
                    logArea.setText("Room#" + roomNumber + " was removed.");
                    if (rooms.size() <= roomSetComboBox.getSelectedIndex() + 1) {
                        roomSetComboBox.setSelectedIndex(roomSetComboBox.getSelectedIndex() - 1);
                    }
                    checkRooms();
                } else {
                    logArea.setText("Room#" + roomNumber + " can not be removed.\n"
                            + "Please unbook room before remove.");
                }
            }
        });

        addRoomsField.addKeyListener(new KeyAdapter() {
            /**
             *
             * @param e
             */
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                addRoomsButton.setEnabled(!addRoomsField.getText().isEmpty());
            }
        });

        addRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Room> newValue = new HashSet<>(rooms);
                for (String str : addRoomsField.getText().split(" ")) {
                    int num = Integer.valueOf(str);
//                    rooms = new HashSet<>(rooms);
                    if (!newValue.stream().map(Room::getNumber).filter(n -> n == num).findFirst().isPresent()) {
                        newValue.add(new Room(num));
                    }
                }
                if (newValue.size() <= rooms.size()) {
                    logArea.setText("No rooms was added.");
                    return;
                }
                hotel.setRooms(rooms = newValue);
                logArea.setText(hotel.toString());
                checkRooms();
            }
        });

    }

    private void checkRooms() {
        rooms = hotel.getRooms();
        int currentlySelected = 0;
        if (roomSetComboBox.isEnabled()) {
            currentlySelected = roomSetComboBox.getSelectedIndex();
        }
        roomSetComboBox.removeAllItems();
        if (rooms.size() != 0) {
            roomSetComboBox.setEnabled(true);
            rooms.stream().forEach(r -> roomSetComboBox.addItem(
                    r.getNumber() + " "
                            + (r.isAvailable() ? "free" : "booked")));
            roomSetComboBox.setSelectedIndex(currentlySelected);
            room = rooms.stream().skip(currentlySelected).findFirst().get();
            boolean roomIsEmpty = room.isAvailable();
            unbookRoomButton.setEnabled(!roomIsEmpty);
            removeRoomButton.setEnabled(roomIsEmpty);
            userLoginToBook.setText("");
            bookUserButton.setEnabled(!roomIsEmpty);
        } else {
            roomSetComboBox.setEnabled(false);
            roomSetComboBox.addItem("no rooms");
            unbookRoomButton.setEnabled(false);
            removeRoomButton.setEnabled(false);
        }
    }

    private void userJElementRefresh() {
        boolean userFound = user != null;
        userLoginToEditField.setEnabled(userFound);
        userNameToEditField.setEnabled(userFound);
        userPassToEditField.setEnabled(userFound);
        editButton.setEnabled(userFound);
        removeButton.setEnabled(userFound);
        if (!userFound) {
            logArea.setText("User " + userLoginToFindField.getText() + " not found.");
            userLoginToEditField.setText("");
            userNameToEditField.setText("");
            userPassToEditField.setText("");
        } else {
            userLoginToEditField.setText(user.getLogin());
            userNameToEditField.setText(user.getName());
            userPassToEditField.setText(user.getPass());
        }
    }

    private void showAllUsers() {
        String text = "";
        if (userController.getAllUsers().size() == 0) {
            logArea.setText("There is no users.");
            return;
        }
        for (User user : Data.getUsers()) {
            text += user + "\n";
        }
        logArea.setText(text);
    }

    private void showAllHotels() {
        String text = "";
        if (hotelController.getAllHotels().size() == 0) {
            logArea.setText("There is no hotels.");
            return;
        }
        for (Hotel hotel : hotelController.getAllHotels()) {
            text += hotel + "\n";
        }
        logArea.setText(text);
    }

    private void checkUserEditFields() {
        if (userNameToEditField.getText().isEmpty() ||
                String.valueOf(userPassToEditField.getPassword()).equals("")
                ) {
            editButton.setEnabled(false);
        } else {
            editButton.setEnabled(true);
        }
    }

    private void checkHotelCreatorFields() {
        if (hotelNameField.getText().equals("")
                || hotelRoomsSequenceField.getText().equals("")) {
            addHotelButton.setEnabled(false);
        } else {
            addHotelButton.setEnabled(true);
        }
    }

    private void checkUserCreatorFields() {
        if (userNameField.getText().equals("")
                || userLoginField.getText().equals("")
                || String.valueOf(userPasswordField.getPassword()).equals("")
                ) {
            addUserButton.setEnabled(false);
        } else {
            addUserButton.setEnabled(true);
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}