package com.tp_3055.system.model;

// import java.time.LocalDate;

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
    private Long id;


    private String type;
    @Column(nullable = false, length = 15)
    private String dateCreation;

    @Column(length = 15)
    private String dateExpiration;

    @ManyToOne
    @JoinColumn(name = "fligh_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    public Reservation() {
        
    }

    public Reservation(String type, String dateCreation) {
        this.type = type;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String ateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String date) {
        this.dateExpiration = date;
    }

    public void setDateCreation(String date) {
        this.dateCreation = date;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getClient() {
        return user;
    }

    public void setClient(User client) {
        this.user= client;
    }
}

