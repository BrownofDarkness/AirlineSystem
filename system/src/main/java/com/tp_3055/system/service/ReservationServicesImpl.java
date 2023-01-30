package com.tp_3055.system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tp_3055.system.model.Client;
import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.repos.ReservationRepository;

public class ReservationServicesImpl implements ReservationServices{

    @Autowired
    private ReservationRepository reservationRepo;

    @Override
    public List<Reservation> getAllYourreservations(Client client)
    {
        return reservationRepo.findAll();
    }

    @Override 
    public void save(Reservation reservation)
    {
        reservationRepo.save(reservation);
    }
 
    @Override 
    public Reservation getById(Long id)
    {
        Optional<Reservation> optional = reservationRepo.findById(id);
        Reservation reservation = null;
        if (optional.isPresent())
            reservation = optional.get();
        else
            throw new RuntimeException(
                "reservation not found for id : " + id);
        return reservation;
    }
 
    @Override 
    public void deleteViaId(Long id)
    {
        reservationRepo.deleteById(id);
    }
}
