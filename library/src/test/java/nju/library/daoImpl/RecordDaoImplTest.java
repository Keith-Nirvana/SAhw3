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
    }

    @Test
    public void getAllRecord() {
    }
}