package nju.library.controller;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Test
    public void getAllUser() {
        String url = "http://localhost:8080/user/allUser";

        RestTemplate restTemplate = new RestTemplate();
        String jsonData = restTemplate.getForObject(url, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void getUserById() {
        String url = "http://localhost:8080/user/id";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250031\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void createUser() {
        String url = "http://localhost:8080/user/addUser";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250002\", \"password\": \"0792\", " +
                "\"userName\": \"whiskey\", \"department\": \"SE\", \"email\": \"7222@qq.com\"," +
                "\"type\": \"UNDERGRADUATE\"}";
        System.out.println(jsonStr);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void modifyUser() {
        String url = "http://localhost:8080/user/modifyUser";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250002\", " +
                "\"userName\": \"whiskey\", \"department\": \"SE\", \"email\": \"7222@qq.com\"," +
                "\"type\": \"UNDERGRADUATE\"}";
        System.out.println(jsonStr);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }

    @Test
    public void grantPermission() {
        String url = "http://localhost:8080/user/grant";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "application/json;charset=UTF-8");

        String jsonStr = "{\"userId\":\"161250031\", \"permission\": \"45\"}";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, requestHeaders);
        String jsonData = restTemplate.postForObject(url, httpEntity, String.class);

        System.out.println(jsonData);
    }
}