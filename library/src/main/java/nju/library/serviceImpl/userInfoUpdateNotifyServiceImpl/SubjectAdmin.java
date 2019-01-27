package nju.library.serviceImpl.userInfoUpdateNotifyServiceImpl;

import nju.library.entity.Administrator;
import nju.library.service.UserInfoUpdateNotify;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public void notifyObservers(String message) {
//        System.out.println(message);
//        System.out.println("admins size is " + registerAdmin.size());

        String messageId = generateMessageId();
        for (Administrator admin: registerAdmin){
            admin.receiveUpdateInfo(messageId, message);
        }
    }

    private String generateMessageId(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
