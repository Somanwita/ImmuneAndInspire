package edu.neu.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.validator.LoginValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginPageController {

    @Autowired
    @Qualifier("loginValidator")
    LoginValidator validatorL;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validatorL);
    }

    @RequestMapping(value = "/loginpage.htm", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("person") Person person, Model model,  BindingResult result, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
        validatorL.validate(person, result);
        if (result.hasErrors()) {
            return "login";
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        PersonDAO personDao = (PersonDAO) context.getBean("personDao");
        
        try {
            HttpSession s1 = request.getSession();
            Person userAccount = personDao.queryEmployeeByNameAndPassword(person.getFirstName(), person.getPassword());
            if (userAccount.getRole().equalsIgnoreCase("donor")) {
                
                s1.setAttribute("donorsession", userAccount);
                return "donorhome";
            } else if (userAccount.getRole().equalsIgnoreCase("requester")) {   
                s1.setAttribute("requestersession", userAccount);
                return "requesterhome";
            }

        } catch (Exception e) {
            model.addAttribute("error", "true");
            return "login";
        }

        model.addAttribute("error", "true");
        return "login";
    }
}
