package com.udemy.springpetclinic.Services;

import java.util.Set;

public interface ICRUDService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
