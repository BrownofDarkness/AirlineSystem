package com.tp_3055.system.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.model.User;
import com.tp_3055.system.repos.FlightRepository;
import com.tp_3055.system.repos.ReservationRepository;
import com.tp_3055.system.repos.UserRepositry;

@Controller
public class AdminController {

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRespo;

    @GetMapping("/dashboard_admin{id}")
    public String dashboardAdmin(Principal principal,Model model,HttpServletRequest request,@PathVariable(value = "id") Long id){
        if (request.isUserInRole("ROLE_ADMIN")) {
            System.out.println();
            System.out.println("your are Admin");
            System.out.println();
        }
        else{
            return "redirect:/";
        }
        User user = this.getuser(id);
        model.addAttribute("user", user);
        Flight flight = new Flight();
        model.addAttribute("flight", flight);

        List<Flight> flights = flightRepository.findAll();
        if(flights.isEmpty()){
            flights = null;
        }
        model.addAttribute("flights", flights);

        List<Reservation> reservations = reservationRespo.findAll();
        if(reservations.isEmpty()){
            reservations = null;
        }
        model.addAttribute("reservations", reservations);

        List<User> clients = userRepositry.getClients(false);
        if(clients.isEmpty()){
            clients = null;
        }
        model.addAttribute("clients", clients);
        return "admin/adminpage";
    }

    public User getuser(Long id){
        Optional<User> optional = userRepositry.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException("user not found for id : " + id);
            
        return user;
    }

    @GetMapping("/editAdmin_{id}")
    public String editProfile(@PathVariable(value = "id") Long id, Model model,HttpServletRequest request){
        if (request.isUserInRole("ROLE_ADMIN")) {
            System.out.println();
            System.out.println("your are Admin");
            System.out.println();
        }
        else{
            return "redirect:/";
        }
        
        User user = this.getuser(id);
        model.addAttribute("user", user);
        return "admin/editprofile";
    }
    
}
