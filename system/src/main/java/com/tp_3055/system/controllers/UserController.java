package com.tp_3055.system.controllers;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.model.User;
import com.tp_3055.system.repos.FlightRepository;
import com.tp_3055.system.repos.UserRepositry;
import com.tp_3055.system.service.ReservationServicesImpl;
import com.tp_3055.system.service.UserServicesImpl;

@Controller
public class UserController {
    
    @Autowired(required = false)
    private UserServicesImpl clientservicesImpl;
    
    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private FlightRepository flightRepository;


    @Autowired(required = false)
    private ReservationServicesImpl reservationServicesImpl;

    @GetMapping("/register")
    public String singup(Model model){
        User user = new User() {};
        System.out.println();
        System.out.println(user.getIsAdmin());
        System.out.println();
        model.addAttribute("user", user);
        return "user/singupform";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(Principal principal,Model model){
        Flight flight = new Flight();
        model.addAttribute("flight", flight);

        List<Flight> flights = flightRepository.findAll();
        if (flight!=null){
            model.addAttribute("flights", flights);
        }
        return "admin/adminpage";
    }

    @GetMapping("/myProfile")
    public String getProfile(Model model){
        return "user/userhome";
    }

    @GetMapping("/reservation")
    public String getReservationView(Model model){
        Reservation reservation = new Reservation(null);
        model.addAttribute("reservation", reservation);
        return "flights/reservations";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation){
        reservationServicesImpl.save(reservation);
        return "redirect:/";
    }

    @PostMapping("/saveUser")
    public String save(@ModelAttribute("user") User user){
        System.out.println("user.getIsAdmin(");
        System.out.println();
        System.out.println(user.getFirstName());
        System.out.println();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        // user.setAdmin();
        userRepositry.save(user);
        return "redirect:/singin";
    }

    @GetMapping("/user/{id}/editProfile")
    public String editProfile(@PathVariable(value = "id") Long id, Model model){
        User user = clientservicesImpl.getById(id);
        model.addAttribute("client", user);
        return "user/editprofile";
    }

    @GetMapping("/deleteclient/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        clientservicesImpl.deleteViaId(id);
        return "redirect:/";
 
    }
}