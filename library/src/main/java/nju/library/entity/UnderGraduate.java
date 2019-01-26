package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.UndergraduateBorrowStrategy;

public class UnderGraduate extends User {
    private BorrowStrategy borrowStrategy;

    public UnderGraduate(String userId, String password, String userName, String department, String email, String type, String permission) {
        super(userId, password, userName, department, email, type, permission);
        borrowStrategy = new UndergraduateBorrowStrategy();
    }

    public UnderGraduate(User user) {
        super(user.getUserId(), user.getUserName(), user.getDepartment(), user.getEmail(), user.getType(), user.getPermission());
        borrowStrategy = new UndergraduateBorrowStrategy();
    }

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;
    }

    public boolean borrowBook(String bookId) {
        return borrowStrategy.borrowBook(super.getUserId(), bookId);
    }

    public boolean retutnBook(String bookId) {
        return borrowStrategy.returnBook(super.getUserId(), bookId);
    }
}
