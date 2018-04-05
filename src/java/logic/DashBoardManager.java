/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ClientFacade;
import facade.ProjetFacade;
import java.io.Serializable;
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

    public DashBoardManager() {

    }

    //initialise la table des clients présente en page d'accueil
    @PostConstruct
    public void initTabs() {

        listeClt = cf.findAll();
        listeProjet = pf.findAll();

    }
    
    

    //supprime le client en BDD puis de l'interface graphique en récupérant la ligne sélectionnée
    public String supprimerClient() {

        Client clt = getCltToDelete();
        cf.remove(clt);
        listeClt.remove(clt);
        String s = "accueil.xhtml";
        return s;
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

}
