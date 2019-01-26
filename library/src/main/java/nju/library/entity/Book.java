package nju.library.entity;

public class Book {
    private String bookId;
    private String bookName;
    private int category;
    private String format;
    private boolean isBorrowed;

    public Book(){}

    public Book(String bookId, String bookName, int category, String format, boolean isBorrowed){
        this.bookId = bookId;
        this.bookName = bookName;
        this.category = category;
        this.format = format;
        this.isBorrowed = isBorrowed;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
