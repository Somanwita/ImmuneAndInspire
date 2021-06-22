package edu.neu.finalproject.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import edu.neu.finalproject.exception.AdException;
import edu.neu.finalproject.pojo.AcceptedRequests;
import edu.neu.finalproject.pojo.VaccineProvider;
import edu.neu.finalproject.pojo.RequestAdvert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AcceptedRequestDAO extends DAO {

	public void AcceptJobs(long userId, long advertId){
            
            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
            AcceptedRequests acceptedRequests = (AcceptedRequests) context.getBean("acceptedRequests");
            try {
		begin();
		Query q=getSession().createQuery("from VaccineProvider where personID=:personID");
                q.setComment("--- Retreive all columns from VaccineProvider for the person id " + userId + " --- ");
		q.setLong("personID",userId);
                
		VaccineProvider bd=(VaccineProvider) q.uniqueResult();       
		Query query=getSession().createQuery("from RequestAdvert where advertid=:advertid");
                query.setComment("--- Retreive all columns from RequestAdvert for the advertid id " + advertId + " --- ");
		query.setLong("advertid",advertId);
                
		RequestAdvert ra = (RequestAdvert) query.uniqueResult();
                String reqVaccine = ra.getVaccine();
                
                VaccineDAO vaccineDAO = (VaccineDAO) context.getBean("vaccineDAO");
                long estimatecost = vaccineDAO.getVaccinePrice(reqVaccine);
                
		acceptedRequests.setStatus("Request Accepted");
		acceptedRequests.setRequestAdvert(ra);
                acceptedRequests.setDateaccepted(new Date());
		acceptedRequests.setProvider(bd);
                acceptedRequests.setEstimatedcost(estimatecost);
                
		getSession().save(acceptedRequests);

		commit();	
	}
	catch(Exception e){
		e.printStackTrace();
		rollback();
	}
  }
	
  public AcceptedRequests getRequestByARId(long ARId){
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AcceptedRequests acceptedRequests = (AcceptedRequests) context.getBean("acceptedRequests");
        
	try{
		begin();
		Query q=getSession().createQuery("from AcceptedRequests where ARId=:ARId");
                q.setComment("--- Retreive all columns from AcceptedRequests for the AR id " + ARId + " --- ");
		q.setLong("ARId",ARId);
		acceptedRequests=(AcceptedRequests) q.uniqueResult();
		commit();		
	}
	catch(Exception e){
		e.printStackTrace();
		rollback();
	}
	return acceptedRequests;

  }
  
  public AcceptedRequests updatestatus(long ARId, String Status){
      
	        
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        AcceptedRequests acceptedRequests = (AcceptedRequests) context.getBean("acceptedRequests");
	try{
		begin();
		Query q=getSession().createQuery("from AcceptedRequests where ARId=:ARId");
                q.setComment("--- Update status columns from AcceptedRequests for the AR id " + ARId + " --- ");
		q.setLong("ARId",ARId);
		acceptedRequests=(AcceptedRequests) q.uniqueResult();
		acceptedRequests.setStatus(Status);
                getSession().update(acceptedRequests);
		commit();
                
	}
	catch(Exception e){
		e.printStackTrace();
		rollback();
	}
	return acceptedRequests;

  }
}
