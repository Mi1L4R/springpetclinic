package com.udemy.springpetclinic.Services;

import com.udemy.springpetclinic.Models.Owner;

import java.util.List;


public interface IOwnerService extends ICRUDService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
