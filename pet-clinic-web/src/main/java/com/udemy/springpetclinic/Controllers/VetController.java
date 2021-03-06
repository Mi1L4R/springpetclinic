package com.udemy.springpetclinic.Controllers;

import com.udemy.springpetclinic.Services.IVetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vets","/vets.html"})
public class VetController {

    private final IVetService vetService;

    public VetController(IVetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"","/index","/index.html"})
    public String listVets(Model model){

        model.addAttribute("vets",vetService.findAll());

        return "vets/index";
    }
}
