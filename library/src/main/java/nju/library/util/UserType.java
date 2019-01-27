package nju.library.util;

import java.util.HashMap;

public class UserType {
    public static String TEACHER = "TEACHER";
    public static String GRADUATE = "GRADUATE";
    public static String UNDERGRADUATE = "UNDERGRADUATE";
    public static String ADMINISTRATOR = "ADMINISTRATOR";
    public static String DEPARTMENT = "DEPARTMENT";
    public static String SCHOOL = "SCHOOL";

    private static HashMap<String, String> defaultPermission;

    static {
        defaultPermission = new HashMap<>();

        defaultPermission.put(TEACHER, "1");
        defaultPermission.put(GRADUATE, "1");
        defaultPermission.put(UNDERGRADUATE, "1");
        defaultPermission.put(ADMINISTRATOR, "234");
        defaultPermission.put(DEPARTMENT, "2");
        defaultPermission.put(SCHOOL, "2");
    }

    public static int getMaxBorrowBooks(String type){
        if(type.equals(TEACHER))
            return 16;
        if(type.equals(GRADUATE))
            return 5;
        if(type.equals(UNDERGRADUATE))
            return 8;

        return 0;
    }

    public static int getMaxBorrowDay(String type){
        if(type.equals(TEACHER))
            return 9;
        if(type.equals(GRADUATE))
            return 3;
        if(type.equals(UNDERGRADUATE))
            return 6;

        return 0;
    }

    public static String getDefaultPermission(String type){
        return defaultPermission.get(type);
    }

    public static int getPermittedBorrowedBooksType(String type){
        if(type.equals(TEACHER))
            return 3;
        if(type.equals(GRADUATE))
            return 2;
        if(type.equals(UNDERGRADUATE))
            return 1;
        return 5;
    }
}
