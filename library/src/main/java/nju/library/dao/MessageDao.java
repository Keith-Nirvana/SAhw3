package nju.library.dao;

import nju.library.entity.Message;

import java.util.List;

public interface MessageDao {
    public List<Message> getUnReadMessageByUserId(String userId);

    public boolean addMessage(Message message);

    public boolean readMessage(String messageId, String userId);
}
