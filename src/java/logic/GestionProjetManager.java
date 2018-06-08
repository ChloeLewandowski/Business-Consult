/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ProjetFacade;
import java.sql.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Projet;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class GestionProjetManager implements java.io.Serializable{
    
 private List <Projet> projectlist;
 private Projet projToDelete;
 @EJB
 ProjetFacade pf= new ProjetFacade();

 
 @EJB
 private ProjetFacade pj= new ProjetFacade();
 

 
 public void initPrjTab(){
     
     projectlist=pj.findAll();
     
 }
 
 public String deleteProjet(){
     Projet proj=getProjToDelete();
     pf.remove(proj);
     projectlist.remove(proj);
     String s="projets.xhtml";
     return s;
 }
 

 //-----------------------------------------------------------------------------
    public List<Projet> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(List<Projet> projectlist) {
        this.projectlist = projectlist;
    }

    public Projet getProjToDelete() {
        return projToDelete;
    }

    public void setProjToDelete(Projet projToDelete) {
        this.projToDelete = projToDelete;
    }

    

    
 
 
    
}
