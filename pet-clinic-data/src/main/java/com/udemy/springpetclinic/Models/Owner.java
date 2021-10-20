package com.udemy.springpetclinic.Models;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{

    private Set<Pet> pets = new HashSet<>();
    private String address;
    private String city;
    private String telephone;



    public Owner() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
