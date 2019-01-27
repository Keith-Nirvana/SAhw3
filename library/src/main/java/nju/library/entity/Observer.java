package nju.library.entity;

public interface Observer {
    public boolean receiveUpdateInfo(String messageId, String message);
}
