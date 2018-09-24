package dao;

import model.User;
import model.UserMovie;

import java.lang.reflect.Array;
import java.util.*;

public class UserDao {
    private Map<String, User> usersDB = new HashMap<>();

    {
        List<UserMovie> sonList = Arrays.asList(
                new UserMovie(58776, 0),
                new UserMovie(270691, 1),
                new UserMovie(10304, 1),
                new UserMovie(57286, 1)
        );
        List<UserMovie> yafeiList = Arrays.asList(
                new UserMovie(180358, 0),
                new UserMovie(14843, 1),
                new UserMovie(37607, 1)
        );

        usersDB.put("son@mum.edu", new User(1, "son@mum.edu", "123456", "", "", "", sonList));
        usersDB.put("yafei@mum.edu", new User(2, "yafei@mum.edu", "123456", "", "", "", yafeiList));
    }

    public boolean checkExistUser(String email, String password) {
        if (usersDB.containsKey(email) && usersDB.get(email).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public User getUserByEmail(String email) {
        return usersDB.get(email);
    }

    public User getUser(String email) {
        return usersDB.get(email);
    }

    public boolean checkExistEmail(String email) {
        if (usersDB.containsKey(email)) {
            return true;
        }
        return false;
    }

    public int getMaxID() {
        return usersDB.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getId() > entry2.getValue().getId() ? 1 : -1).get().getValue().getId();
    }

    public boolean addUser(String email, String pw, String fullname, String telephone, String address) {
        if (checkExistEmail(email)) {
            return false;
        } else {
            int newId = getMaxID() + 1;
            usersDB.put(email, new User(newId, email, pw, fullname, telephone, address));
            return true;
        }
    }

    public List<User> getUsersDB() {
        return new ArrayList<User>(usersDB.values());
    }
}
