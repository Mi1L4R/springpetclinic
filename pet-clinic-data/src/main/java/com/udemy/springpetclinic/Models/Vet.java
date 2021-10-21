package com.udemy.springpetclinic.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Xvet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

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
