package nju.library.service;

import nju.library.entity.Administrator;

public interface UserInfoUpdateNotify {
    public void add(Administrator admin);

    /*删除观察者*/
    public void del(Administrator admin);

    /*通知所有的观察者*/
    public void notifyObservers();
}
