package nju.library.entity;

public class Message {
    private String messageId;
    private String userId;
    private String message;
    private boolean isRead;

    public Message(String messageId, String userId, String message, boolean isRead) {
        this.messageId = messageId;
        this.userId = userId;
        this.message = message;
        this.isRead = isRead;
    }

    public Message(){}

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
