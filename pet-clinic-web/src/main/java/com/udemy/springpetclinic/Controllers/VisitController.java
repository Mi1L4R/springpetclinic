package com.udemy.springpetclinic.Controllers;

import com.udemy.springpetclinic.Models.Visit;
import com.udemy.springpetclinic.Services.IPetService;
import com.udemy.springpetclinic.Services.IVisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/owners/{ownerId}/pets/{petId}/visits")
public class VisitController {

    private static final String VIEW_VISITS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    private final IVisitService visitService;
    private final IPetService petService;

    public VisitController(IVisitService visitService, IPetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Called before each and every @RequestMapping annotated Method
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Pet object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param petId
     * @return Pet
     */

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable Long petId, Model model) {

        var visit = new Visit();
        var pet = petService.findById(petId);

        pet.getVisits().add(visit);
        visit.setPet(pet);

        model.addAttribute("pet", pet);

        return visit;

    }

    //Spring MVC calls method loadPetWithVisit(...) before below (because loadpet doesnt have request mapping)
    @GetMapping("/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model) {
        return VIEW_VISITS_CREATE_OR_UPDATE_FORM;
    }

    //Spring MVC calls method loadPetWithVisit(...) before below (because loadpet doesnt have request mapping)
    @PostMapping("/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result) {

        if(result.hasErrors()){
            return VIEW_VISITS_CREATE_OR_UPDATE_FORM;
        }else{
            var savedVisit = visitService.save(visit);
            return "redirect:/owners/"+savedVisit.getPet().getOwner().getId();
        }

    }
}
