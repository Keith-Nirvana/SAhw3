package nju.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DaoHelper {
    public Connection getConnection();

    public void closeConnection(Connection conn);

    public void closeResource(Connection conn, Statement st, ResultSet rs);

    public void closeResource(Connection conn, PreparedStatement ps, ResultSet rs);
}
