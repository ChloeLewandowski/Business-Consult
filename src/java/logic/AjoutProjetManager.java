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

    @PostConstruct
    public void initPrjTab() {

        listClient = cf.findAll();

    }
    
    public String ajoutProjet(){
        String libelle=getLibelleProjet();
        Date dateDebP=getDateDebProjetPrevue();
        Date dateFinP=getDateFinProjetPrevue();
        Date dateDebE=getDateDebProjetEffective();
        Date dateFinE=getDateFinProjetEffective();
        String desc= getDescriptionProjet();
        Client clt=getCltProjet();
        Integer id=clt.getIdClt();
        pf.insertProjet(libelle, dateDebP, dateFinP, dateDebE, dateFinE, desc, id);
        String s="projets.xhtml";
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
    
    
    
    
 
 
    
}
