package com.udemy.springpetclinic.Services.MapImplementation;

import com.udemy.springpetclinic.Models.Speciality;
import com.udemy.springpetclinic.Models.Vet;
import com.udemy.springpetclinic.Services.ISpecialityService;
import com.udemy.springpetclinic.Services.IVetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements IVetService {

    private final ISpecialityService specialityService;

    public VetMapService(ISpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {

        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {

        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {

        return super.findById(id);
    }
}
