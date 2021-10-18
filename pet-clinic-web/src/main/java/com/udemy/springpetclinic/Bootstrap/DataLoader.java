package com.udemy.springpetclinic.Bootstrap;

import Services.IOwnerService;
import Services.IVetService;
import Services.MapImplementation.OwnerServiceMap;
import Services.MapImplementation.VetServiceMap;
import com.udemy.springpetclinic.Models.Owner;
import com.udemy.springpetclinic.Models.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final IOwnerService ownerService;
    private final IVetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        try{

            Owner owner1 = new Owner(1L,"Michael","Weston");
            ownerService.save(owner1);

            Owner owner2 = new Owner(2L,"Fiona","Glenanne");
            ownerService.save(owner2);

            System.out.println("Loaded Owners....");

            Vet vet1 = new Vet(1L, "Sam","Axe");
            vetService.save(vet1);

            Vet vet2 = new Vet(2L, "Jessie","Porter ");
            vetService.save(vet2);

            System.out.println("Loaded Vets....");


        }catch (Exception e){

            throw new Exception(e);
        }
    }
}
