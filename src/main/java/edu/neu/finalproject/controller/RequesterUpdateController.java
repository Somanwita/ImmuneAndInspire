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
import edu.neu.finalproject.validator.RequesterUpdateValidator;
import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.pojo.VaccineRequester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class RequesterUpdateController {

    @Autowired
    @Qualifier("userRUValidator")
    RequesterUpdateValidator validatorR;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validatorR);
    }

    @RequestMapping(value = "/updaterequesterprofile.htm", method = RequestMethod.POST)
    public String updateRequester(@ModelAttribute("requester") VaccineRequester requester, BindingResult result, Model model, HttpServletRequest request, HttpSession session) throws Exception {
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            PersonDAO personDao = (PersonDAO) context.getBean("personDao");
            
            VaccineRequester br = (VaccineRequester) session.getAttribute("requestersession");
            long bd = requester.getPersonID();
            
            personDao.updateRequester(requester.getFirstName(), requester.getLastName(), requester.getPassword(), requester.getEmail(), requester.getGender(),
                    requester.getAge(), requester.getRequestedAddress(), requester.getRequestedCity(), requester.getPhoneNumber(), requester.getRequestedvaccines(), br.getPersonID());

            Person updatedPerson = personDao.get(requester.getFirstName());
            System.out.println(updatedPerson);
            session.setAttribute("requestersession", updatedPerson);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        
        return "requesterhome";
    }

}
