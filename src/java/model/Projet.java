/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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
@Table(name="tb_Projet")
public class Projet implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idProjet;
    private String libelleProjet;
    private Date dateDebProjetPrevue;
    private Date dateFinProjetPrevue;
    private Date dateDebProjetEffective;
    private Date dateFinProjetEffective; 
    private String descriptionProjet;
    
    public Projet(){
        
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getLibelleProjet() {
        return libelleProjet;
    }

    public void setLibelleProjet(String libelleProjet) {
        this.libelleProjet = libelleProjet;
    }

    public Date getDateDebProjetPrevue() {
        return dateDebProjetPrevue;
    }

    public void setDateDebProjetPrevue(Date dateDebProjetPrevue) {
        this.dateDebProjetPrevue = dateDebProjetPrevue;
    }

    public Date getDateFinProjetPrevue() {
        return dateFinProjetPrevue;
    }

    public void setDateFinProjetPrevue(Date dateFinProjetPrevue) {
        this.dateFinProjetPrevue = dateFinProjetPrevue;
    }

    public Date getDateDebProjetEffective() {
        return dateDebProjetEffective;
    }

    public void setDateDebProjetEffective(Date dateDebProjetEffective) {
        this.dateDebProjetEffective = dateDebProjetEffective;
    }

    public Date getDateFinProjetEffective() {
        return dateFinProjetEffective;
    }

    public void setDateFinProjetEffective(Date dateFinProjetEffective) {
        this.dateFinProjetEffective = dateFinProjetEffective;
    }

   

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }
    
    
    
    
    
}
