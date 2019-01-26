package nju.library.dao;

import nju.library.entity.Record;

import java.util.List;

public interface RecordDao {
    public boolean addRecord(Record record);

    public boolean modifyRecord(String recordId, double payment);

    public List<Record> getAllRecord();

    public Record getUnfinishedRecord(String bookId);
}
