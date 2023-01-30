package com.tp_3055.system.model;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

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
    private String departCountry,departTown, arivalCountry,arivalTown,status;
    private Double price;
    private int totalseats;

    @OneToMany(mappedBy = "flight")
    private Set<Reservation> reservations = new HashSet<>();


    public Flight(LocalTime hour, String departCountry, String departTown, String arivalCountry, String arivalTown, Double price, int totalseats) {
        this.hour = hour;
        this.departCountry = departCountry;
        this.arivalCountry = arivalCountry;
        this.departCountry = departTown;
        this.arivalCountry = arivalTown;
        this.price = price;
        this.totalseats = totalseats;
        this.status = "in_progress";
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

    public String getDepartCountry() {
        return departCountry;
    }

    public void setDepart(String depart) {
        this.departCountry = depart;
    }

    public String getDepartTown() {
        return departTown;
    }

    public void setDepartTown(String depart) {
        this.departTown = depart;
    }

    public String getArivalCountry() {
        return arivalCountry;
    }

    public void setArivalCountry(String arival) {
        this.arivalCountry = arival;
    }

    public String getArivalTown() {
        return arivalTown;
    }

    public void setArivalTown(String arival) {
        this.arivalTown = arival;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
    
}