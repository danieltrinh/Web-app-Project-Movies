package dao;

import model.User;
import model.UserMovie;

import java.lang.reflect.Array;
import java.util.*;

public class UserDao {
    private Map<String, User> usersDB = new HashMap<>();

    {
        List<Integer> sonList = Arrays.asList(
                348350,270691,10304,57286
        );

        List<Integer> yafeiList = Arrays.asList(
                180358,14843,37607
        );

        usersDB.put("son@mum.edu", new User(1, "son@mum.edu", "123456", "Son Trinh", "123213123", "MUM", sonList));
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
    public User getUserById(Integer id) {
        return usersDB.entrySet().stream().filter(x -> x.getValue().getId() == id).findFirst().get().getValue();
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
