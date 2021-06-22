package edu.neu.finalproject.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AcceptedRequests")
public class AcceptedRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARId")
    private long ARId;

    @Column(name = "dateaccepted")
    private Date dateaccepted;

    @Column(name = "Status")
    private String Status;
    
    @Column(name = "estimatedcost")
    private long estimatedcost;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "personID")
    private VaccineProvider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertid")
    private RequestAdvert requestAdvert;

    public AcceptedRequests() {

    }

    public long getARId() {
        return ARId;
    }

    public void setARId(long ARId) {
        this.ARId = ARId;
    }

    public long getEstimatedcost() {
        return estimatedcost;
    }

    public void setEstimatedcost(long estimatedcost) {
        this.estimatedcost = estimatedcost;
    }

    public Date getDateaccepted() {
        return dateaccepted;
    }

    public void setDateaccepted(Date dateaccepted) {
        this.dateaccepted = dateaccepted;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public VaccineProvider getProvider() {
        return provider;
    }

    public void setProvider(VaccineProvider provider) {
        this.provider = provider;
    }

    public RequestAdvert getRequestAdvert() {
        return requestAdvert;
    }

    public void setRequestAdvert(RequestAdvert requestAdvert) {
        this.requestAdvert = requestAdvert;
    }
}
