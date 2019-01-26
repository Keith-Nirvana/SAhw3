package nju.library.entity;

import nju.library.service.BorrowStrategy;

public class User {
    private String userId;
    private String userName;
    // 学院
    private String department;
    private String email;
    // 用户类型: teacher undergraduate graduate
    private String type;
    // 用户权限
    private String permission;

    private BorrowStrategy borrowStrategy;

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;
    }

    public boolean borrowBook(String bookId){
        return borrowStrategy.borrow(userId, bookId);
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
