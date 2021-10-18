package Services.MapImplementation;

import Services.ICRUDService;
import com.udemy.springpetclinic.Models.Owner;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements ICRUDService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {

        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {

        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
