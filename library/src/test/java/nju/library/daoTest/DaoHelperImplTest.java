package nju.library.daoTest;

import nju.library.dao.DaoHelper;
import nju.library.daoImpl.DaoHelperImpl;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelperImplTest {
    @Test
    public void testConnection(){
        DaoHelper daoHelper = new DaoHelperImpl();
        Connection conn = daoHelper.getConnection();
        String name = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM library_information.user");
            while (rs.next()){
                name = rs.getString("userName");
            }
            daoHelper.closeResource(conn, st, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }

}
