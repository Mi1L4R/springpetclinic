package com.udemy.springpetclinic.Repositories;

import com.udemy.springpetclinic.Models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface ISpecialityRepository extends CrudRepository<Speciality, Long> {
}
