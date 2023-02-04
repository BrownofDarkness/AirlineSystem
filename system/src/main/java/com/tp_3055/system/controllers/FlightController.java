package com.tp_3055.system.controllers;

import java.util.List;
import java.util.Optional;

import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.repos.FlightRepository;
import com.tp_3055.system.repos.ReservationRepository;
import com.tp_3055.system.service.FlightServicesImpl;

@Controller
public class FlightController {

    @Autowired(required = false)
    private FlightServicesImpl flightServicesImpl;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepo;


    @GetMapping("/createflight")
    public String newFlight(Model model){
        Flight flight = new Flight();
        System.out.println();
        System.out.println(flight.getStatus());
        System.out.println();
        model.addAttribute("flight", flight);
        return "flights/create";
    }

    @GetMapping("/flightplanning")
    public String flightPlanning(@RequestParam(required = false) String tag, @RequestParam(required = false) String query, Model model){
        List<Flight> flights = flightRepository.findAll();
        if(flights.isEmpty()){
            flights = null;
        }
       
        System.out.println();
        System.out.println(tag);
        System.out.println();
        System.out.println(query);
        System.out.println();

        String Tag = "f."+tag;
        List<Flight> flight = flightRepository.searchByTag(Tag,query);
        System.out.println();
        System.out.println(flight);
        System.out.println();
        if (tag == "arrivalCountry"){ 
            flights = flightRepository.searchByArivalCountryLikeIgnoreCase(query); 
            if(flights.isEmpty()){
                flights = null;
            }
        }
       
        if (tag == "departureCountry") {
            flights = flightRepository.searchByDepartCountryLikeIgnoreCase(query);
            if(flights.isEmpty()){
                flights = null;
            }
        }
        if (tag == "arrivalTown") {

            flights = flightRepository.searchByArivalTownLikeIgnoreCase(query);
            if(flights.isEmpty()){
                flights = null;
            }
        }

        if (tag == "departureTown") {
            flights = flightRepository.searchByDepartTownLikeIgnoreCase(query);
            if(flights.isEmpty()){
                flights = null;
            }
        }
        if (tag == "hour") {
            flights = flightRepository.findByHourContaining(query);
            if(flights.isEmpty()){
                flights = null;
            }
        }



        model.addAttribute("flights", flights);
        return "flights/planning";
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
        return "redirect:/";
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

    public Flight getflight(Long id){
        Optional<Flight> optional = flightRepository.findById(id);
        Flight flight = null;
        if (optional.isPresent())
            flight = optional.get();
        else
            throw new RuntimeException("client not found for id : " + id);
            
        return flight;
    }

    @GetMapping("/deleteflight/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        List<Reservation> reservations = reservationRepo.getallFlightReservations(this.getflight(id));
        if (reservations.isEmpty()==false){
            reservationRepo.deleteAll(reservations);
        }
        flightRepository.deleteById(id);
        return "redirect:/dashboard";
 
    }




}
