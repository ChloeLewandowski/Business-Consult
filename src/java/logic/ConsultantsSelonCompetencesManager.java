/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.CompetenceFacade;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
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
 
    private Competence c= new Competence();
    private String descriptionCompetence;
    private String libelleCompetence;
    
     
   public String parametersAction(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        codeCompetence = params.get("codeCompetence");
        
        return "consultantsSelinCompetences.xhtml";
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

    
  
}
