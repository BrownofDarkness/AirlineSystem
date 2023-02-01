package com.tp_3055.system.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.repos.FlightRepository;
import com.tp_3055.system.service.FlightServicesImpl;

@Controller
public class FlightController {

    @Autowired(required = false)
    private FlightServicesImpl flightServicesImpl;

    @Autowired
    private FlightRepository flightRepository;


    @GetMapping("/createflight")
    public String newFlight(Model model){
        Flight flight = new Flight();
        System.out.println();
        System.out.println(flight.getStatus());
        System.out.println();
        model.addAttribute("flight", flight);
        return "flights/create";
    }


    @GetMapping("flight/{id}")
    public String flightDetail(@PathVariable(value = "id") Long id,Model model){
        Flight flight = flightServicesImpl.getById(id);
        model.addAttribute("flight", flight);
        return "index";
    }

    @PostMapping("/saveflight")
    public String saveflight(@ModelAttribute("flight") Flight flight){
        System.out.println();
        System.out.println(flight.getDepartCountry());
        System.out.println(flight.getDepartTown());
        System.out.println();
        flightRepository.save(flight);
        return "redirect:/dashboard";
    }

    @PostMapping("/updateflight")
    public String updateflight(@ModelAttribute("flight") Flight flight){
        System.out.println();
        System.out.println(flight.getDepartCountry());
        System.out.println(flight.getDepartTown());
        System.out.println();
        flight.setId(flight.getId());
        flight.setArivalCountry(flight.getArivalCountry());
        flight.setArivalTown(flight.getArivalTown());
        flight.setDepartCountry(flight.getDepartCountry());
        flight.setDepartTown(flight.getDepartTown());
        flight.setPrice(flight.getPrice());
        flight.setStatus(flight.getStatus());
        flight.setTotalseats(flight.getTotalseats());
        flightRepository.save(flight);
        return "redirect:/dashboard";
    }

    

    @GetMapping("/updateflight_{id}")
    public String update(@PathVariable(value = "id") Long id, Model model){
        Optional<Flight> optional = flightRepository.findById(id);
        Flight flight = null;
        if (optional.isPresent())
            flight = optional.get();
        else
            throw new RuntimeException("client not found for id : " + id);
        model.addAttribute("flight", flight);
        return "flights/update";
    }

    @GetMapping("/deleteflight/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        flightRepository.deleteById(id);
        return "redirect:/dashboard";
 
    }
}
