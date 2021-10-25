package com.udemy.springpetclinic.Repositories;


import com.udemy.springpetclinic.Models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IOwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
