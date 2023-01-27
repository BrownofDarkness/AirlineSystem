package com.tp_3055.system.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/regsiter")
    public String login(ModelMap modelMap){
        return "user/lsingupform";
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap){
        return "user/loginform";
    }

    @GetMapping("/myProfile")
    public String getProfile(ModelMap modelMap){
        return "user/userhome";
    }

    @GetMapping("/myProfile")
    public String editProfile(ModelMap modelMap){
        return "user/editprofile";
    }
}