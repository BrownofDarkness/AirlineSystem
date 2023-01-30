package com.tp_3055.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.service.FlightServicesImpl;

@Controller
public class FlightController {

    @Autowired(required = false)
    private FlightServicesImpl flightServicesImpl;


    @GetMapping("/createflight")
    public String newFlight(Model model){
        return "flights/create";
    }


    @GetMapping("flight/{id}")
    public String flightDetail(@PathVariable(value = "id") Long id,Model model){
        Flight flight = flightServicesImpl.getById(id);
        model.addAttribute("flight", flight);
        return "index";
    }

    @PostMapping("/saveflight")
    public String saveflight(@ModelAttribute("client") Flight flight){
        flightServicesImpl.save(flight);
        return "redirect:/";
    }

    @GetMapping("/flight/{id}/update")
    public String update(@PathVariable(value = "id") Long id, Model model){
        Flight flight = flightServicesImpl.getById(id);
        model.addAttribute("flight", flight);
        return "flights/update";
    }

    @GetMapping("/deleteflight/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        flightServicesImpl.deleteViaId(id);
        return "redirect:/";
 
    }
}
