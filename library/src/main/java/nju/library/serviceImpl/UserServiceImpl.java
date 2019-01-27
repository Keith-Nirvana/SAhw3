package nju.library.serviceImpl;

import nju.library.dao.UserDao;
import nju.library.entity.Administrator;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.UserInfoUpdateNotify;
import nju.library.service.UserService;
import nju.library.serviceImpl.userInfoUpdateNotifyServiceImpl.SubjectAdmin;
import nju.library.util.UserType;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserInfoUpdateNotify updateNotify;

    public UserServiceImpl(){
        updateNotify = new SubjectAdmin();
        List<User> users = getAllUsers();

        for (User user: users){
            if (user.getType().equals(UserType.ADMINISTRATOR))
                updateNotify.add((Administrator) user);
        }

    }

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

    @Override
    public User getUserById(String userId) {
        return DaoFactory.getUserDao().getUserById(userId);
    }

    @Override
    public boolean modifyUser(String userId, String userName, String department, String email, String type) {
        updateNotify.notifyObservers(userId + "[" + userName + "]" + " has change his information on " + new Date());
        return DaoFactory.getUserDao().modifyUser(userId, userName, department, email, type);
    }

    @Override
    public boolean createUser(String userId, String password, String userName, String department, String email, String type) {
        String permission = UserType.getDefaultPermission(type);
        User user = new User(userId, password, userName, department, email, type, permission);
        return DaoFactory.getUserDao().createUser(user);
    }

    @Override
    public boolean grantPermission(String userId, String permission) {
        return DaoFactory.getUserDao().grantPermission(userId, permission);
    }
}
