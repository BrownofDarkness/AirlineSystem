package com.tp_3055.system.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User{

    @OneToMany(mappedBy = "Client", cascade = CascadeType.ALL)
    private Set<Reservation> Reservations = new HashSet<>();

    public Client(){
        super();
    }

    public Client(String username, String firstName, String lastName, String email, int phoneNumber) {
        super(username, firstName,lastName,email, phoneNumber);
    }
}