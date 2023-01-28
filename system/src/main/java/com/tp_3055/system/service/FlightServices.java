package com.tp_3055.system.service;

import java.util.List;

import com.tp_3055.system.model.Flight;

public interface FlightServices {
    List<Flight> getAllClients();
    void save(Flight flight);
    Flight getById(Long id);
    void deleteViaId(Long id);
}
