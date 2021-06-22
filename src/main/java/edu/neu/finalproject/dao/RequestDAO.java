package edu.neu.finalproject.dao;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.RequestAdvert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequestDAO extends DAO {

    public RequestAdvert create(String state, String city, String vaccine, String message, String userName) throws AdException {
        try {
            begin();
            //RequestAdvert advert = new RequestAdvert();  
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            RequestAdvert requestAdvert = (RequestAdvert) context.getBean("requestAdvert");
            requestAdvert.setState(state);
            requestAdvert.setCity(city);
            requestAdvert.setVaccine(vaccine);
            requestAdvert.setMessage(message);
            requestAdvert.setDateposted(new Date());
            
            Query q = getSession().createQuery("from Person where firstName = :firstName");          
            q.setString("firstName", userName);
            VaccineRequester e1 = (VaccineRequester) q.uniqueResult();
            requestAdvert.setRequester(e1);
            getSession().save(requestAdvert);
            commit();
            return requestAdvert;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while creating advert: " + e.getMessage());
        }
    }

    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from VaccineRequester");
            q.setComment("--- Retrieve all VaccineRequester VaccineRequester --- ");
            List list = q.list();
            commit();
            return list;

        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new AdException("Could not get the Requests", e);

        }
    }


    public List<AcceptedRequests> getApplicant(long userId, long advertid) {

        List<AcceptedRequests> applicants = new ArrayList<AcceptedRequests>();
        try {
            begin();
            Query qu = getSession().createQuery("from AcceptedRequests where advertid=:advertid");
            qu.setComment("--- Retrieve all col from AcceptedRequests where adverid = " + advertid + " --- ");
            qu.setLong("advertid", advertid);
            applicants = qu.list();
            commit();

        } catch (Exception e) {
            rollback();
        }
        System.out.println(applicants);
        return applicants;
    }

    public List<RequestAdvert> getListOfAllAdverts(long id) {

        List<RequestAdvert> allEmp = new ArrayList<RequestAdvert>();
        try {
            begin();
            Query q = getSession().createQuery("from RequestAdvert where personID=:id");
            q.setComment("--- Retrieve all col from RequestAdvert where personID = " + id + " --- ");
            q.setLong("id", id);
            allEmp = q.list();
            commit();
            
        } catch (Exception e) {
            rollback();
        }
        return allEmp;

    }

    public List<AcceptedRequests> getListOfMyAdverts(long id) {

        List<AcceptedRequests> allEmp = new ArrayList<AcceptedRequests>();
        try {
            begin();
            Query q = getSession().createQuery("from AcceptedRequests where personID=:id");
            q.setComment("--- getListOfMyAdverts: Retrieve all col from AcceptedRequests where personID = " + id + " --- ");
            q.setLong("id", id);
            allEmp = q.list();
            System.out.println("allEmp");
            for (AcceptedRequests r : allEmp) {
                System.out.println(r.getARId() + " " + r.getStatus());
            }
            
            commit();
        } catch (Exception e) {
            rollback();
            System.out.println("Exception caught " + e.getMessage());
        }
        return allEmp;

    }

    public void deleteadonor(long advertid) {
        //AcceptedRequests ar = new AcceptedRequests();
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AcceptedRequests acceptedRequests = (AcceptedRequests) context.getBean("acceptedRequests");
        try {
            
            begin();   
            Query q1 = getSession().createQuery("delete from  AcceptedRequests where advertid = :advertid");
            q1.setLong("advertid", advertid);
            q1.executeUpdate();
            
            Query q = getSession().createQuery("delete from  RequestAdvert where advertid = :advertid");
            q.setLong("advertid", advertid);
            q.executeUpdate();
            commit();

        } catch (Exception e) {
            e.printStackTrace();
            rollback();
        }

    }

    public VaccineRequester getPersonDet(long id) {
        //VaccineRequester bd = new VaccineRequester();
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        VaccineRequester vaccineRequester = (VaccineRequester) context.getBean("vaccineRequester");
        begin();
        Query q = getSession().createQuery("from VaccineRequester where personID=:id");
        q.setComment("--- Retrieve all col from VaccineRequester where personID = " + id + " --- ");
        q.setLong("id", id);
        vaccineRequester = (VaccineRequester) q.uniqueResult();
        commit();
        return vaccineRequester;
    }

    public VaccineProvider getPersonDet1(long id) {
        
        //VaccineProvider bd = new VaccineProvider();
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        VaccineProvider vaccineProvider = (VaccineProvider) context.getBean("vaccineProvider");
        
        begin();
        Query q = getSession().createQuery("from VaccineProvider where personID=:id");
        q.setComment("--- Retrieve all col from VaccineProvider where personID = " + id + " --- ");
        q.setLong("id", id);
        vaccineProvider = (VaccineProvider) q.uniqueResult();
        commit();
        return vaccineProvider;
    }

    public List<AcceptedRequests> getApplied(long personID) {
        
        List<AcceptedRequests> jb = new ArrayList<AcceptedRequests>();
        try {
            begin();
            Query q = getSession().createQuery("from AcceptedRequests where personID=:personID");
            q.setComment("--- getApplied: Retrieve all col from AcceptedRequests where personID = " + personID + " --- ");
            q.setLong("personID", personID);
            jb = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
        }
        return jb;
    }
}
