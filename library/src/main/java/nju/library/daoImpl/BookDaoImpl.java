package nju.library.daoImpl;

import nju.library.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean modifyBookState(String bookId, boolean isborrow) {
        return false;
    }
}
