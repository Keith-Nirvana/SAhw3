package nju.library.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class MessageControllerTest {

    @Test
    public void getMessages() {
        String url = "http://localhost:8080/message/getMessages";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"AD2937589\"}";

        System.out.println(jsonStr);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void readMessage() {
        String url = "http://localhost:8080/message/readMessage";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"AD2937589\", \"messageId\": \"2019-01-27 12:47:02\"}";

        System.out.println(jsonStr);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }
}