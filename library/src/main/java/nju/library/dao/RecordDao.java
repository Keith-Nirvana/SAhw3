package nju.library.dao;

import nju.library.entity.Record;

public interface RecordDao {
    public boolean addRecord(Record record);

    public boolean modifyRecord(String recordId, double payment);

    public boolean getAllRecord();

    public Record getUnfinishedRecord(String bookId);
}
