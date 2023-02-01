package com.tp_3055.system.service;

import java.util.List;

import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.model.User;

public interface ReservationServices {
    List<Reservation> getAllYourreservations(User client);
    void save(Reservation reservation);
    Reservation getById(Long id);
    void deleteViaId(Long id);
}
