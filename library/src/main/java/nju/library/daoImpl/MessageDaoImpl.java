package nju.library.daoImpl;

import nju.library.dao.DaoHelper;
import nju.library.dao.MessageDao;
import nju.library.entity.Message;
import nju.library.factory.UserFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {
    private DaoHelper daoHelper;

    public MessageDaoImpl(){
        daoHelper = new DaoHelperImpl();
    }

    @Override
    public List<Message> getUnReadMessageByUserId(String userId) {
        List<Message> messages = new ArrayList<>();

        Connection conn = daoHelper.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM library_information.message";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Message message = new Message(rs.getString(1), rs.getString(2),
                        rs.getString(3), (rs.getInt(4)==0 ? false : true));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            daoHelper.closeResource(conn, stmt, rs);
        }
        return messages;
    }

    @Override
    public boolean addMessage(Message message) {
        Connection conn = daoHelper.getConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO library_information.message (messageId, userId, message, isRead) " +
                "VALUES (?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, message.getMessageId());
            pst.setString(2, message.getUserId());
            pst.setString(3, message.getMessage());
            pst.setInt(4, (message.isRead() == true ? 1 : 0));

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return  true;
    }

    @Override
    public boolean readMessage(String messageId, String userId) {
        Connection conn = daoHelper.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE library_information.message SET isRead = 1 " +
                "WHERE userId = ? AND messageId = ?";

        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, userId);
            pst.setString(2, messageId);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return  true;
    }
}
