/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
@Entity
@Table(name="tb_client")
public class Client implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDCLT")
    private String idClt;
    @Column(name = "RAISONSOCCLT")
    private String raisonSocClt;
    @Column(name = "NOMRESPONSABLE")
    private String nomResponsable;
    @Column(name = "PRENOMRESPONSABLE")
    private String prenomResponsable;
    @Column(name = "ADRESSESIEGE")
    private String adresseSiege;
    @Column(name = "CPSIEGE")
    private String CpSiege;
    @Column(name = "VILLESIEGE")
    private String villeSiege;
    @Column(name = "PAYSSIEGE")
    private String paysSiege;
    @Column(name = "NUMTELSIEGE")
    private String numTelSiege;
    @Column(name = "FAXSIEGE")
    private String faxSiege;

    public Client(String idClt, String raisonSocClt, String nomResponsable, String prenomResponsable, String adresseSiege, String CpSiege, String villeSiege, String paysSiege, String numTelSiege, String faxSiege) {
        this.idClt = idClt;
        this.raisonSocClt = raisonSocClt;
        this.nomResponsable = nomResponsable;
        this.prenomResponsable = prenomResponsable;
        this.adresseSiege = adresseSiege;
        this.CpSiege = CpSiege;
        this.villeSiege = villeSiege;
        this.paysSiege = paysSiege;
        this.numTelSiege = numTelSiege;
        this.faxSiege = faxSiege;
    }
    
    public Client(){
        
    }
    
    public String getIdClt() {
        return idClt;
    }

    public void setIdClt(String idClt) {
        this.idClt = idClt;
    }

    public String getRaisonSocClt() {
        return raisonSocClt;
    }

    public void setRaisonSocClt(String raisonSocClt) {
        this.raisonSocClt = raisonSocClt;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
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
        return villeSiege;
    }

    public void setVilleSiege(String villeSiege) {
        this.villeSiege = villeSiege;
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
    
    
}
