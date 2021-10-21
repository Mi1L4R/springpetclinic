package com.udemy.springpetclinic.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType PetType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner Owner;

    @Column(name = "birth_date")
    private LocalDate BirthDate;

    @Column(name = "name")
    private String name;

    public Pet() {
    }

    public Pet(PetType petType, Owner owner, LocalDate birthDate, String name) {
        PetType = petType;
        Owner = owner;
        BirthDate = birthDate;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
