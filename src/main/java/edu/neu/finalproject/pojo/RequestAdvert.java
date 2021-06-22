package edu.neu.finalproject.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class RequestAdvert {

    @Id
    @GeneratedValue
    @Column(name = "advertid", unique = true, nullable = false)
    private long advertid;

    @OneToMany(mappedBy = "requestAdvert")
    private Set<AcceptedRequests> ar = new HashSet<AcceptedRequests>();

    @Column(name = "message")
    private String message;

    @Column(name = "dateposted")
    private Date dateposted;

    @Column(name="state")
    private String state;
    
    @Column(name="city")
    private String city;

    @Column(name = "vaccine")
    private String vaccine;

    @Transient
    private String postedBy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "personID")
    private VaccineRequester requester;

    public RequestAdvert() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public long getAdvertid() {
        return advertid;
    }

    public void setAdvertid(long advertid) {
        this.advertid = advertid;
    }

    public Set<AcceptedRequests> getAr() {
        return ar;
    }

    public void setAr(Set<AcceptedRequests> ar) {
        this.ar = ar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateposted() {
        return dateposted;
    }

    public void setDateposted(Date dateposted) {
        this.dateposted = dateposted;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public VaccineRequester getRequester() {
        return requester;
    }

    public void setRequester(VaccineRequester requester) {
        this.requester = requester;
    }

}
