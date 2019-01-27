package nju.library.daoImpl;

import nju.library.dao.MessageDao;
import nju.library.entity.Message;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageDaoImplTest {
    MessageDao messageDao;

    @Before
    public void setUp() throws Exception{
        messageDao = new MessageDaoImpl();
    }

    @Test
    public void getUnReadMessageByUserId() {
        messageDao.getUnReadMessageByUserId("AD2937589").forEach(item -> System.out.println(item.getUserId()+item.getMessage()));
    }

    @Test
    public void addMessage() {
        messageDao.addMessage(new Message("20190127-0953", "161250031", "nothing", false));
    }

    @Test
    public void readMessage() {
        messageDao.readMessage("20190127-0953", "161250031");
    }
}