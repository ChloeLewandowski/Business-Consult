/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Client;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class DetailsClientManager implements java.io.Serializable {
    
    private Integer idClient;
    private String raisonSocClt;
    private String prenomResponsable;
    private String adresseSiege;
    private String CpSiege;
    private String VilleSiege;
    private String paysSiege;
    private String numTelSiege;
    private String faxSiege;
    private Client clientToDisp;
    
    //@PostConstruct
    //public void initInfos(){
        
      //Client c= getClientToDisp();
        
    //}
    
    public String afficherDetails(){
        
        String s="detailsClient.xhtml";
        return s;
    }
    
  
    
    //---------------------------------------------------------------------------
    //getters and setters

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getRaisonSocClt() {
        return raisonSocClt;
    }

    public void setRaisonSocClt(String raisonSocClt) {
        this.raisonSocClt = raisonSocClt;
    }

    public String getPrenomResponsable() {
        return prenomResponsable;
    }

    public void setPrenomResponsable(String prenomResponsable) {
        this.prenomResponsable = prenomResponsable;
    }

    public String getAdresseSiege() {
        return adresseSiege;
    }

    public void setAdresseSiege(String adresseSiege) {
        this.adresseSiege = adresseSiege;
    }

    public String getCpSiege() {
        return CpSiege;
    }

    public void setCpSiege(String CpSiege) {
        this.CpSiege = CpSiege;
    }

    public String getVilleSiege() {
        return VilleSiege;
    }

    public void setVilleSiege(String VilleSiege) {
        this.VilleSiege = VilleSiege;
    }

    public String getPaysSiege() {
        return paysSiege;
    }

    public void setPaysSiege(String paysSiege) {
        this.paysSiege = paysSiege;
    }

    public String getNumTelSiege() {
        return numTelSiege;
    }

    public void setNumTelSiege(String numTelSiege) {
        this.numTelSiege = numTelSiege;
    }

    public String getFaxSiege() {
        return faxSiege;
    }

    public void setFaxSiege(String faxSiege) {
        this.faxSiege = faxSiege;
    }

    public Client getClientToDisp() {
        return clientToDisp;
    }

    public void setClientToDisp(Client clientToDisp) {
        this.clientToDisp = clientToDisp;
    }
    
    
    

    
    
    
}
