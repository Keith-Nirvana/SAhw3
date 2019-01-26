package nju.library.util;

public class UserType {
    public static String TEACHER = "TEACHER";
    public static String GRADUATE = "GRADUATE";
    public static String UNDERGRADUATE = "UNDERGRADUATE";
    public static String ADMINISTRATOR = "ADMINISTRATOR";

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
            return 180;
        if(type.equals(GRADUATE))
            return 30;
        if(type.equals(UNDERGRADUATE))
            return 90;

        return 0;
    }
}
