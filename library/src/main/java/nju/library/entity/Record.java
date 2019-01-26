package nju.library.entity;

import java.util.Date;

public class Record {
    private String recordId;
    private String bookId;
    private String readerId;
    private Date borrowDate;
    private Date returnDate;
    private double payment;

    public Record() {
    }

    public Record(String bookId, String readerId) {
        this.recordId = new Date().getTime() + "";
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = new Date();
    }

    public String getRecordId() {
        return recordId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getReaderId() {
        return readerId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}
