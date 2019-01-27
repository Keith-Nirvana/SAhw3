package nju.library.service;

import nju.library.entity.Record;

import java.util.List;

public interface StatisticService {
    public List<Record> getAllRecord();

    public List<Record> getOverduePenaltyRecords();
}
