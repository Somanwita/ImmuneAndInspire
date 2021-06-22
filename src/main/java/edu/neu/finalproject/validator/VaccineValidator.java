/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.finalproject.validator;

import edu.neu.finalproject.pojo.Vaccine;
import edu.neu.finalproject.pojo.VaccineProvider;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author soman
 */

@Component
public class VaccineValidator implements Validator {
    
    @Override
    public boolean supports(Class aClass) {
        return aClass.equals(Vaccine.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        
        Vaccine vaccine = (Vaccine) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vaccineName", "error.invalid.vaccine", "Vacciine Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vaccinePrice", "error.invalid.vaccine", "Vaccine Price Required");
        
    }
    
}
