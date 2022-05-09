package com.example.merlin.marsproject.web;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarsController {
    //listen for a request, and execute the method
    @Autowired
    private MarsRoverApiService marsRoverApiService;

    @GetMapping("/")
    public String getHomeView (ModelMap model) {
        //populate the model
        MarsRoverApiResponse roverData = marsRoverApiService.getRoverData("Spirit");
        model.put("roverData", roverData);
        return "index";
    }
}
