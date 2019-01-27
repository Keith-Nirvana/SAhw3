package nju.library.factory;

import nju.library.entity.*;
import nju.library.util.UserType;

public class UserFactory {
    public static User createUser(String userId, String password, String userName, String department,
                                  String email, String type, String permission) {
        System.out.println(type);
        if (type.equals(UserType.ADMINISTRATOR))
            return new Administrator(userId, password, userName, department, email, type, permission);
        else if (type.equals(UserType.GRADUATE))
            return new Graduate(userId, password, userName, department, email, type, permission);
        else if (type.equals(UserType.UNDERGRADUATE))
            return new UnderGraduate(userId, password, userName, department, email, type, permission);
        else if (type.equals(UserType.TEACHER))
            return new Teacher(userId, password, userName, department, email, type, permission);
        else
            return new User(userId, password, userName, department, email, type, permission);
    }
}
