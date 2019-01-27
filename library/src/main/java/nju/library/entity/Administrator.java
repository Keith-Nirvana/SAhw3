package nju.library.entity;

import nju.library.dao.MessageDao;
import nju.library.daoImpl.MessageDaoImpl;

public class Administrator extends User implements Observer {
    private MessageDao messageDao;

    public Administrator(String userId, String password, String userName, String department, String email, String type,
                         String permission) {
        super(userId, password, userName, department, email, type, permission);
        messageDao = new MessageDaoImpl();
    }

    @Override
    public boolean receiveUpdateInfo(String messageId, String message) {
        //System.out.println(messageId + message + userName + " in Administrator");
        return messageDao.addMessage(new Message(messageId, userId, message, false));
    }
}
