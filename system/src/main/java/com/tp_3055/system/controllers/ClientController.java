package com.tp_3055.system.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp_3055.system.model.Client;
import com.tp_3055.system.service.ClientServicesImpl;

@Controller
public class ClientController {
    
    @Autowired(required = false)
    private ClientServicesImpl clientservicesImpl;

    @GetMapping("/register")
    public String singup(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "user/singupform";
    }


    @GetMapping("/myProfile")
    public String getProfile(Model model){
        return "user/userhome";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("client") Client client){
        clientservicesImpl.save(client);
        return "redirect:/";
    }

    @GetMapping("/client/{id}/editProfile")
    public String editProfile(@PathVariable(value = "id") Long id, Model model){
        Client client = clientservicesImpl.getById(id);
        model.addAttribute("client", client);
        return "user/editprofile";
    }

    @GetMapping("/deleteclient/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        clientservicesImpl.deleteViaId(id);
        return "redirect:/";
 
    }
}