package nju.library.daoImpl;

import java.util.Date;

import nju.library.dao.DaoHelper;
import nju.library.dao.RecordDao;
import nju.library.entity.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl implements RecordDao {
    private DaoHelper daoHelper;

    public RecordDaoImpl() {
        daoHelper = new DaoHelperImpl();
    }

    @Override
    public boolean addRecord(Record record) {
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
        Connection conn = daoHelper.getConnection();
        try {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            String sql =
                    "UPDATE library_information.record SET payment=" + payment + ", returnDate = '" + timestamp + "' " +
                    "WHERE " + "recordId='" + recordId + "'";
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
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.record");
            List<Record> records = new ArrayList<>();
            while (rs.next()) {
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
    public List<Record> getUnfinishedRecordByUserId(String userId) {
        List<Record> records = new ArrayList<>();

        Connection conn = daoHelper.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM library_information.record WHERE readerId='" + userId + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (rs.getTimestamp("returnDate") == null) {
                    records.add(new Record(rs.getString("recordId"), rs.getString("bookId"), rs.getString(
                            "readerId"), rs.getTimestamp("borrowDate"), rs.getTimestamp("returnDate"), rs.getDouble(
                            "payment")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoHelper.closeResource(conn, stmt, rs);
        }

        return records;
    }

    @Override
    public Record getUnfinishedRecord(String bookId) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.record WHERE bookId='" + bookId + "'");
            while (rs.next()) {
                if (rs.getTimestamp("returnDate") == null) {
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
