package com.udemy.springpetclinic.Models;

import java.time.LocalDate;

public class Pet {

    private PetType PetType;
    private Owner Owner;
    private LocalDate BirthDate;

    public com.udemy.springpetclinic.Models.PetType getPetType() {
        return PetType;
    }

    public void setPetType(com.udemy.springpetclinic.Models.PetType petType) {
        PetType = petType;
    }

    public com.udemy.springpetclinic.Models.Owner getOwner() {
        return Owner;
    }

    public void setOwner(com.udemy.springpetclinic.Models.Owner owner) {
        Owner = owner;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }
}
