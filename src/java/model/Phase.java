/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




import java.sql.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
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
    private Date dateDebutPhase;
    private Date dateFinPhase;
    @JoinColumn(name="idProjet")
    @ManyToOne(fetch=FetchType.LAZY)
    private Projet unProjet;
    @JoinColumn(name="idConsultant")
    @ManyToOne(fetch=FetchType.LAZY)
    private Consultant unConsultant;
   
    
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

    public Date getDateDebutPhase() {
        return dateDebutPhase;
    }

    public void setDateDebutPhase(Date dateDebutPhase) {
        this.dateDebutPhase = dateDebutPhase;
    }

    public Date getDateFinPhase() {
        return dateFinPhase;
    }

    public void setDateFinPhase(Date dateFinPhase) {
        this.dateFinPhase = dateFinPhase;
    }

    public Projet getUnProjet() {
        return unProjet;
    }

    public void setUnProjet(Projet unProjet) {
        this.unProjet = unProjet;
    }

    public Consultant getUnConsultant() {
        return unConsultant;
    }

    public void setUnConsultant(Consultant unConsultant) {
        this.unConsultant = unConsultant;
    }
    
    
    

 
    
    
    
    
    
}
