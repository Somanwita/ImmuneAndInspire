/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.finalproject.controller;

import edu.neu.finalproject.dao.VaccineDAO;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.pojo.Vaccine;
import edu.neu.finalproject.validator.LoginValidator;
import edu.neu.finalproject.validator.VaccineValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soman
 */

@Controller
public class AddVaccineController {
    
    @Autowired
    @Qualifier("vaccineValidator")
    VaccineValidator vaccineValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(vaccineValidator);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(DonorController.class);
    
    @RequestMapping("/addvaccine.htm")
    public String addvaccine(@ModelAttribute("vaccine")Vaccine vaccine, BindingResult result, HttpServletRequest request, Model model) {
        return "addvaccine";
    }
    
    @RequestMapping(value = "/addvaccine.htm", method = RequestMethod.POST)
    public String addvaccinedetails(@ModelAttribute("vaccine")Vaccine vaccine, BindingResult result,  Model model,  
                            HttpServletRequest request, HttpServletResponse response) {
        
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
        vaccineValidator.validate(vaccine, result);
        if (result.hasErrors()) {
            return "addvaccine";
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        VaccineDAO vaccineDAO = (VaccineDAO) context.getBean("vaccineDAO");  
        
        try {
            HttpSession session = request.getSession();    
            Person userAccount = (Person)session.getAttribute("donorsession");

            List<Vaccine> list = vaccineDAO.list();
            
            for (Vaccine vac : list) {
                if (vac.getVaccineName().equalsIgnoreCase(vaccine.getVaccineName())) {
                    return "error1";
                }
            }
            
            Vaccine v = vaccineDAO.addVaccine(vaccine.getVaccineName(), vaccine.getVaccinePrice(), userAccount.getPersonID());
            System.out.println(v.getVaccineName());
            //return "success3";
            
            
        } catch (Exception e) {
            model.addAttribute("error", "true");
            return "addvaccine";
        }

        return "success3";
    }
    
}
