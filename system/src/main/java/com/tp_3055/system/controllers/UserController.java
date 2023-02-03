package com.tp_3055.system.controllers;

import java.util.List;
import java.util.Optional;

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
import com.tp_3055.system.repos.ReservationRepository;
import com.tp_3055.system.repos.UserRepositry;
import com.tp_3055.system.service.UserServicesImpl;

@Controller
public class UserController {
    
    @Autowired(required = false)
    private UserServicesImpl clientservicesImpl;
    
    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRespo;


    @GetMapping("/register")
    public String singup(Model model){
        User user = new User() {};
        System.out.println();
        System.out.println(user.getIsAdmin());
        System.out.println();
        model.addAttribute("user", user);
        return "user/singupform";
    }

    @PostMapping("/saveUser")
    public String save(@ModelAttribute("user") User user){
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

    @GetMapping("/Profile_user{id}")
    public String getProfile(@PathVariable(value = "id") Long id,Model model){
        User user = this.getuser(id);
        model.addAttribute("user", user);
        List<Reservation> reservations = reservationRespo.getallYourReservations(user);
        if(reservations.isEmpty()){
            reservations = null;
        }
        model.addAttribute("reservs", reservations);
        return "user/userhome";
    }


    @PostMapping("/updateUser")
    public String updateflight(@ModelAttribute("user") User user){
        System.out.println();
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println();
        user.setId(user.getId());
        user.setUsername(user.getUsername());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(this.getuser(user.getId()).getPassword(), user.getPassword()) == false) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }else{
            user.setPassword(user.getPassword());
        }
        userRepositry.save(user);
        return "redirect:/";
    }

    @GetMapping("/editProfile_{id}")
    public String editProfile(@PathVariable(value = "id") Long id, Model model){
        User user = this.getuser(id);
        model.addAttribute("user", user);
        return "user/editprofile";
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

    public Flight getflight(Long id){
        Optional<Flight> optional = flightRepository.findById(id);
        Flight flight = null;
        if (optional.isPresent())
            flight = optional.get();
        else
            throw new RuntimeException("client not found for id : " + id);
            
        return flight;
    }


    @GetMapping("/deleteclient/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        clientservicesImpl.deleteViaId(id);
        return "redirect:/";
 
    }
}