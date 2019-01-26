package nju.library.service;

public interface BorrowStrategy {
    public boolean borrowBook(String userId, String bookId);
    public boolean returnBook(String userId, String bookId);

}
