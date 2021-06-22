package edu.neu.finalproject.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.validator.DonorValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller

public class DonorRegistrationController {

    @Autowired
    @Qualifier("donorValidator")

    DonorValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/donorregister.htm", method = RequestMethod.POST)
    public String addDonor(@ModelAttribute("donor") VaccineProvider donor, BindingResult result, Model model,  
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
        validator.validate(donor, result);
        if (result.hasErrors()) {
            return "donorregistration";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        PersonDAO personDao = (PersonDAO) context.getBean("personDao");

        try {
   
            Boolean isValid = personDao.UserCheck(donor);
            if (!isValid) {
                model.addAttribute("err", true);
                return "donorregistration";
            }
            personDao.createDonor(donor.getFirstName(), donor.getLastName(), donor.getPassword(), donor.getEmail(), donor.getGender(),
                    donor.getAge(), donor.getVaccine(), donor.getPhoneNumber(), donor.getAddress(), donor.getCity());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";

    }
    
}
