package nju.library.daoImpl;

import nju.library.dao.DaoHelper;
import nju.library.dao.UserDao;
import nju.library.entity.Record;
import nju.library.entity.User;
import nju.library.factory.UserFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DaoHelper daoHelper;

    public UserDaoImpl(){
        daoHelper = new DaoHelperImpl();
    }

    @Override
    public User getUserById(String userId) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.user WHERE userId='" + userId + "'");
            while (rs.next() ){
                User user = new User(rs.getString("userId"), rs.getString("userName"), rs.getString("department"),
                        rs.getString("email"), rs.getString("type"), rs.getString("permission"));
                return user;
            }
            daoHelper.closeResource(conn, st, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        Connection conn = daoHelper.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM library_information.user";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                User user = UserFactory.createUser(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoHelper.closeResource(conn, stmt, rs);
        }

        return users;
    }

    @Override
    public boolean modifyUser(String userId, String userName, String department, String email, String type) {
        Connection conn = daoHelper.getConnection();
        try {
            String sql = "UPDATE library_information.user SET userName='" + userName + "', department='"
                    + department + "', email='" + email + "', type='" + type + "'"
                    + " WHERE userId='" + userId + "'";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean createUser(User user) {
        Connection conn = daoHelper.getConnection();
        try {
            String sql = "INSERT INTO library_information.user(userId, passwd, userName, department" +
                    ", email, type, permission) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
    public boolean grantPermission(String userId, String permission) {
        return false;
    }
}
