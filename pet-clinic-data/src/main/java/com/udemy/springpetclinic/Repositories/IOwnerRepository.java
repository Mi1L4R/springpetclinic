package com.udemy.springpetclinic.Repositories;


import com.udemy.springpetclinic.Models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
