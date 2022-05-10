package com.example.merlin.marsproject.service;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MarsRoverApiService {
    private static final String API_KEY = "36PiciLiBgEg5akEnyqeDV4g6S8Pb1tRc7bugGUC";
    public MarsRoverApiResponse getRoverData(String roverType) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MarsRoverApiResponse> response =  restTemplate.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/" + roverType + "/photos?sol=2&api_key="+API_KEY,
                MarsRoverApiResponse.class);//expecting a string back

        return response.getBody();
    }
}
