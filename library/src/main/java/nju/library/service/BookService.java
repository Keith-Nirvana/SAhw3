package nju.library.service;

import nju.library.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks(String userId);

    public List<Book> getBorrowedBooks(String userId);

    public boolean modifyBookInfo(String bookId, String bookName, int category);

    public boolean borrowBook(String bookId, String userId);

    public boolean returnBook(String bookId, String userId);
}
