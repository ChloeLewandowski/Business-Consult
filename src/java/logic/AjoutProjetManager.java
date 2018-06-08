/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ClientFacade;
import facade.ProjetFacade;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Client;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class AjoutProjetManager {
  
    private List<Client> listClient;
    private Client cltProjet = new Client();
    @EJB
    ClientFacade cf = new ClientFacade();
    @EJB
    ProjetFacade pf= new ProjetFacade();
    private String libelleProjet;
    private Date dateDebProjetPrevue;
    private Date dateFinProjetPrevue;
    private Date dateDebProjetEffective;
    private Date dateFinProjetEffective;
    private String descriptionProjet;
    private String messageErreur; 

    @PostConstruct
    public void initPrjTab() {

        listClient = cf.findAll();

    }

    public String ajoutProjet() {
        String s;
        //on vérifie que les dates saisies par l'utilisateurs soient cohérentes
        if ((getDateFinProjetEffective().getTime() < getDateDebProjetEffective().getTime()) || 
                (getDateFinProjetPrevue().getTime() < getDateDebProjetPrevue().getTime())) {
            messageErreur = "Vos saisies de dates sont incorrectes, veuillez vérifier leur cohérence "
                    + " (pas de date de fin supérieure à une date de début)";
            //on lui affiche toujours la même vue
            s = "ajoutProjet.xhtml";
        } else {
            //on insère le projet en base
            pf.insertProjet(getLibelleProjet(), getDateDebProjetPrevue(), getDateFinProjetPrevue(),
                    getDateDebProjetEffective(), getDateFinProjetEffective(), getDescriptionProjet(),
                    getCltProjet().getIdClt());
            //on redirige l'utilisateur vers la liste des projets du cabinet
            s = "projets.xhtml";

        }
        return s;
    }

    public void effacerInfosSaisies(){
        setLibelleProjet(null);
        setDescriptionProjet(null);
        setCltProjet(null);
        setDateDebProjetEffective(null);
        setDateDebProjetPrevue(null);
        setDateFinProjetEffective(null);
        setDateFinProjetPrevue(null);
    }

    //------------------------------------------------------------------------
    //accesseurs: getters et setters
    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public Client getCltProjet() {
        return cltProjet;
    }

    public void setCltProjet(Client cltProjet) {
        this.cltProjet = cltProjet;
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

    public String getMessageErreur() {
        return messageErreur;
    }

    public void setMessageErreur(String messageErreur) {
        this.messageErreur = messageErreur;
    }
    
    
    
    
    
 
 
    
}
