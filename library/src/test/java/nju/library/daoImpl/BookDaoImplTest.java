package nju.library.daoImpl;

import nju.library.dao.BookDao;
import org.junit.Before;
import org.junit.Test;

public class BookDaoImplTest {
    BookDao bookDao;
    @Before
    public void setUp() throws Exception{
        bookDao = new BookDaoImpl();
    }

    @Test
    public void modifyBookStateTest(){
        bookDao.modifyBookState("N100002", true);
    }

    @Test
    public void modifyBookInfoTest(){
        bookDao.modifyBookInfo("N100002", "设计模式上", 2);
    }

    @Test
    public void getAllBooksTest(){
        bookDao.getAllBooks().forEach(item -> System.out.println(item.getBookId()));
    }
}
