/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.PhaseFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Phase;
import model.Projet;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class PhasesProjetManager implements java.io.Serializable {

    private Projet projetAConsult = new Projet();
    @EJB
    private PhaseFacade pf = new PhaseFacade();
    private List<Phase> listphase;

    public String afficherPhases() {

        String s = "phasesProjet.xhtml";
        return s;
    }
    
    public void phasesDuProjet() {

        listphase=pf.retournerPhasesProjet(projetAConsult.getIdProjet());
       

    }

    //---------------------------------------------------------------------------------------
    public Projet getProjetAConsult() {
        return projetAConsult;
    }

    public void setProjetAConsult(Projet projetAConsult) {
        this.projetAConsult = projetAConsult;
    }

    public List<Phase> getListphase() {
        return listphase;
    }

    public void setListphase(List<Phase> listphase) {
        this.listphase = listphase;
    }
    
    

}
