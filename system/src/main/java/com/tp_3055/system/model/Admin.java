package com.tp_3055.system.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin(){
        super();
    }

    public Admin (String username, String firstName, String lastName, String email, int phoneNumber,String password) {
        super(username, firstName,lastName,email, phoneNumber, password);
    }
}