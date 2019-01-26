package nju.library.entity;

public class Administrator extends User implements Observer {
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
