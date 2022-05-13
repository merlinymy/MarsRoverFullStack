package com.example.merlin.marsproject.service;

import com.example.merlin.marsproject.Response.MarsPhoto;
import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.model.MarsModel;
import org.apache.el.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarsRoverApiService {
    private static final String API_KEY = "36PiciLiBgEg5akEnyqeDV4g6S8Pb1tRc7bugGUC";
    public MarsRoverApiResponse getRoverData(MarsModel marsModel) {
        RestTemplate restTemplate = new RestTemplate();

        List<String> apiEndpoint = getApiUrl(marsModel);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiEndpoint.stream().forEach(url -> {
            MarsRoverApiResponse apiResponse = restTemplate.getForObject(url, response.getClass());
            photos.addAll(apiResponse.getPhotos());
        });
        response.setPhotos(photos);
        return response;

    }

    public List<String> getApiUrl(MarsModel marsModel) {
        List<String> urls = new ArrayList<>();

        if (marsModel.getCamChemcam() == null &&
                marsModel.getCamMahli() == null &&
                marsModel.getCamMardi() == null &&
                marsModel.getCamChemcam() == null &&
                marsModel.getCamMast() == null &&
                marsModel.getCamMinites() == null &&
                marsModel.getCamNavcam() == null &&
                marsModel.getCamPancam() == null &&
                marsModel.getCamRhaz() == null) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY);
        }
        if (Boolean.TRUE.equals(marsModel.getCamChemcam())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=fhaz");
        }
        if (Boolean.TRUE.equals(marsModel.getCamMahli()) && "Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=mahli");
        }
        if (Boolean.TRUE.equals(marsModel.getCamMardi()) && "Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=mardi");
        }
        if (Boolean.TRUE.equals(marsModel.getCamChemcam()) && "Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=chemcam");
        }
        if (Boolean.TRUE.equals(marsModel.getCamMast()) && "Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=mast");
        }
        if (Boolean.TRUE.equals(marsModel.getCamMinites()) && !"Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=minites");
        }
        if (Boolean.TRUE.equals(marsModel.getCamNavcam())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=navcam");
        }
        if (Boolean.TRUE.equals(marsModel.getCamPancam()) && !"Curiosity".equalsIgnoreCase(marsModel.getRoverName())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=pancam");
        }
        if (Boolean.TRUE.equals(marsModel.getCamRhaz())) {
            urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera=rhaz");
        }
        return urls;
    }
}
