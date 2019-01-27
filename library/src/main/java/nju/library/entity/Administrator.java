package nju.library.entity;

public class Administrator extends User implements Observer {
    public Administrator(String userId, String password, String userName, String department, String email, String type,
                         String permission) {
        super(userId, password, userName, department, email, type, permission);
    }

    public boolean grantPermissions() {
        // TODO
        return false;
    }

    @Override
    public boolean receiveUpdateInfo() {
        // TODO
        return false;
    }
}
