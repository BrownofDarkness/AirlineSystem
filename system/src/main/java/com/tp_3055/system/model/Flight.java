package com.tp_3055.system.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String hour;
    private String departCountry;
    private String departTown;
    private String arivalCountry;
    private String arivalTown;
    private String status;
    private Double price;
    private int totalseats;


    public Flight(String hour, String departCountry, String departTown, String arivalCountry, String arivalTown, Double price, int totalseats,String status) {
        this.hour = hour;
        this.departCountry = departCountry;
        this.arivalCountry = arivalCountry;
        this.departTown = departTown;
        this.arivalTown = arivalTown;
        this.price = price;
        this.totalseats = totalseats;
        if (status!=null) {
            this.status = status;
        } else {
            this.status = "in progress";
        }
    }

    public Flight() {
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartCountry() {
        return departCountry;
    }

    public void setDepartCountry(String depart) {
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

    public void setTotalseats(int seat) {
        this.totalseats = seat;
    }

    public void setStatus(String status) {
        if (status!=null) {
            this.status = status;
        } else {
            this.status = "in progress";
        }
       
    }

    public String getStatus() {
        return status;
    }

       
    
}