package com.tp_3055.system.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reservation {

    @EmbeddedId
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;


    private String type;
    private LocalDate dateCreation;
    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "fligh_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Reservation(String type) {
        this.type = type;
        this.dateCreation = LocalDate.now();
    }

    public Long getId() {
        return id;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client= client;
    }
}

