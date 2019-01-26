package nju.library.daoImpl;

import nju.library.dao.DaoHelper;
import nju.library.dao.RecordDao;
import nju.library.entity.Record;

import java.sql.*;

public class RecordDaoImpl implements RecordDao {
    @Override
    public boolean addRecord(Record record) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        String name = null;
        try {
            String sql = "INSERT INTO library_information.Record(recordId, bookId, readerId, " +
                    "borrowDate) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, record.getRecordId());
            ps.setString(2, record.getBookId());
            ps.setString(3, record.getReaderId());
            ps.setTimestamp(4, new Timestamp(record.getBorrowDate().getTime()));

            ps.executeUpdate();

            conn.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modifyRecord(String recordId, double payment) {
        return false;
    }

    @Override
    public boolean getAllRecord() {
        return false;
    }

    @Override
    public Record getUnfinishedRecord(String bookId){
        return null;
    }
}
