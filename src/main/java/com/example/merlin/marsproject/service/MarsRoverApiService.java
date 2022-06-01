package com.example.merlin.marsproject.service;

import com.example.merlin.marsproject.Response.MarsPhoto;
import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.model.MarsModel;
import com.example.merlin.marsproject.repository.MarsModelRepository;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class MarsRoverApiService {
    @Autowired
    private MarsModelRepository marsModelRepository;

    private Map<String, List<String>> validCameras = new HashMap<>();

    public Map<String, List<String>> getValidCameras() {
        return validCameras;
    }

    public MarsRoverApiService() {
        validCameras.put("Curiosity", Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"));
        validCameras.put("Opportunity", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
        validCameras.put("Spirit", Arrays.asList("FHAZ", "RHAZ", "NAVCAM", "PANCAM", "MINITES"));
    }

    private static final String API_KEY = "36PiciLiBgEg5akEnyqeDV4g6S8Pb1tRc7bugGUC";
    public MarsRoverApiResponse getRoverData(MarsModel marsModel) throws InvocationTargetException, IllegalAccessException {
        RestTemplate restTemplate = new RestTemplate();

        List<String> apiEndpoint = getApiUrl(marsModel);
        List<MarsPhoto> photos = new ArrayList<>();
        MarsRoverApiResponse response = new MarsRoverApiResponse();

        apiEndpoint.forEach(url -> {
            MarsRoverApiResponse apiResponse = restTemplate.getForObject(url, response.getClass());
            photos.addAll(apiResponse.getPhotos());
        });
        response.setPhotos(photos);
        return response;

    }

    public List<String> getApiUrl(MarsModel marsModel) throws InvocationTargetException, IllegalAccessException {
        List<String> urls = new ArrayList<>();
        List<String> defaultUrl = Collections.singletonList("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol=" + marsModel.getSol() + "&api_key=" + API_KEY);
        Method[] methods = marsModel.getClass().getMethods();
        int numberOffCam = 9;
        int offCamCount = 0;
        for (Method method : methods) {
            if (method.getName().contains("getCam") &&
                    (Boolean.FALSE.equals(method.invoke(marsModel)) || method.invoke(marsModel) == null)) {
                offCamCount++;
            }
        }
        // Grab all getCam* methods. If the method starts with "getCam" and returns ture, we build an
        // api URL to call in order to fetch pictures for a given rover/cam/sol
        for (Method method : methods) {
            if (method.getName().contains("getCam") && Boolean.TRUE.equals(method.invoke(marsModel))) {
               String camName = method.getName().split("getCam")[1].toUpperCase();
                if (validCameras.get(marsModel.getRoverName()).contains(camName)) {
                   urls.add("https://api.nasa.gov/mars-photos/api/v1/rovers/" + marsModel.getRoverName() + "/photos?sol="+marsModel.getSol()+"&api_key="+API_KEY+"&camera="+camName);
               }
           }
        }
        return numberOffCam == offCamCount ? defaultUrl : urls;
    }

    public MarsModel savePref(MarsModel marsModel) {
        return marsModelRepository.save(marsModel);
    }

    public MarsModel findByUserId(Long userId) {
        MarsModel marsModel = marsModelRepository.findByUserId(userId);
        return marsModel;
    }
}
