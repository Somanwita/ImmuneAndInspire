package edu.neu.finalproject.controller;

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

import edu.neu.finalproject.dao.PersonDAO;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.Person;
import edu.neu.finalproject.dao.RequestDAO;
import edu.neu.finalproject.pojo.RequestAdvert;

@Controller
public class LinksController {

    @RequestMapping("/signin.htm")
    public String signin(@ModelAttribute("person") Person person) {
        return "login";
    }

    @RequestMapping("/back.htm")
    public String back(@ModelAttribute("person") Person person) {
        return "makearequest";
    }

    @RequestMapping("/back1.htm")
    public String back1(@ModelAttribute("viewmyvaccinerequest") VaccineRequester Requester, RequestDAO requestDao,  Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
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

    @RequestMapping("/gobackapp.htm")
    public String gobackapp(@ModelAttribute("viewmyvaccinerequest") VaccineRequester Requester, RequestDAO requestDao, Model model, BindingResult result, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
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

    @RequestMapping("/reqhome.htm")
    public String reqhome(@ModelAttribute("person") Person person) {
        return "requesterhome";
    }

    @RequestMapping("/donorhome.htm")
    public String donorhome(@ModelAttribute("person") Person person) {
        return "donorhome";
    }

    @RequestMapping("/gobackreqhome.htm")
    public String gobackreqhome(@ModelAttribute("requester") VaccineRequester requester) {
        return "requesterhome";
    }

    @RequestMapping("/backlogin.htm")
    public String backlogin(@ModelAttribute("person") Person person) {
        return "login";
    }

    @RequestMapping("/loginf.htm")
    public String loginview(@ModelAttribute("person") Person person) {
        return "login";
    }

}
