package nju.library.serviceImpl.borrowServiceImpl;

import nju.library.entity.Record;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.BorrowStrategy;
import nju.library.util.UserType;

import java.util.Date;

public class GraduateBorrowStrategy implements BorrowStrategy {
    @Override
    public boolean borrowBook(String userId, String bookId) {
        // 增加借书记录，修改图书状态
        Record record = new Record(bookId, userId);
        System.out.println("毕业生成功借书");
        return DaoFactory.getRecordDao().addRecord(record) && DaoFactory.getBookDao().modifyBookState(bookId, true);
    }

    @Override
    public boolean returnBook(String userId, String bookId) {
        // 看是否过期，计算金额，修改图书状态，修改借书记录
        User user = DaoFactory.getUserDao().getUserById(userId);
        Record record = DaoFactory.getRecordDao().getUnfinishedRecord(bookId);

        int maxBorrowDays = UserType.getMaxBorrowDay(user.getType());

        int betweenDays =
                Integer.parseInt(String.valueOf((new Date().getTime() - record.getBorrowDate().getTime()) / (1000 * 3600 * 24)));

        double payment = 0.0;

        if (betweenDays > maxBorrowDays)
            payment = (betweenDays - maxBorrowDays) * 1.0;

        System.out.println("毕业生成功还书");

        return DaoFactory.getBookDao().modifyBookState(bookId, false) && DaoFactory.getRecordDao().modifyRecord(record.getRecordId(), payment);
    }
}
