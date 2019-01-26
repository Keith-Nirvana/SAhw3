package nju.library.daoImpl;

import nju.library.dao.DaoHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DaoHelperImpl implements DaoHelper {
    private static String driver = "";    //mysql8以下版本去掉.cj
    private static String url = "";  //mysql8以下serverTimeZone可去掉
    private static String user = "";
    private static String password = "";  //密码自己填

    static {
        InputStream inputStream = DaoHelper.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            Properties properties = new Properties();
            properties.load(inputStream);

            driver = properties.getProperty("className");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DaoHelperImpl(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find Driver------------in DaoHelper");
            e.printStackTrace();
        }
    }


    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void closeConnection(Connection conn) {
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closePreparedStatement(PreparedStatement ps)
    {
        if(ps != null) {
            try{
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(Statement stmt)
    {
        if(stmt != null) {
            try{
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Close statement Error----------in DaoHelper");
                e.printStackTrace();
            }
        }
    }

    private void closeResult(ResultSet result)
    {
        if(result!=null) {
            try{
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResult(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    @Override
    public void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        closeResult(rs);
        closePreparedStatement(ps);
        closeConnection(conn);
    }
}
