package nju.library.factory;

import nju.library.dao.BookDao;
import nju.library.dao.RecordDao;
import nju.library.dao.UserDao;
import nju.library.daoImpl.BookDaoImpl;
import nju.library.daoImpl.RecordDaoImpl;
import nju.library.daoImpl.UserDaoImpl;

public class DaoFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

    public static RecordDao getRecordDao(){
        return new RecordDaoImpl();
    }

    public static BookDao getBookDao(){
        return new BookDaoImpl();
    }
}
