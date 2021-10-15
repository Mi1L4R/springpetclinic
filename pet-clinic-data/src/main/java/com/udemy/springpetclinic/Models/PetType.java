package com.udemy.springpetclinic.Models;

public class PetType extends BaseEntity{

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
