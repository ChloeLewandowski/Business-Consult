/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ConsultantFacade;
import facade.PhaseFacade;
import java.util.Date;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.NoResultException;
import model.Consultant;
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
    @EJB
    private ConsultantFacade cf= new ConsultantFacade();
    private List<Phase> listphase;
    private String libellePhase;
    private String descriptionPhase;
    private Date dateDebutPhase;
    private Date dateFinPhase;
    private Consultant consultMana;
    private List<Consultant> consultManas;
    private Phase phaseSelec;
   
    

    public String afficherPhases() {

        String s = "phasesProjet.xhtml";
        return s;
    }
    
    //remplir la table des phases du projet
    public void phasesDuProjet() {

        listphase=pf.retournerPhasesProjet(projetAConsult.getIdProjet());
       
    }
    
    //effacer les infos saisies dans les champs du formulaire
      public void effacerInfosSaisies(){
        setLibellePhase(null);
        setDescriptionPhase(null);
        setDateDebutPhase(null);
        setDateFinPhase(null);
       
    }
     
    //ajout de la phase renseignée dans le formulaire
    public String ajouterPhase() {
        try{
        pf.insertPhase(libellePhase, descriptionPhase, dateDebutPhase, dateFinPhase, consultMana.getIdConsultant(), projetAConsult.getIdProjet());
        effacerInfosSaisies();
        return "phasesProjet.xhtml";
        }catch(NoResultException e){
            return null;
        }
    }
    
    //remplir le combo box des consultants pouvant manager la phase
    @PostConstruct
    public void displayConsultants() { 
        
        consultManas = cf.findAll();
        
    }
    
    //supprimer la phase selectionnée dans le tableau de la vue
    public void supprimerPhase(){
        pf.remove(phaseSelec);
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
    

    public String getLibellePhase() {
        return libellePhase;
    }

    public void setLibellePhase(String libellePhase) {
        this.libellePhase = libellePhase;
    }

    public String getDescriptionPhase() {
        return descriptionPhase;
    }

    public void setDescriptionPhase(String descriptionPhase) {
        this.descriptionPhase = descriptionPhase;
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

    public Consultant getConsultMana() {
        return consultMana;
    }

    public void setConsultMana(Consultant consultMana) {
        this.consultMana = consultMana;
    }

    public List getConsultManas() {
        return consultManas;
    }

    public void setConsultManas(List consultManas) {
        this.consultManas = consultManas;
    }

    public Phase getPhaseSelec() {
        return phaseSelec;
    }

    public void setPhaseSelec(Phase phaseSelec) {
        this.phaseSelec = phaseSelec;
    }
    
    

  
    
    
    

    

   
    
    
    
    

}
