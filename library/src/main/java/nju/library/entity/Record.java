package nju.library.entity;

import java.util.Date;

public class Record {
    private String recordId;
    private String bookId;
    private String readerId;
    private Date borrowDate;
    private Date returnDate;

    public void setPayment(double payment) {
        this.payment = payment;
    }

    private double payment;

    public Record() {
    }

    public Record(String bookId, String readerId) {
        this.recordId = new Date().getTime() + "";
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = new Date();
    }

    public Record(String recordId, String bookId, String readerId, Date borrowDate, Date returnDate, double payment) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.payment = payment;
    }

    public Record(String recordId, String bookId, String readerId, Date borrowDate) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.borrowDate = borrowDate;
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

    public Date getReturnDate() {
        return returnDate;
    }

    public double getPayment() {
        return payment;
    }
}
