package com.tp_3055.system.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.tp_3055.system.model.Flight;
import org.springframework.data.jpa.repository.Query;

public interface FlightRepository extends JpaRepository <Flight , Long>{

    

    List<Flight> findByHourContaining(String departureTime);


    @Query("SELECT f FROM Flight f WHERE f.arivalCountry = ?1 order by f.price")
    List<Flight> searchByArivalCountryLikeIgnoreCase( String arrivalCountry);

    @Query("SELECT f FROM Flight f WHERE f.departCountry = ?1 order by f.price")
    List<Flight> searchByDepartCountryLikeIgnoreCase( String departureCountry);

    @Query("SELECT f FROM Flight f WHERE f.departTown = ?1 order by f.price")
    List<Flight> searchByDepartTownLikeIgnoreCase( String departureTown);

    @Query("SELECT f FROM Flight f WHERE f.arivalTown = ?1 order by f.price")
    List<Flight> searchByArivalTownLikeIgnoreCase( String arrivalTown);

    @Query("SELECT f FROM Flight f WHERE ?1 = ?2 order by f.price")
    List<Flight> searchByTag(String tag,  String query);










}
