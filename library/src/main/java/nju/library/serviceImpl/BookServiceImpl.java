package nju.library.serviceImpl;

import nju.library.entity.Book;
import nju.library.entity.Record;
import nju.library.entity.Teacher;
import nju.library.entity.User;
import nju.library.factory.DaoFactory;
import nju.library.factory.UserFactory;
import nju.library.service.BookService;
import nju.library.util.UserType;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAllBooks(String userId) {
        List<Book> books = DaoFactory.getBookDao().getAllBooks();
        List<Book> result = new ArrayList<>();

        User user = DaoFactory.getUserDao().getUserById(userId);
        int permissionLevel = UserType.getPermittedBorrowedBooksType(user.getType());

        for (Book book: books){
            if (book.getCategory() <= permissionLevel)
                result.add(book);
        }

        return result;
    }

    @Override
    public List<Book> getBorrowedBooks(String userId) {
        List<Book> books = DaoFactory.getBookDao().getAllBooks();
        List<Book> result = new ArrayList<>();

        List<Record> records = DaoFactory.getRecordDao().getUnfinishedRecordByUserId(userId);
        for (Book book: books){
            for (Record record: records){
                if (record.getBookId().equals(book.getBookId()))
                    result.add(book);
            }
        }

        return result;
    }

    @Override
    public boolean modifyBookInfo(String bookId, String bookName, int category) {
        return DaoFactory.getBookDao().modifyBookInfo(bookId, bookName, category);
    }

    @Override
    public boolean borrowBook(String bookId, String userId) {
        User user = DaoFactory.getUserDao().getUserById(userId);
        return user.borrowBook(bookId);
    }

    @Override
    public boolean returnBook(String bookId, String userId) {
        User user = DaoFactory.getUserDao().getUserById(userId);
        return user.returnBook(bookId);
    }

    @Override
    public Book getBookById(String bookId){
        return DaoFactory.getBookDao().getBookById(bookId);
    }

}
