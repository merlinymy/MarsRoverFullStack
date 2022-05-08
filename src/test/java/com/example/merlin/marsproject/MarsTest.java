package com.example.merlin.marsproject;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MarsTest {
    @Test
    public void smallTest () {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MarsRoverApiResponse> response =  restTemplate.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY",
                MarsRoverApiResponse.class);//expecting a string back

        System.out.println(response.getBody());

    }
}
