package com.udemy.springpetclinic.Bootstrap;

import Services.IOwnerService;
import Services.IPetTypeService;
import Services.IVetService;
import com.udemy.springpetclinic.Models.Owner;
import com.udemy.springpetclinic.Models.PetType;
import com.udemy.springpetclinic.Models.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final IOwnerService ownerService;
    private final IVetService vetService;
    private final IPetTypeService petTypeService;


    public DataLoader(IOwnerService ownerService, IVetService vetService, IPetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        try{

            PetType dog = new PetType("Dog");
            PetType savedDogPetType = petTypeService.save(dog);

            PetType cat = new PetType("Cat");
            PetType savedCatPetType = petTypeService.save(cat);

            Owner owner1 = new Owner("Michael","Weston");
            ownerService.save(owner1);

            Owner owner2 = new Owner("Fiona","Glenanne");
            ownerService.save(owner2);

            System.out.println("Loaded Owners....");

            Vet vet1 = new Vet("Sam","Axe");
            vetService.save(vet1);

            Vet vet2 = new Vet("Jessie","Porter ");
            vetService.save(vet2);

            System.out.println("Loaded Vets....");


        }catch (Exception e){

            throw new Exception(e);
        }
    }
}
