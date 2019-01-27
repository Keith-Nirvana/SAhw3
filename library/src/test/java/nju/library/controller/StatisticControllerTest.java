package nju.library.controller;

import nju.library.entity.Record;
import nju.library.serviceImpl.StatisticServiceImpl;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class StatisticControllerTest {

    @Test
    public void getAllBooks() {
        String url = "http://localhost:8080/statistic/getBorrowedRecords";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void getOverduePenaltyRecords() {
//        List<Record> recordList = new StatisticServiceImpl().getOverduePenaltyRecords();
//        for (int i = 0 ; i < recordList.size(); i++)
//            System.out.println(recordList.get(i).getRecordId());
        String url = "http://localhost:8080/statistic/getPenaltyRecords";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);

        System.out.println(jsonData);
    }
}