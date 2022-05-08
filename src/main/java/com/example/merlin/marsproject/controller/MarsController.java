package com.example.merlin.marsproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarsController {
    //listen for a request, and execute the method
    @GetMapping("/")
    public String getHomeView (ModelMap model) {
        //populate the model

        return "index";
    }
}
