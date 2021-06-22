package edu.neu.finalproject.pojo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.HibernateException;
import org.hibernate.Query;


@Entity
@Table(name="VaccineRequester")
@PrimaryKeyJoinColumn(name="personID", referencedColumnName = "personid")
public class VaccineRequester extends Person {

    @Column(name = "requestedvaccines")
    private String requestedvaccines;

    @Column(name = "requestedAddress")
    private String requestedAddress;
    
    @Column(name="requestedCity")
    private String requestedCity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "requester")
    private Set<RequestAdvert> adverts = new HashSet<RequestAdvert>();

    public String getRequestedvaccines() {
        return requestedvaccines;
    }

    public void setRequestedvaccines(String requestedvaccines) {
        this.requestedvaccines = requestedvaccines;
    }

    public Set<RequestAdvert> getAdverts() {
        return adverts;
    }

    public void setAdverts(Set<RequestAdvert> adverts) {
        this.adverts = adverts;
    }

    public String getRequestedAddress() {
        return requestedAddress;
    }

    public void setRequestedAddress(String requestedAddress) {
        this.requestedAddress = requestedAddress;
    }

    public String getRequestedCity() {
        return requestedCity;
    }

    public void setRequestedCity(String requestedCity) {
        this.requestedCity = requestedCity;
    }
    
    

}
