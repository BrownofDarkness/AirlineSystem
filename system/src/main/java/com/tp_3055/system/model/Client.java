package com.tp_3055.system.model;

import javax.persistence.Entity;

@Entity
public class Client extends User{

    public Client(String username, String firstName, String lastName, String email, int phoneNumber) {
        super(username, firstName,lastName,email, phoneNumber);
    }
}