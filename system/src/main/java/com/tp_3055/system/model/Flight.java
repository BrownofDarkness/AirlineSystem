package com.tp_3055.system.model;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long id;

    private LocalTime hour;
    private String depart, arival;
    private Double price;

    @OneToMany(mappedBy = "Flight", cascade = CascadeType.ALL)
    private Set<Reservation> Reservations = new HashSet<>();

    public Flight(LocalTime hour, String depart, String arival, Double price) {
        this.hour = hour;
        this.depart = depart;
        this.arival = arival;
        this.price = price;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public Long getId() {
        return id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArival() {
        return arival;
    }

    public void setArival(String arival) {
        this.arival = arival;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}