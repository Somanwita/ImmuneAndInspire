package edu.neu.finalproject.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import edu.neu.finalproject.pojo.Person;

@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {
        return aClass.equals(Person.class);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Person userP = (Person) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.userP", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.userP", "Password Required");

    }
}
