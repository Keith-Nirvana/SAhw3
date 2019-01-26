package nju.library.factory;

import nju.library.entity.*;
import nju.library.util.UserType;

public class UserFactory {
    public static User createUser(String userId, String userName, String department,
                                  String email, String type, String permission){
        if (type.equals(UserType.ADMINISTRATOR))
            return new Administrator(userId, userName, department, email, type,permission);
        else if (type.equals(UserType.GRADUATE))
            return new Graduate(userId, userName, department, email, type,permission);
        else if (type.equals(UserType.UNDERGRADUATE))
            return new UnderGraduate(userId, userName, department, email, type,permission);
        else if (type.equals(UserType.TEACHER))
            return new Teacher(userId, userName, department, email, type,permission);
        else
            return  null;
    }
}
