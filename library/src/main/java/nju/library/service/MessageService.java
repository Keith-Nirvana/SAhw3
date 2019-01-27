package nju.library.service;

import nju.library.entity.Message;

import java.util.List;

public interface MessageService {
    public List<Message> getUnReadMessageByUserId(String userId);

    public boolean readMessage(String messageId, String userId);
}
