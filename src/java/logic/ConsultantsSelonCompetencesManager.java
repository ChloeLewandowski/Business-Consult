/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.CompetenceFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import model.Competence;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class ConsultantsSelonCompetencesManager implements java.io.Serializable {
    
    @ManagedProperty("#{param.codeCompetence}")
    private String codeCompetence;
    @EJB
    private CompetenceFacade cf= new CompetenceFacade();
    private Competence c= new Competence();
    private String descriptionCompetence;
    private String libelleCompetence;
    
     
   
    public void recupererCompetence(){
        
    c=cf.find(codeCompetence);
    
    
       
    
    }
//-------------------------------------------------------------------------------
    //getters and setters

    public String getCodeCompetence() {
        return codeCompetence;
    }

    public void setCodeCompetence(String codeCompetence) {
        this.codeCompetence = codeCompetence;
    }

    public Competence getC() {
        return c;
    }

    public void setC(Competence c) {
        this.c = c;
    }

    public String getDescriptionCompetence() {
        return descriptionCompetence;
    }

    public void setDescriptionCompetence(String descriptionCompetence) {
        this.descriptionCompetence = descriptionCompetence;
    }

    public String getLibelleCompetence() {
        return libelleCompetence;
    }

    public void setLibelleCompetence(String libelleCompetence) {
        this.libelleCompetence = libelleCompetence;
    }
    
    
    
  
}
