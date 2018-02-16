/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
@Entity
@Table(name="tb_Phase")
public class Phase implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codePhase;
    private String LibellePhase;
    private String DescriptionPhase;
    private LocalDate dateDebutPhase;
    private LocalDate dateFinPhase;
    
    public Phase(){
        
    }

    public Integer getCodePhase() {
        return codePhase;
    }

    public void setCodePhase(Integer codePhase) {
        this.codePhase = codePhase;
    }

    public String getLibellePhase() {
        return LibellePhase;
    }

    public void setLibellePhase(String LibellePhase) {
        this.LibellePhase = LibellePhase;
    }

    public String getDescriptionPhase() {
        return DescriptionPhase;
    }

    public void setDescriptionPhase(String DescriptionPhase) {
        this.DescriptionPhase = DescriptionPhase;
    }

    public LocalDate getDateDebutPhase() {
        return dateDebutPhase;
    }

    public void setDateDebutPhase(LocalDate dateDebutPhase) {
        this.dateDebutPhase = dateDebutPhase;
    }

    public LocalDate getDateFinPhase() {
        return dateFinPhase;
    }

    public void setDateFinPhase(LocalDate dateFinPhase) {
        this.dateFinPhase = dateFinPhase;
    }
    
    
    
    
}
