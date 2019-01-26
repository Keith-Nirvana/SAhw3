package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.TeacherBorrowStrategy;

public class Teacher extends User {

    private BorrowStrategy borrowStrategy = new TeacherBorrowStrategy();

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
