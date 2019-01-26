package nju.library.daoImpl;

import nju.library.dao.BookDao;
import nju.library.dao.DaoHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDaoImpl implements BookDao {
    @Override
    public boolean modifyBookState(String bookId, boolean isborrow) {
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        try {
            int is = isborrow ? 1 : 0;
            String sql = "UPDATE library_information.book SET bookId=" + bookId + " WHERE isBorrowed=" +
                    is;
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
}
