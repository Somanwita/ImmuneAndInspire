package edu.neu.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import edu.neu.finalproject.validator.DonorUpdateValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class DonorUpdateController {

    @Autowired
    @Qualifier("userUValidator")
    DonorUpdateValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/updatedonorprofile.htm", method = RequestMethod.POST)
    public String updateDonor(@ModelAttribute("person") VaccineProvider donor, BindingResult result, Model model, HttpServletRequest request, HttpSession session) throws Exception { 

        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
         
        try {      
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            PersonDAO personDao = (PersonDAO) context.getBean("personDao");
            VaccineProvider b1 = (VaccineProvider) session.getAttribute("donorsession");
            personDao.updateDonor(donor.getFirstName(), donor.getLastName(), donor.getPassword(), donor.getEmail(), donor.getGender(),
                    donor.getAge(), donor.getPhoneNumber(), donor.getAddress(), donor.getCity(), b1.getPersonID());
            
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "donorupdatesucc";
    }
}