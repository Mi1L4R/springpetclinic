package com.udemy.springpetclinic.Repositories;

import com.udemy.springpetclinic.Models.Visit;
import org.springframework.data.repository.CrudRepository;

public interface IVisitRepository extends CrudRepository<Visit, Long> {
}
