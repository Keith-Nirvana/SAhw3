package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.GraduateBorrowStrategy;

public class Graduate extends User{
    private BorrowStrategy borrowStrategy;

    public Graduate(String userId, String userName, String department, String email, String type, String permission) {
        super(userId, userName, department, email, type, permission);
        borrowStrategy = new GraduateBorrowStrategy();
    }

    public Graduate(User user){
        super(user.getUserId(), user.getUserName(), user.getDepartment(), user.getEmail(), user.getType(), user.getPermission());
        borrowStrategy = new GraduateBorrowStrategy();
    }

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
