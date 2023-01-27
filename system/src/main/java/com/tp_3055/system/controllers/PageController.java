package com.tp_3055.system.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController{

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "world", required = false) String name, ModelMap modelMap){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(ModelMap modelMap){
        return "admin/adminpage";
    }
}