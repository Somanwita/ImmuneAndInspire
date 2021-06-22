package edu.neu.finalproject.controller;

import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author soman
 */

@Controller
public class LoginController {
	
	@RequestMapping("/login.htm")	
	public String loginview(@ModelAttribute("person")Person person){		
		return "login";	
	}
	
	@RequestMapping("/donorregistration.htm")	
	public String DonorRegister(@ModelAttribute("donor")VaccineProvider donor,BindingResult result, HttpServletRequest request) {
    	
        return "donorregistration";
    }
	
	@RequestMapping("/requesterregistration.htm")	
	public String RequesterRegister(@ModelAttribute("requester")VaccineRequester requester, Model model, HttpServletRequest request) {
    	
        return "requesterregistration";
    }
	
	@RequestMapping("/requesterhome.htm")	
	public String Requesterhome(@ModelAttribute("requester")VaccineRequester requester,Model model,HttpServletRequest request) {
    	
        return "requesterhome";
    }
	
}

