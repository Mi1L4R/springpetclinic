package Services;


import com.udemy.springpetclinic.Models.Pet;

import java.util.Set;

public interface IPetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
