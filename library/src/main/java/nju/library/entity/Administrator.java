package nju.library.entity;

public class Administrator extends User implements Observer {
    public Administrator(String userId, String userName, String department, String email, String type, String permission) {
        super(userId, userName, department, email, type, permission);
    }

    public boolean grantPermissions(){
        // TODO
        return false;
    }

    @Override
    public boolean receiveUpdateInfo() {
        // TODO
        return false;
    }
}
