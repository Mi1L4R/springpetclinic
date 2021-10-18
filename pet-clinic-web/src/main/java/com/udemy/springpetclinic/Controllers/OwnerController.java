package com.udemy.springpetclinic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") //Instead of RequestMapping on Method with 'owners' before everything, you can describe the initial route here
@Controller
public class OwnerController {

    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(){

        return "owners/index";
    }
}
