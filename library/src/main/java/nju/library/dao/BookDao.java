package nju.library.dao;

import nju.library.entity.Book;

import java.util.List;

public interface BookDao {
    public boolean modifyBookState(String bookId, boolean isborrow);

    public boolean modifyBookInfo(String bookId, String bookName, int category);

    public List<Book> getAllBooks();
}
