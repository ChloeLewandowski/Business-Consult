/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name="tb_Competence")
public class Competence implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codeCompetence;
    private String libelleCompetence;
    private String descriptionCompetence; 
    
    public Competence(){
        
    }

    public int getCodeCompetence() {
        return codeCompetence;
    }

    public void setCodeCompetence(int codeCompetence) {
        this.codeCompetence = codeCompetence;
    }

    public String getLibelleCompetence() {
        return libelleCompetence;
    }

    public void setLibelleCompetence(String libelleCompetence) {
        this.libelleCompetence = libelleCompetence;
    }

    public String getDescriptionCompetence() {
        return descriptionCompetence;
    }

    public void setDescriptionCompetence(String descriptionCompetence) {
        this.descriptionCompetence = descriptionCompetence;
    }
    
    
    
}
