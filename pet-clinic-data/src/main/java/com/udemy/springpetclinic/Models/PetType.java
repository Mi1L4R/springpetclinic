package com.udemy.springpetclinic.Models;

public class PetType extends BaseEntity{

    private String name;

    public PetType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
}
