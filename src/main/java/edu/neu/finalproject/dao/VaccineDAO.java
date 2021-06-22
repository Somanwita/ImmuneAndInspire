/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.finalproject.dao;

import static edu.neu.finalproject.dao.DAO.getSession;
import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.Vaccine;
import edu.neu.finalproject.pojo.VaccineProvider;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author soman
 */
public class VaccineDAO extends DAO {
    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Vaccine");
            q.setComment("--- Retrieve all Vaccine from Vaccine --- ");
            List list = q.list();
            System.out.println(list);
            commit();
            return list;

        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            throw new AdException("Could not get the Requests", e);

        }
    }
    public long getVaccinePrice(String reqvaccine) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("select vaccinePrice from Vaccine where vaccineName=:vaccineName");
            q.setString("vaccineName", reqvaccine);
            q.setComment("--- Retrieve Vaccine Price --- ");
            long price = (long) q.uniqueResult();
            commit();
            return price;

        } catch (HibernateException e) {
            e.printStackTrace();
            rollback();
            //throw new AdException("Could not get the Requests", e);
            return 0;
        }
    }
        
    public Vaccine addVaccine(String vaccineName, long vaccinePrice, long personID) throws Exception {

        try {
            begin();

            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            Vaccine vaccine = (Vaccine) context.getBean("vaccine");
            vaccine.setVaccineName(vaccineName);
            vaccine.setVaccinePrice(vaccinePrice);
            vaccine.setPersonID(personID);
            
            getSession().save(vaccine);
            commit();
            return vaccine;           
        } catch (Exception e) {
            rollback();
            System.out.println(e);
            throw new Exception("Exception while creating user" + e.getMessage());
        }
    
    }
    
}
