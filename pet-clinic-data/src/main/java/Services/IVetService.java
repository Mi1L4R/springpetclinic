package Services;


import com.udemy.springpetclinic.Models.Vet;

import java.util.Set;

public interface IVetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
