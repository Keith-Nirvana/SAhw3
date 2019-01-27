package nju.library.service;

import nju.library.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    public boolean isValidUser(String userId, String password);

    public List<User> getAllUsers();

    public User getUserById(String userId);

    public boolean modifyUser(String userId, String userName, String department, String email, String type);

    public boolean createUser(String userId, String password, String userName, String department, String email, String type);

    public boolean grantPermission(String userId, String permission);
}
