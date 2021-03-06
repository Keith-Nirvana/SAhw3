package nju.library.daoImpl;

import nju.library.dao.UserDao;
import nju.library.entity.User;
import nju.library.factory.UserFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
    }

    @Test
    public void getUserById() {
        User user = userDao.getUserById("161250031");

        System.out.println(user.toString());

    }

    @Test
    public void getAllUser() {

        List<User> list = userDao.getAllUser();
        for (User user: list){
            System.out.println(user.toString());
        }

    }

    @Test
    public void modifyUser() {
        System.out.println(userDao.modifyUser("161250031", "kiki", "商学院", "161250004@smail.nju.edu.cn", "TEACHER"));
    }

    @Test
    public void createUser() {
        System.out.println(userDao.createUser(UserFactory.createUser("161250004", "123", "keil", "法学院",
                "12@smail.com", "GRADUATE", "23")));
    }

    @Test
    public void grantPermission() {
        System.out.println(userDao.grantPermission("131928473", "23"));
    }
}