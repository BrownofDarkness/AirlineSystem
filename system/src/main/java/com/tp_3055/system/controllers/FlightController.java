package com.tp_3055.system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightController {

    @GetMapping("/clients")
    public String viewC(ModelMap modelMap){
        return "";
    }
}
