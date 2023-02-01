package com.tp_3055.system.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tp_3055.system.repos.FlightRepository;
@Controller
public class PageController{
    
    

    @GetMapping("/")
    public String home(Model model){
        return "index";
    }


    @GetMapping("/singin")
    public String login(){
        return "user/loginform";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}