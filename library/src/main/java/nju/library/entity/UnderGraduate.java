package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.UndergraduateBorrowStrategy;

public class UnderGraduate extends User {
    private BorrowStrategy borrowStrategy = new UndergraduateBorrowStrategy();

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;
    }

    public boolean borrowBook(String bookId){
        return borrowStrategy.borrowBook(super.getUserId(), bookId);
    }

    public boolean retutnBook(String bookId){
        return borrowStrategy.returnBook(super.getUserId(), bookId);
    }
}
