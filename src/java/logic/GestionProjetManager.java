/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ProjetFacade;
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
 @EJB
 private ProjetFacade pj= new ProjetFacade();

 
 @PostConstruct
 public void initPrjTab(){
     
     projectlist=pj.findAll();
     
 }
 

 //-----------------------------------------------------------------------------
    public List<Projet> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(List<Projet> projectlist) {
        this.projectlist = projectlist;
    }


    
 
 
    
}
