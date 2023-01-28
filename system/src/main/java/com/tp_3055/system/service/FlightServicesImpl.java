package com.tp_3055.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp_3055.system.model.Flight;
import com.tp_3055.system.repos.FlightRepository;

public class FlightServicesImpl implements FlightServices {

    @Autowired private FlightRepository flightRepo;

    @Override
    public List<Flight> getAllClients()
    {
        return flightRepo.findAll();
    }

    @Override 
    public void save(Flight flight)
    {
        flightRepo.save(flight);
    }
 
    @Override 
    public Flight getById(Long id)
    {
        Optional<Flight> optional = flightRepo.findById(id);
        Flight flight = null;
        if (optional.isPresent())
            flight = optional.get();
        else
            throw new RuntimeException(
                "client not found for id : " + id);
        return flight;
    }
 
    @Override 
    public void deleteViaId(Long id)
    {
        flightRepo.deleteById(id);
    }
    
}
