package nju.library.dao;

public interface BookDao {
    public boolean modifyBookState(String bookId, boolean isborrow);
}
