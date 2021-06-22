/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.finalproject.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author soman
 */

@Entity
@Table(name="Vaccine")

public class Vaccine implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="vaccineID")
    private long vaccineID;
	
    @Column(name="vaccineName")
    private String vaccineName;
	
    @Column(name="vaccinePrice")
    private long vaccinePrice;
    
    @Column(name="personID")
    private long personID;

    public Vaccine() {
       
    }

    public long getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(long vaccineID) {
        this.vaccineID = vaccineID;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }
    
    

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public long getVaccinePrice() {
        return vaccinePrice;
    }

    public void setVaccinePrice(long vaccinePrice) {
        this.vaccinePrice = vaccinePrice;
    }
    
    

   
    
}
