package edu.neu.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.finalproject.dao.AcceptedRequestDAO;
import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.VaccineProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class AcceptRequestController {
	@RequestMapping(value="acceptreq/{advertid}",method = RequestMethod.GET)
	public String initializeForm(@PathVariable("advertid") long advertid, AcceptedRequestDAO acceptedRequestDAO, HttpSession session, HttpServletRequest request) throws AdException {
		
            VaccineProvider bd = (VaccineProvider)session.getAttribute("donorsession");
	    long donorId = bd.getPersonID();
	   
	    acceptedRequestDAO.AcceptJobs(donorId,advertid);
	    return"viewallvaccinerequest";
	    
	}
}
