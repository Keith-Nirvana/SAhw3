package nju.library.daoImpl;

import nju.library.dao.DaoHelper;
import nju.library.dao.UserDao;
import nju.library.entity.Record;
import nju.library.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(String userId) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.user WHERE userId=" + userId);
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
}
