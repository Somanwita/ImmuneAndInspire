package edu.neu.finalproject.pojo;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table
@PrimaryKeyJoinColumn(name="personID", referencedColumnName = "personid")
public class VaccineProvider extends Person {
    
    public VaccineProvider() {

    }

    @OneToMany(mappedBy = "provider")
    private Set<AcceptedRequests> ar = new HashSet<AcceptedRequests>();

    @Column(name = "vaccine")
    private String vaccine;

    @Column(name = "address")
    private String address;
    
    @Column(name="city")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Set<AcceptedRequests> getAr() {
        return ar;
    }

    public void setAr(Set<AcceptedRequests> ar) {
        this.ar = ar;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
	
}
