package edu.neu.finalproject.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.neu.finalproject.dao.AcceptedRequestDAO;
import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.dao.RequestDAO;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.pojo.RequestAdvert;
import edu.neu.finalproject.view.ConfirmationPdfView;
import java.io.IOException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequesterController {

    private static final Logger logger = LoggerFactory.getLogger(RequesterController.class);

    @RequestMapping(value = "viewmyreqReq.htm", method = RequestMethod.GET)
    public String viewallvaccinerequest(@ModelAttribute("viewallvaccinerequest") VaccineRequester Requester, RequestDAO requestDao, Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            
            VaccineRequester br = (VaccineRequester) session.getAttribute("requestersession");
            long id = br.getPersonID();
            List<RequestAdvert> allReq = requestDao.getListOfAllAdverts(id);
            model.addAttribute("allReq", allReq);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "viewmyreqReq1";

    }
    
    @RequestMapping(value = "viewadonor/{advertid}", method = RequestMethod.GET)
    public String ViewAJob(@PathVariable("advertid") long advertid, Model model, RequestDAO requestDao, HttpServletRequest req) {
        try {
            
            VaccineRequester br = (VaccineRequester) req.getSession().getAttribute("requestersession");
            long userId = br.getPersonID();
            List<AcceptedRequests> applicants = new ArrayList();
            applicants = requestDao.getApplicant(userId, advertid);            
            model.addAttribute("applicants", applicants);
            System.out.println(applicants);
            
            if (applicants.size() != 0) {
                System.out.println("If condition PASS");
                return "ViewADonorReq";
            } else {
                System.out.println("If condition FAIL");        
            } 
            return "noapplicants";
           
        } catch (Exception e) {
            System.out.println(e); 
            e.printStackTrace();
            return null;
        }
    }

    
    @RequestMapping(value = "deladonor/{advertid}", method = RequestMethod.GET)
    @ResponseBody
    public String DeleteARequest(@PathVariable("advertid") long advertid, Model model, RequestDAO requestDao, HttpServletRequest req) {
        try {
           
            requestDao.deleteadonor(advertid);
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    @RequestMapping(value="/downloadconfirmation/{ARId}.pdf", method = RequestMethod.POST)
    public ModelAndView submit(@PathVariable("ARId") long arid, HttpSession session, AcceptedRequestDAO acceptedRequestDAO, HttpServletResponse response, SessionStatus status) throws AdException, IOException {
        
        AcceptedRequests acceptedreq = null;
        try{
	   
           acceptedreq = acceptedRequestDAO.getRequestByARId(arid);  
           System.out.println("Sending to Confirmation PDF");
           System.out.println("Requested Vaccine " + acceptedreq.getRequestAdvert().getVaccine());
           System.out.println(acceptedreq.getARId() + " " + acceptedreq.getProvider().getFirstName() + " " + acceptedreq.getProvider().getLastName() + " " + acceptedreq.getDateaccepted());
	   
	}catch(Exception e){
           return new ModelAndView("noConfirmation","AcceptedRequests", acceptedreq);
	}      
        status.setComplete();
        return new ModelAndView(new ConfirmationPdfView(),"AcceptedRequests", acceptedreq);        
    }
   

    @RequestMapping(value = "/requesterprofile.htm")
    public String requesterprofile(@ModelAttribute("requester") VaccineRequester requester, RequestDAO requestDao, Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
     
        VaccineRequester br = (VaccineRequester) request.getSession().getAttribute("requestersession");
        long userId = br.getPersonID();
        br = requestDao.getPersonDet(userId);
        model.addAttribute("updateSt", br);
        return "requesterprofile";
    }

    @RequestMapping(value = "/viewreqprofile.htm")
    public String viewreqprofile(@ModelAttribute("requester") VaccineRequester requester, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        return "viewreqprofile";
    }

    @RequestMapping(value = "/requesterlogout.htm")
    public String showLogout(@ModelAttribute("Person") Person person, Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie firstName = new Cookie("firstName", "pass");
        Cookie password = new Cookie("password", "pass");
        firstName.setMaxAge(0);
        password.setMaxAge(0);
        response.addCookie(firstName);
        response.addCookie(password);
        return "logout";
    }
}
