package nju.library.serviceImpl;

import nju.library.entity.Record;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.service.StatisticService;
import nju.library.util.UserType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticServiceImpl implements StatisticService {
    @Override
    public List<Record> getAllRecord() {
        return DaoFactory.getRecordDao().getAllRecord();
    }

    @Override
    public List<Record> getOverduePenaltyRecords() {
        List<Record> records = getAllRecord();
        List<Record> result = new ArrayList<>();

        for (Record record: records){
            if (record.getPayment() > 0.001)
                result.add(record);
            else if (record.getReturnDate() == null && checkOverdue(record)) {
                // 计算欠款
                User user = DaoFactory.getUserDao().getUserById(record.getReaderId());
                int maxBorrowDays = UserType.getMaxBorrowDay(user.getType());
                int betweenDays=
                        Integer.parseInt(String.valueOf((new Date().getTime() -record.getBorrowDate().getTime())/(1000*3600*24)));
                double payment = (betweenDays - maxBorrowDays) * 1.0;

                record.setPayment(payment);
                result.add(record);
            }
        }

        return result;
    }

    private boolean checkOverdue(Record record){
        User user = DaoFactory.getUserDao().getUserById(record.getReaderId());

        int maxBorrowDays = UserType.getMaxBorrowDay(user.getType());
        int betweenDays=
                Integer.parseInt(String.valueOf((new Date().getTime() -record.getBorrowDate().getTime())/(1000*3600*24)));

        return betweenDays > maxBorrowDays;
    }
}
