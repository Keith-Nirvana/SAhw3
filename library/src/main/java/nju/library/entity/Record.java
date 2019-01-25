package nju.library.entity;

import java.util.Date;

public class Record {
    private String recordId;
    private String bookId;
    private String readerId;
    private Date borrowDate;
    private Date returnDate;

    public Record() {
    }

    public Record(String bookId, String readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }
}
