package com.tp_3055.system.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User{

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations = new HashSet<>();

    public Client(){
        super();
    }

    public Client(String username, String firstName, String lastName, String email, int phoneNumber, String password) {
        super(username, firstName,lastName,email, phoneNumber,password);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    
}