/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ConsultantFacade;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Consultant;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class AjoutConsultantManager implements java.io.Serializable {

    private String prenomConsultant;
    private String nomConsultant;
    private String adresseConsultant;
    private String codePostalConsultant;
    private String villeConsultant;
     @EJB
    private ConsultantFacade cf= new ConsultantFacade(); 

    public String addConsultant() {
        String prenom=getPrenomConsultant();
        String nom=getNomConsultant();
        String adresse=getAdresseConsultant();
        String cp=getCodePostalConsultant();
        String ville=getVilleConsultant();
        cf.insertConsultant(prenom, nom, adresse, cp, ville);
        //Consultant unConsultant= new Consultant(10000,prenom, nom, adresse, cp, ville);
        //cf.create(unConsultant);
        String s = "fromAjoutConsultantToConsultants";
        return s;
    }
    
    public void effacerInfosSaisies(){
        setPrenomConsultant(null);
        setNomConsultant(null);
        setAdresseConsultant(null);
        setCodePostalConsultant(null);
        setVilleConsultant(null);
    }
//---------------------------------------------------------------------------------
    //getters et setters
    public String getPrenomConsultant() {
        return prenomConsultant;
    }

    public void setPrenomConsultant(String prenomConsultant) {
        this.prenomConsultant = prenomConsultant;
    }

    public String getNomConsultant() {
        return nomConsultant;
    }

    public void setNomConsultant(String nomConsultant) {
        this.nomConsultant = nomConsultant;
    }

    public String getAdresseConsultant() {
        return adresseConsultant;
    }

    public void setAdresseConsultant(String adresseConsultant) {
        this.adresseConsultant = adresseConsultant;
    }

    public String getCodePostalConsultant() {
        return codePostalConsultant;
    }

    public void setCodePostalConsultant(String codePostalConsultant) {
        this.codePostalConsultant = codePostalConsultant;
    }

    public String getVilleConsultant() {
        return villeConsultant;
    }

    public void setVilleConsultant(String villeConsultant) {
        this.villeConsultant = villeConsultant;
    }

}
