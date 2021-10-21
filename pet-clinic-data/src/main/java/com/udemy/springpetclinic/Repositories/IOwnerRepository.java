package com.udemy.springpetclinic.Repositories;


import com.udemy.springpetclinic.Models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public interface IOwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
