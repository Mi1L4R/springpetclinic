package com.udemy.springpetclinic.Repositories;

import com.udemy.springpetclinic.Models.PetType;
import org.springframework.data.repository.CrudRepository;

public interface IPetTypeRepository  extends CrudRepository<PetType,Long> {
}
