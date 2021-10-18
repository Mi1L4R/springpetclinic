package com.udemy.springpetclinic.Models;

public class Owner extends Person{

    public Owner() {
    }

    public Owner(Long id, String firstName, String lastName) {
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }
}
