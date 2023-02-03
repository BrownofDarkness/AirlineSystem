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
import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.model.User;
import com.tp_3055.system.repos.FlightRepository;
import com.tp_3055.system.repos.ReservationRepository;
import com.tp_3055.system.repos.UserRepositry;

@Controller
public class ReservationController {

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRespo;

    @GetMapping("/reservation_flight{id}")
    public String getReservationView(Model model,@PathVariable(value = "id") Long id){
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        Flight flight = this.getflight(id);
        model.addAttribute("flight", flight);
        return "flights/reservation";
    }

    @PostMapping("/saveReservation_user{user}_flight{flight}")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation,@PathVariable(value = "user") Long user,@PathVariable(value = "flight") Long flight){
        System.out.println();
        System.out.println(reservation.getDateCreation());
        System.out.println();
        reservationRespo.save(reservation);
        reservation.setClient(this.getuser(user));
        reservation.setFlight(this.getflight(flight));
        reservationRespo.save(reservation);

        return "redirect:/";
    }

    @PostMapping("/updateReservation")
    public String saveReservation(@ModelAttribute("reserv") Reservation reservation){
        System.out.println();
        System.out.println(reservation.getDateCreation());
        System.out.println(reservation.getType());
        System.out.println();
        reservation.setId(reservation.getId());
        reservation.setType(reservation.getType());
        reservation.setDateCreation(reservation.getDateCreation());
        Reservation reserv = this.getreserv(reservation.getId());
        reservation.setClient(reserv.getClient());
        reservation.setFlight(reserv.getFlight());
        reservationRespo.save(reservation);

        return "redirect:/";
    }

    @GetMapping("/updateResview_{id}")
    public String saveReservation(@PathVariable(value = "id") Long id, Model model){
        Reservation reservation = this.getreserv(id);
        System.out.println();
        System.out.println(reservation.getDateCreation());
        System.out.println();
        model.addAttribute("reserv", reservation);

        return "flights/updaterev";
    }

    public Reservation getreserv(Long id){
        Optional<Reservation> optional = reservationRespo.findById(id);
        Reservation reservation = null;
        if (optional.isPresent())
            reservation = optional.get();
        else
            throw new RuntimeException("client not found for id : " + id);
            
        return reservation;
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
    
}
