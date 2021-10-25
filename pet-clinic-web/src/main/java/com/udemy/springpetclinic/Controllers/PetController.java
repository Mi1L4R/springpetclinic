package com.udemy.springpetclinic.Controllers;

import com.udemy.springpetclinic.Models.Owner;
import com.udemy.springpetclinic.Models.Pet;
import com.udemy.springpetclinic.Models.PetType;
import com.udemy.springpetclinic.Services.IOwnerService;
import com.udemy.springpetclinic.Services.IPetService;
import com.udemy.springpetclinic.Services.IPetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RequestMapping("/owners/{ownerId}/pets")
@Controller
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM ="pets/createOrUpdatePetForm";

    private final IPetService petService;
    private final IOwnerService ownerService;
    private final IPetTypeService petTypeService;

    public PetController(IPetService petService, IOwnerService ownerService, IPetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll() ;
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/new")
    public String initCreationForm(Owner owner, Model model){
        var pet = new Pet();
        owner.getPets().add(pet);
        pet.setOwner(owner);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult bindingResult, Model model){

        if(StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
            bindingResult.rejectValue("name","duplicate","already exists");
        }

        owner.getPets().add(pet);
        pet.setOwner(owner);


        if(bindingResult.hasErrors()){
            model.addAttribute("pet",pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }else{
            var savedPet = petService.save(pet);
            return "redirect:/owners/"+savedPet.getOwner().getId();
        }
    }

    @GetMapping("/{petId}/edit")
    public String initUpdateForm(@PathVariable Long petId, Model model){

        var pet = petService.findById(petId);
        model.addAttribute("pet", pet);

        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model){

        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }else {
            owner.getPets().add(pet);
            var savedPet = petService.save(pet);

            return "redirect:/owners/"+ savedPet.getOwner().getId();
        }
    }
}
