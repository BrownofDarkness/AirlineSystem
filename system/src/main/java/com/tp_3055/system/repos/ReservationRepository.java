package com.tp_3055.system.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp_3055.system.model.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation , Long>{

    
}
