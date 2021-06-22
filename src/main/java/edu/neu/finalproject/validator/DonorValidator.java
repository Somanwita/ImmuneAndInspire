package edu.neu.finalproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.neu.finalproject.pojo.VaccineProvider;

@Component
public class DonorValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {
        return aClass.equals(VaccineProvider.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        VaccineProvider user = (VaccineProvider) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "error.invalid.user", "Gender Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "error.invalid.user", "Age Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vaccine", "error.invalid.user", "Vaccine Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.user", "Phone Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "error.invalid.user", "Address Required");

    }

}
