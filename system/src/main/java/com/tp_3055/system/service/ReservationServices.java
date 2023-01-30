package com.tp_3055.system.service;

import java.util.List;

import com.tp_3055.system.model.Client;
import com.tp_3055.system.model.Reservation;


public interface ReservationServices {
    List<Reservation> getAllYourreservations(Client client);
    void save(Reservation client);
    Reservation getById(Long id);
    void deleteViaId(Long id);
}
