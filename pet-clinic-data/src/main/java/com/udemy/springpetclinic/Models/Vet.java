package com.udemy.springpetclinic.Models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Xvet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

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
