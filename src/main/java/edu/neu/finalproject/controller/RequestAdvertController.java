package edu.neu.finalproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.finalproject.dao.RequestDAO;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.pojo.RequestAdvert;

@Controller
public class RequestAdvertController {

    @RequestMapping(value = "/postrequest.htm", method = RequestMethod.POST)
    public String register(@ModelAttribute("makerequest") RequestAdvert requestAdvert, RequestDAO requestDao, Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        
        if (request.getAttribute("unsafe_request") == "true") {
           return "securityerror";
        }
        try {
            
            VaccineRequester br = (VaccineRequester) session.getAttribute("requestersession");
            String userName = br.getFirstName();
            requestDao.create(requestAdvert.getState(), requestAdvert.getCity(), requestAdvert.getVaccine(), requestAdvert.getMessage(), userName);
        } catch (NumberFormatException e) {
            return "error";
            //e.printStackTrace();
        } catch (Exception e) {
            return "error";
            //e.printStackTrace();
        }     
        return "success1";
    }

    @RequestMapping(value = "/viewallvaccinerequest.htm", method = RequestMethod.GET)
    public String viewallvaccinerequest(@ModelAttribute("viewallvaccinerequest") VaccineRequester Requester, RequestDAO requestDao, Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        VaccineProvider jb = (VaccineProvider) session.getAttribute("donorsession");     
        RequestDAO persondao = null;
        
        List empList = null;
        List jobList = new ArrayList();
       
        List<RequestAdvert> jList = new ArrayList<RequestAdvert>();
        List<AcceptedRequests> jalist = new ArrayList<AcceptedRequests>();
        List<AcceptedRequests> jblist = new ArrayList<AcceptedRequests>();

        try {   
            empList = requestDao.list();
            Iterator empIterator = empList.iterator();
            while (empIterator.hasNext()) {
                VaccineRequester employer = (VaccineRequester) empIterator.next();
                Iterator jobIterator = employer.getAdverts().iterator();
                while (jobIterator.hasNext()) {
                    RequestAdvert job = (RequestAdvert) jobIterator.next();
                    jobList.add(job);
                    jList.add(job);
                }
            }
                    
            List<AcceptedRequests> jobsApp = new ArrayList<AcceptedRequests>();
            jobsApp = requestDao.getApplied(jb.getPersonID());

            Iterator appJob = jobsApp.iterator();
            while (appJob.hasNext()) {
                AcceptedRequests jba = (AcceptedRequests) appJob.next();
                jblist.add(jba);
            }
          
            Iterator<RequestAdvert> jbI = jList.iterator();
            while (jbI.hasNext()) {
                RequestAdvert jb1 = jbI.next();
                for (AcceptedRequests ja : jblist) {              
                    if (jb1.getAdvertid() == ja.getRequestAdvert().getAdvertid()) {
                        jbI.remove();
                    }
                }
            }
            model.addAttribute("requestadvList", jList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "viewallvaccinerequest";
    }

}
