/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ClientFacade;
import facade.ProjetFacade;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import model.Client;
import model.Projet;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class DashBoardManager implements Serializable {

    private List<Client> listeClt;
    private List<Projet> listeProjet;
    @EJB
    private ClientFacade cf;
    @EJB
    private ProjetFacade pf;
    private Client cltToDelete;
    private Integer projetsFinis=0;
    private Double tauxProjFinis;

    public DashBoardManager() {

    }

    //initialise les données utilisées sur la page d'accueil
   
    public void initTabs() {

        listeClt = cf.findAll();
        listeProjet = pf.findAll();
        projetsFinis=0;
        //parcours la liste des projets et compte ceux dont la date effective de fin est inférieure à la date du jour
        for (int i = 0; i < listeProjet.size(); i++) {
            if (listeProjet.get(i).getDateFinProjetEffective().getTime()
                    < (java.sql.Timestamp.valueOf(LocalDateTime.now())).getTime() ) {
                this.projetsFinis = projetsFinis + 1;
            }
        }
        
        //calcul le taux de projets terminés
        tauxProjFinis = ((double)projetsFinis / (double) listeProjet.size()) * 100;

    }


    
    

    //supprime le client en BDD puis de l'interface graphique en récupérant la ligne sélectionnée
    public String supprimerClient() {
     
        cf.remove(cltToDelete);
        listeClt.remove(cltToDelete);
        String s = "accueil.xhtml";
        return s;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
    
    public String afficherConsultants(){
       
        return "consultantsSelonCompetences.xhtml";
    }
    //--------------------------------------------------------------------------------------------------
    //getters et setters
    public List<Client> getListeClt() {
        return listeClt;
    }

    public void setListeClt(List<Client> listeClt) {
        this.listeClt = listeClt;
    }

    public List<Projet> getListeProjet() {
        return listeProjet;
    }

    public void setListeProjet(List<Projet> listeProjet) {
        this.listeProjet = listeProjet;
    }
    
    

    public Client getCltToDelete() {
        return cltToDelete;
    }

    public void setCltToDelete(Client cltToDelete) {
        this.cltToDelete = cltToDelete;
    }

    public Integer getProjetsFinis() {
        return projetsFinis;
    }

    public void setProjetsFinis(Integer projetsFinis) {
        this.projetsFinis = projetsFinis;
    }

    public Double getTauxProjFinis() {
        return tauxProjFinis;
    }

    public void setTauxProjFinis(Double tauxProjFinis) {
        this.tauxProjFinis = tauxProjFinis;
    }
    
    
    
    

}
