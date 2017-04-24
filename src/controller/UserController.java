package controller;

import model.User;

public interface UserController {
    boolean register(User user);
    boolean remove(User user);
    boolean edit(User user);
}
