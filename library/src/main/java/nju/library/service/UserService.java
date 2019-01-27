package nju.library.service;

import nju.library.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserService {
    public boolean isValidUser(String userId, String password);

    public List<User> getAllUsers();
}
