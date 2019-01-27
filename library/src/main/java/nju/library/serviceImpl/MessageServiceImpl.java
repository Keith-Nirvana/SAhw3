package nju.library.serviceImpl;

import nju.library.entity.Message;
import nju.library.factory.DaoFactory;
import nju.library.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Override
    public List<Message> getUnReadMessageByUserId(String userId) {
        return DaoFactory.getMessageDao().getUnReadMessageByUserId(userId);
    }

    @Override
    public boolean readMessage(String messageId, String userId) {
        return DaoFactory.getMessageDao().readMessage(messageId, userId);
    }
}
