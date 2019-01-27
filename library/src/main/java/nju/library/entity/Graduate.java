package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.GraduateBorrowStrategy;

public class Graduate extends User {
    private BorrowStrategy borrowStrategy;

    public Graduate(String userId, String password, String userName, String department, String email, String type,
                    String permission) {
        super(userId, password, userName, department, email, type, permission);
        borrowStrategy = new GraduateBorrowStrategy();
    }

    public Graduate(User user) {
        super(user.getUserId(), user.getUserName(), user.getDepartment(), user.getEmail(), user.getType(), user.getPermission());
        borrowStrategy = new GraduateBorrowStrategy();
    }

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;
    }

    @Override
    public boolean borrowBook(String bookId) {
        return borrowStrategy.borrowBook(super.getUserId(), bookId);
    }

    @Override
    public boolean returnBook(String bookId) {
        return borrowStrategy.returnBook(super.getUserId(), bookId);
    }
}
