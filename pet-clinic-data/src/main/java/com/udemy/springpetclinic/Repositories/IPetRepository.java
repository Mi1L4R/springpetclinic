package com.udemy.springpetclinic.Repositories;

import com.udemy.springpetclinic.Models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface IPetRepository extends CrudRepository<Pet,Long> {
}
