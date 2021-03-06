package com.udemy.springpetclinic.Controllers;

import com.udemy.springpetclinic.Models.Owner;
import com.udemy.springpetclinic.Services.IOwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/owners") //Instead of RequestMapping on Method with 'owners' before everything, you can describe the initial route here
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private final IOwnerService ownerService;

    public OwnerController(IOwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

//    @RequestMapping({"","/","/index","/index.html"})
//    public String listOwners(Model model){
//
//        model.addAttribute("owners", ownerService.findAll());
//
//        return "owners/index";
//    }

    @RequestMapping({"/find","/find.html"})
    public String findOwners(Model model){

        model.addAttribute("owner", Owner.builder().build());

        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){

        //Allow parameterless GET request for /owners to return all records
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        //find owners by lastname
        List<Owner> results = ownerService.findAllByLastNameLike('%'+owner.getLastName()+'%');

        if(results.isEmpty()){
            //no owners found
            result.rejectValue("lastName", "notFound", "Not Found");
            return "owners/findOwners";
        }else if(results.size() == 1){
            //1 owner found
            owner = results.get(0);
            return "redirect:/owners/"+ owner.getId();
        } else{
            //multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){

        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner", new Owner());

        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){

        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
            var savedOwner = ownerService.save(owner);
            return "redirect:/owners/"+savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model){

        var owner = ownerService.findById(ownerId);
        model.addAttribute(owner);

        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId){
        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }else{
            owner.setId(ownerId);
            var savedOwner = ownerService.save(owner);

            return "redirect:/owners/" +savedOwner.getId();
        }
    }
}
