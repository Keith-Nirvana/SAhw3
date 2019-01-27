package nju.library.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class BookControllerTest {

    @Test
    public void getAllBooks() {
        String url = "http://localhost:8080/book/allBooks";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"131928473\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void getBorrowedBooks() {
        String url = "http://localhost:8080/book/borrowedBooks";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250031\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void borrowBook() {
        String url = "http://localhost:8080/book/borrowBook";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250002\", \"bookId\":\"N100002\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void returnBook() {
    }

    @Test
    public void modifyBook() {
        String url = "http://localhost:8080/book/modifyBook";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"bookId\":\"N100002\", \"bookName\":\"Design Pattern\", \"category\":\"02\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }
}