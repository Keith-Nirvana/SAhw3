package nju.library.serviceImpl.borrowServiceImpl;

import nju.library.daoImpl.BookDaoImpl;
import nju.library.daoImpl.RecordDaoImpl;
import nju.library.entity.Record;
import nju.library.service.BorrowStrategy;

public class UndergraduateBorrowStrategy implements BorrowStrategy {
    @Override
    public boolean borrowBook(String userId, String bookId) {
        // 增加借书记录，修改图书状态
        Record record = new Record(bookId, userId);
        System.out.println("在校生成功借书");
        return new RecordDaoImpl().addRecord(record) && new BookDaoImpl().modifyBookState(bookId, true);
    }

    @Override
    public boolean returnBook(String userId, String bookId) {
        return false;
    }
}
