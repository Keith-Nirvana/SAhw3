package nju.library.dao;

import nju.library.entity.User;

import java.util.List;

public interface UserDao {
    public User getUserById(String userId);

    public List<User> getAllUser();

    public boolean modifyUser(String userId, String userName, String department, String email, String type);

    public boolean createUser(User user);

    public boolean grantPermission(String userId, String permission);
}
