package nju.library.daoImpl;

import nju.library.dao.UserDao;
import nju.library.entity.User;
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
    }

    @Test
    public void createUser() {
    }

    @Test
    public void grantPermission() {
    }
}