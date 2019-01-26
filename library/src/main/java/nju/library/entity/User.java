package nju.library.entity;


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

    public User(String userId, String userName, String department, String email, String type, String permission) {
        this.userId = userId;
        this.userName = userName;
        this.department = department;
        this.email = email;
        this.type = type;
        this.permission = permission;
    }

    public User() {
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }
}
