package com.udemy.springpetclinic.Models;

import java.util.Set;

public class Vet extends Person{

    private Set<Speciality> specialities;

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

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
