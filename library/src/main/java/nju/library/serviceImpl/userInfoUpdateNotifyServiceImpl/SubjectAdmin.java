package nju.library.serviceImpl.userInfoUpdateNotifyServiceImpl;

import nju.library.entity.Administrator;
import nju.library.service.UserInfoUpdateNotify;

import java.util.ArrayList;
import java.util.List;

public class SubjectAdmin implements UserInfoUpdateNotify{
    private List<Administrator> registerAdmin;

    public SubjectAdmin() {
        registerAdmin = new ArrayList<>();
    }

    @Override
    public void add(Administrator admin) {
        registerAdmin.add(admin);
    }

    @Override
    public void del(Administrator admin) {
        registerAdmin.remove(admin);
    }

    @Override
    public void notifyObservers() {
        for (Administrator admin: registerAdmin){
            admin.receiveUpdateInfo();
        }
    }
}
