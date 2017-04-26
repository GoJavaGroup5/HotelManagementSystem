package DAO;
import model.User;

public interface UserDao {
    boolean saveUser(User user);
    boolean deleteUser(User user);
    User getUser(String login);
}
