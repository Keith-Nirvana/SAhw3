package nju.library.entity;

import nju.library.service.BorrowStrategy;

public class User {
    private String userId;
    private BorrowStrategy borrowStrategy;

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;
    }

    public boolean borrowBook(String bookId){
        return borrowStrategy.borrow(userId, bookId);
    }
}
