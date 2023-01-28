package com.tp_3055.system.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String type;
    private LocalDate dateCreation;
    private LocalDate dateExpiration;

    public Reservation(Flight flight, String type) {
        this.flight = flight;
        this.type = type;
        this.dateCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate date) {
        this.dateExpiration = date;
    }
}

