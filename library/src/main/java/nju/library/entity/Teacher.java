package nju.library.entity;

import nju.library.service.BorrowStrategy;
import nju.library.serviceImpl.borrowServiceImpl.TeacherBorrowStrategy;

public class Teacher extends User {

    private BorrowStrategy borrowStrategy = new TeacherBorrowStrategy();

    public Teacher(String userId, String password, String userName, String department, String email, String type,
                   String permission) {
        super(userId, password, userName, department, email, type, permission);
        this.borrowStrategy = new TeacherBorrowStrategy();
    }

    public Teacher(User user) {
        super(user.getUserId(), user.getUserName(), user.getDepartment(), user.getEmail(), user.getType(), user.getPermission());
        this.borrowStrategy = new TeacherBorrowStrategy();
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
