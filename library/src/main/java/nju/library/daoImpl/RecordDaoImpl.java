package nju.library.daoImpl;

import nju.library.dao.DaoHelper;
import nju.library.dao.RecordDao;
import nju.library.entity.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    @Override
    public boolean addRecord(Record record) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            String sql = "INSERT INTO library_information.record(recordId, bookId, readerId, " +
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
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            String sql = "UPDATE library_information.record SET payment=" + payment + " WHERE recordId=" +
                    recordId;
            Statement statement = conn.createStatement();
            int result = statement.executeUpdate(sql);
            if (result != 0) {
                statement.close();
                conn.close();
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Record> getAllRecord() {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.record");
            List<Record> records = new ArrayList<>();
            while (rs.next()){
                records.add(new Record(rs.getString("recordId"), rs.getString("bookId"), rs.getString(
                        "readerId"), rs.getTimestamp("borrowDate"), rs.getTimestamp("returnDate"), rs.getDouble(
                                "payment")));
            }
            daoHelper.closeResource(conn, st, rs);
            return records;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Record getUnfinishedRecord(String bookId) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.record WHERE bookId=" + bookId);
            while (rs.next() ){
                if(rs.getTimestamp("returnDate") != null){
                    Record record = new Record(rs.getString("recordId"), rs.getString("bookId"), rs.getString(
                            "readerId"), rs.getTimestamp("borrowDate"));
                    return record;
                }
            }
            daoHelper.closeResource(conn, st, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
