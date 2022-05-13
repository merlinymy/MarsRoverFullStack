package com.example.merlin.marsproject.web;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.model.MarsModel;
import com.example.merlin.marsproject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class MarsController {
    //listen for a request, and execute the method
    @Autowired
    private MarsRoverApiService marsRoverApiService;

    @GetMapping ("/")
    public String postHomeView (ModelMap model, MarsModel marsModel) {
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
        return "index";
    }
}
