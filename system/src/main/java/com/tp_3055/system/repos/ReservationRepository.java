package com.tp_3055.system.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tp_3055.system.model.Reservation;
import com.tp_3055.system.model.User;
import com.tp_3055.system.model.Flight;

public interface ReservationRepository extends JpaRepository <Reservation , Long>{
    @Query("SELECT r FROM Reservation r WHERE r.user = ?1")
    public List<Reservation> getallYourReservations(User user);

    @Query("SELECT r FROM Reservation r WHERE r.flight = ?1")
    public List<Reservation> getallFlightReservations(Flight user);

    
}
