package edu.neu.finalproject.controller;

import edu.neu.finalproject.dao.AcceptedRequestDAO;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.dao.RequestDAO;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.pojo.RequestAdvert;
import edu.neu.finalproject.pojo.Vaccine;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class DonorController {

    private static final Logger logger = LoggerFactory.getLogger(DonorController.class);
    
    @RequestMapping("/findadonor.htm")
    public String findadonorview(@ModelAttribute("person") Person person) {
        return "findadonor";
    }

    @RequestMapping("/makearequest.htm")
    public String makearequestview(@ModelAttribute("person") Person person) {
        return "makearequest";
    }

    @RequestMapping(value = "/donorprofile.htm")
    public String donorprofile(@ModelAttribute("person") Person person, Model model, BindingResult result, RequestDAO requestDao, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        
        VaccineProvider vp = (VaccineProvider) request.getSession().getAttribute("donorsession");
        long userId = vp.getPersonID();
        vp = requestDao.getPersonDet1(userId);
        model.addAttribute("updateSta", vp);
        return "donorprofile";
    }

    @RequestMapping(value = "/donorReq.htm")
    public String donorreq(@ModelAttribute("donor") VaccineProvider donor, Model model, BindingResult result, RequestDAO requestDao, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
           
            VaccineProvider vp = (VaccineProvider) session.getAttribute("donorsession");
            long id = vp.getPersonID();
                        
            List<AcceptedRequests> emerRequ = new ArrayList<>(requestDao.getListOfMyAdverts(id));
            Iterator<AcceptedRequests> jobIterator = emerRequ.iterator();
            List<AcceptedRequests> jobList = new ArrayList<AcceptedRequests>();
            while (jobIterator.hasNext()) {
                AcceptedRequests jobs = (AcceptedRequests) jobIterator.next();
                jobList.add(jobs);
            }
    
            model.addAttribute("emerRequ", jobList);
        } catch (Exception e) {
            return "error";
        }
        return "donorReq";
    }


    @RequestMapping(value = "/showrequests.htm", method = RequestMethod.POST)
    public String register(@ModelAttribute("showrequest") RequestAdvert requestAdvert, BindingResult result, RequestDAO requestDao,HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            
            VaccineRequester vp = (VaccineRequester) session.getAttribute("donorsession");
            String userName = vp.getFirstName();
            requestDao.create(requestAdvert.getState(), requestAdvert.getCity(), requestAdvert.getVaccine(), requestAdvert.getMessage(), userName);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return "error";
        } catch (Exception e) {
            //e.printStackTrace();
            return "error";
        }
        return "success";
    }
    
    @RequestMapping(value = "/updatestatus/{ARId}", method = RequestMethod.GET)
    public String updatePage(@PathVariable("ARId") long arid, Model model, AcceptedRequestDAO acceptedRequestDAO,
        HttpSession session, HttpServletResponse response) throws AdException {
        try {
            
            AcceptedRequests arq = acceptedRequestDAO.getRequestByARId(arid);
            model.addAttribute("updateSt", arq);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "error";
        }

        return "UpdateStatus";
    }
    
    @RequestMapping(value = "/updateSta/{ARId}", method = RequestMethod.GET)
    protected String doSubmitAction(@RequestParam("Status") String status, @PathVariable("ARId") String ARId, AcceptedRequestDAO acceptedRequestDAO, HttpSession session) throws Exception {
        try {           
            Long ai = Long.parseLong(ARId);
            acceptedRequestDAO.updatestatus(ai, status);
        } catch (Exception e) {
            e.printStackTrace();
            return "servererror";
        }
        return "success2";
    }

}
