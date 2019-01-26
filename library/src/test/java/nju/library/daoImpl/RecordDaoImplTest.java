package nju.library.daoImpl;

import nju.library.entity.Record;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordDaoImplTest {

    @Test
    public void addRecord() {
        new RecordDaoImpl().addRecord(new Record("hshjd", "161250031"));
    }

    @Test
    public void modifyRecord() {
        new RecordDaoImpl().modifyRecord("1548508324848", 12.5);
    }

    @Test
    public void getAllRecord() {
        new RecordDaoImpl().getAllRecord().forEach(item -> System.out.println(item.getRecordId()));
    }

    @Test
    public void getUnfinishedRecordByUserId(){
        new RecordDaoImpl().getUnfinishedRecordByUserId("161250031").forEach(item -> System.out.println(item.getRecordId()));
    }
}