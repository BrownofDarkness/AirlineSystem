package com.tp_3055.system.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp_3055.system.service.FlightServicesImpl;


@Controller
public class PageController{

    @Autowired(required=false)
    private FlightServicesImpl flightServicesImpl;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("allflightlist", flightServicesImpl.getAllClients());
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(){
        return "admin/adminpage";
    }

    @GetMapping("/singin")
    public String login(){
        return "user/loginform";
    }

    @PostMapping("/sing_in")
    public String singin(){
        return "redirect:/";
    }

}