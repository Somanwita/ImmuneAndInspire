package edu.neu.finalproject.controller;

import javax.servlet.http.HttpServletRequest;

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
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.validator.RequesterValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class RequesterRegistrationController {

    @Autowired
    @Qualifier("requesterValidator")
    RequesterValidator validatorR;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validatorR);
    }

    @RequestMapping(value = "/requesterregistration.htm", method = RequestMethod.POST)
    public String addRequester(@ModelAttribute("requester") VaccineRequester requester, BindingResult result, Model model, HttpServletRequest request)
            throws Exception {
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
        validatorR.validate(requester, result);
        if (result.hasErrors()) {
            return "requesterregistration";
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        PersonDAO personDao = (PersonDAO) context.getBean("personDao");
        try {
            
            Boolean isValid = personDao.UserCheck(requester);
            if (!isValid) {
                model.addAttribute("err", true);
                return "requesterregistration";
            }
            personDao.createRequester(requester.getFirstName(), requester.getLastName(), requester.getPassword(), requester.getEmail(), requester.getGender(),
                    requester.getAge(), requester.getRequestedvaccines(), requester.getPhoneNumber(), requester.getRequestedAddress(), requester.getRequestedCity());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            return "servererror";
        }
        return "success";
    }
}
