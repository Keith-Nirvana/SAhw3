package nju.library.serviceImpl;

import nju.library.dao.UserDao;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.UserService;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public boolean isValidUser(String userId, String password) {
        User user = DaoFactory.getUserDao().getUserById(userId);
        if (user.getPassword().equals(password))
            return true;
        else
            return false;
    }

    @Override
    public List<User> getAllUsers() {
        return DaoFactory.getUserDao().getAllUser();
    }
}
