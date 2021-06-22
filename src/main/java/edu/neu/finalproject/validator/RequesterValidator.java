package edu.neu.finalproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.neu.finalproject.pojo.VaccineRequester;

@Component
public class RequesterValidator implements Validator  {

    @Override
    public boolean supports(Class aClass)
    {
        return aClass.equals(VaccineRequester.class);
    }
    
    @Override
    public void validate(Object obj, Errors errors)
    {
    	VaccineRequester userR = (VaccineRequester) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.userR", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.userR", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.userR", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.userR", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.userR", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.invalid.userR", "Age Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestedvaccines", "error.invalid.userR", "Vaccine Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.userR", "Phone Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestedAddress", "error.invalid.userR", "Address Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "requestedCity", "error.invalid.userR", "City Required");
    }
}
