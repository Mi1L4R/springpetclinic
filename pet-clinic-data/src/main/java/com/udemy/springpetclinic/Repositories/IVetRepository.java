package com.udemy.springpetclinic.Repositories;

import com.udemy.springpetclinic.Models.Vet;
import org.springframework.data.repository.CrudRepository;

public interface IVetRepository extends CrudRepository<Vet, Long> {
}
