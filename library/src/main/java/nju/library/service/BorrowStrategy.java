package nju.library.service;

public interface BorrowStrategy {
    public boolean borrow(String userId, String bookId);
}
