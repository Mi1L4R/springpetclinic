package Services.springdatajpa;

import Services.IOwnerService;
import com.udemy.springpetclinic.Models.Owner;
import com.udemy.springpetclinic.Repositories.IOwnerRepository;
import com.udemy.springpetclinic.Repositories.IPetRepository;
import com.udemy.springpetclinic.Repositories.IPetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements IOwnerService {
    private final IOwnerRepository ownerRepository;
    private final IPetRepository petRepository;
    private final IPetTypeRepository petTypeRepository;

    public OwnerSDJpaService(IOwnerRepository ownerRepository,
                             IPetRepository petRepository,
                             IPetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        // ownerRepository.findAll().forEach(owner -> owners.add(owner)); This line is the same as the one below it
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {


        /*
This is the same as the code below it
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()){
            return optionalOwner.get();
        }else {
            return null;
        }
*/

        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
