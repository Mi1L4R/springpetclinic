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
@Table(name = "owners")
public class Owner extends Person{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;


    public Owner(String firstName, String lastName){
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }

    public Owner(String firstName, String lastName, String address,String city, String telephone){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public Owner(Long id, String firstName, String lastName) {
        super.setId(id);
        super.setFirstName(firstName);
        super.setLastName(lastName);
    }


}
