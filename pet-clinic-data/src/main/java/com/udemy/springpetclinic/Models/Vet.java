package com.udemy.springpetclinic.Models;

public class Vet extends Person{
    public Vet() {
    }

    public Vet(String firstName, String lastName){
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Vet(Long id, String firstName, String lastName){
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }
}
