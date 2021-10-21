package com.udemy.springpetclinic.Bootstrap;

import com.udemy.springpetclinic.Models.*;
import com.udemy.springpetclinic.Services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final IOwnerService ownerService;
    private final IVetService vetService;
    private final IPetTypeService petTypeService;
    private final ISpecialityService specialityService;
    private final IVisitService visitService;


    public DataLoader(IOwnerService ownerService, IVetService vetService, IPetTypeService petTypeService, ISpecialityService specialityService, IVisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        try {

            if(petTypeService.findAll().size() == 0){
                loadData();
            }


        } catch (Exception e) {

            throw new Exception(e);
        }
    }

    private void loadData() {
        PetType dog = new PetType("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner("Michael", "Weston", "123 Brickerel", "Miami", "0111234567");

        Pet mikesPet = new Pet(savedDogPetType, owner1, LocalDate.now(), "Rosco");
        

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);


        Owner owner2 = new Owner("Fiona", "Glenanne", "123 Brickerel", "Miami", "0111234567");
        Pet fionasPet = new Pet(savedCatPetType, owner2, LocalDate.now(), "JustCat");
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);


        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);



        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
