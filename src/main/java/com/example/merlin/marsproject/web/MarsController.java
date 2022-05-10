package com.example.merlin.marsproject.web;

import com.example.merlin.marsproject.Response.MarsRoverApiResponse;
import com.example.merlin.marsproject.service.MarsRoverApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarsController {
    //listen for a request, and execute the method
    @Autowired
    private MarsRoverApiService marsRoverApiService;

    @GetMapping ("/home")
    public String postHomeView (ModelMap model, @RequestParam(required = false) String marsRoverData) {
        // If marsRoverData is Empty, set to a default value
        if (marsRoverData == null) {
            marsRoverData = "spirit";
        }
        //populate the model
        MarsRoverApiResponse roverData = marsRoverApiService.getRoverData(marsRoverData);
        model.put("roverData", roverData);
        return "index";
    }
}
