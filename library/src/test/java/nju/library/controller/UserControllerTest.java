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
    }

    @Test
    public void createUser() {
    }

    @Test
    public void modifyUser() {
    }

    @Test
    public void grantPermission() {
    }
}