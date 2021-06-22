package edu.neu.finalproject.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.VaccineRequester;
import edu.neu.finalproject.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class PersonDAO extends DAO {

    public PersonDAO() {
    }

    public Person get(String username) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Person where firstName = :username");
            q.setString("username", username);
            Person user = (Person) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    public Boolean UserCheck(Person person) throws Exception{
    	
    	ArrayList<Person> users = new ArrayList();
    	Query q = getSession().createQuery("from Person");  	
    	users = (ArrayList<Person>)q.list();
    	
    	for(Person u:users){		
            if(person.getFirstName().equalsIgnoreCase(u.getFirstName())){
    		return false;
            }
    	}
    	return true;
    }
    
    public Person queryEmployeeByNameAndPassword(String firstName, String password) throws Exception {
	try {
			
            Query q = getSession().createQuery("from Person where firstName = :firstName and password = :password");
            q.setString("firstName", firstName);
            q.setString("password", password);
            
            Person userAccount = (Person) q.uniqueResult();
            if(userAccount==null){
            	System.out.println("no such user with " + firstName + " " + password);
            }
            close();
            return userAccount;
	} catch (HibernateException e) {		
            throw new Exception("Could not get user " + firstName, e);
	}	
    }

    public VaccineProvider createDonor(String firstName, String lastName, String password, String email, String gender, String age, String vaccine, String phoneNo, String address, String city) throws Exception {

        try {
            begin();
            
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            VaccineProvider vaccineProvider = (VaccineProvider) context.getBean("vaccineProvider");
            
            vaccineProvider.setFirstName(firstName);
            vaccineProvider.setLastName(lastName);
            vaccineProvider.setPassword(password);
            vaccineProvider.setEmail(email);
            vaccineProvider.setGender(gender);
            vaccineProvider.setAge(age);
            vaccineProvider.setVaccine(vaccine);
            vaccineProvider.setPhoneNumber(phoneNo);
            vaccineProvider.setAddress(address);
            vaccineProvider.setCity(city);
            vaccineProvider.setRole("donor");
            getSession().save(vaccineProvider);
            commit();
            return vaccineProvider;           
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while creating user" + e.getMessage());
        }
    }
	
    public VaccineProvider updateDonor(String firstName, String lastName, String password, String email, String gender, String age, String phoneNo, String address, String city, long personID) throws Exception {

        try {

            begin();
            Query query = getSession().createQuery("from VaccineProvider where personID =:personID");
            query.setString("personID", String.valueOf(personID));
            System.out.println("Vaccine Donor Person ID is" + personID);
            VaccineProvider provider = (VaccineProvider) query.uniqueResult();

            provider.setFirstName(firstName);
            provider.setLastName(lastName);
            provider.setPassword(password);
            provider.setEmail(email);
            provider.setGender(gender);
            provider.setAge(age);
            provider.setPhoneNumber(phoneNo);
            provider.setAddress(address);
            provider.setCity(city);
            provider.setRole("donor");

            getSession().update(provider);
            commit();

            return provider;
        } catch (HibernateException e) {
            rollback();
           throw new Exception("Exception while creating user" + e.getMessage());

        }

    }
	
    public VaccineRequester createRequester(String firstName, String lastName, String password, String email, String gender, String age, String requestedVaccine, String phoneNo, String requestedAddress, String requestedCity) throws Exception {

        try {

            begin();
            
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            VaccineRequester vaccineRequester = (VaccineRequester) context.getBean("vaccineRequester");

            vaccineRequester.setFirstName(firstName);
            vaccineRequester.setLastName(lastName);
            vaccineRequester.setPassword(password);
            vaccineRequester.setEmail(email);
            vaccineRequester.setGender(gender);
            vaccineRequester.setAge(age);
            vaccineRequester.setRequestedvaccines(requestedVaccine);
            vaccineRequester.setPhoneNumber(phoneNo);
            vaccineRequester.setRequestedAddress(requestedAddress);
            vaccineRequester.setRequestedCity(requestedCity);
            vaccineRequester.setRole("requester");
            getSession().save(vaccineRequester);
            commit();

            return vaccineRequester;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while updating donor" + e.getMessage());

        }

    }
     
    public VaccineRequester updateRequester(String firstName, String lastName, String password, String email, String gender, String age, String address, String city, String phoneNo, String requestedVaccine, long personID) throws Exception {

        try {

            begin();
            Query query = getSession().createQuery("from VaccineRequester where personID =:personID");
            query.setString("personID", String.valueOf(personID));
            
            VaccineRequester bd = (VaccineRequester) query.uniqueResult();

            bd.setFirstName(firstName);
            bd.setLastName(lastName);
            bd.setPassword(password);
            bd.setEmail(email);
            bd.setGender(gender);
            bd.setRequestedvaccines(requestedVaccine);
            bd.setAge(age);
            bd.setPhoneNumber(phoneNo);
            bd.setRequestedAddress(address);
            bd.setRequestedCity(city);
            bd.setRole("requester");

            getSession().update(bd);
            commit();

            return bd;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while updating requester" + e.getMessage());

        }

    }
}
