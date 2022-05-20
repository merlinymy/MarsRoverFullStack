package com.example.merlin.marsproject.web;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.model.MarsModel;
import com.example.merlin.marsproject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@Controller
public class MarsController {
    //listen for a request, and execute the method
    @Autowired
    private MarsRoverApiService marsRoverApiService;

    @GetMapping ("/mars")
    public String getMarsView(ModelMap model, MarsModel marsModel) throws InvocationTargetException, IllegalAccessException {
        // If marsRoverData is Empty, set to a default value
        if (marsModel.getRoverName() == null || Objects.equals(marsModel.getRoverName(), "")) {
            marsModel.setRoverName("Spirit");
        }
        if (marsModel.getSol() == null) {
            marsModel.setSol(1);
        }
        //populate the model
        MarsRoverApiResponse roverData = marsRoverApiService.getRoverData(marsModel);
        model.put("roverData", roverData);
        model.put("marsModel", marsModel);
        model.put("validCams", marsRoverApiService.getValidCameras().get(marsModel.getRoverName()));
        return "marsApiProject";
    }
    @PostMapping("/mars")
    public String postMarsView(MarsModel marsModel) {
        System.out.println(marsModel);
        return "redirect:/mars";
    }
    @GetMapping("/")
    public String postHomeView() {
        return "home";
    }
    @GetMapping("/photoSite")
    public String postPhotoSite() {
        return "/photoSite/picSite";
    }
    @GetMapping("/landscape")
    public String postLandScape() {
        return "/photoSite/Landscape";
    }
    @GetMapping("/astrophotography")
    public String postAstro() {
        return "/photoSite/astrophotography";
    }
}
