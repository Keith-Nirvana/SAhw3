package nju.library.daoImpl;

import nju.library.dao.BookDao;
import nju.library.dao.DaoHelper;
import nju.library.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private DaoHelper daoHelper;

    public BookDaoImpl(){
        daoHelper = new DaoHelperImpl();
    }

    @Override
    public boolean modifyBookState(String bookId, boolean isborrow) {
        Connection conn = daoHelper.getConnection();
        try {
            int is = isborrow ? 1 : 0;
            String sql = "UPDATE library_information.book SET isBorrowed=" + is + " WHERE bookId='" +
                    bookId + "'";
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
    public boolean modifyBookInfo(String bookId, String bookName, int category) {
        Connection conn = daoHelper.getConnection();

        try {
            String sql = "UPDATE library_information.book SET bookName='" + bookName
                    + "', category=" + category + " WHERE bookId='" + bookId + "'";
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        Connection conn = daoHelper.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM library_information.book";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                boolean isBorrowed = (rs.getInt(5) == 1);
                Book book = new Book(
                        rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), isBorrowed
                );

                books.add(book);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return books;
    }

    @Override
    public Book getBookById(String bookId) {
        Connection conn = daoHelper.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM library_information.book WHERE bookId = '" + bookId + "'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                boolean isBorrowed = (rs.getInt(5) == 1);
                Book book = new Book(
                        rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), isBorrowed
                );

                return book;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }
}
