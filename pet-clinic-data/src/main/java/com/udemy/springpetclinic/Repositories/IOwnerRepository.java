package com.udemy.springpetclinic.Repositories;


import com.udemy.springpetclinic.Models.Owner;
import org.springframework.data.repository.CrudRepository;

public interface IOwnerRepository extends CrudRepository<Owner, Long> {
}
