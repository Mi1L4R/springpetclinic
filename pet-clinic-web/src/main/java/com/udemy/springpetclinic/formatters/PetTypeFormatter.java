package com.udemy.springpetclinic.formatters;

import com.udemy.springpetclinic.Models.PetType;
import com.udemy.springpetclinic.Services.IPetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final IPetTypeService petTypeService;

    public PetTypeFormatter(IPetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {

        var findPetTypes = petTypeService.findAll();

        for (var petType : findPetTypes) {
            if (petType.getName().equals(text)) {
                return petType;
            }
        }

        throw new ParseException("Pet Type not found: " + text, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
