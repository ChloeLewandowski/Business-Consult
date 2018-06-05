/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
@Entity
@Table(name="tb_Facture")
public class Facture implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer numFacture;
    private Double montantFactureHT;
    private Double montantFactureTTC;
    private Date dateFacture;
    @JoinColumn(name = "idClt")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client unClient;

    public Integer getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(Integer numFacture) {
        this.numFacture = numFacture;
    }

    public Double getMontantFactureHT() {
        return montantFactureHT;
    }

    public void setMontantFactureHT(Double montantFactureHT) {
        this.montantFactureHT = montantFactureHT;
    }

    public Double getMontantFactureTTC() {
        return montantFactureTTC;
    }

    public void setMontantFactureTTC(Double montantFactureTTC) {
        this.montantFactureTTC = montantFactureTTC;
    }

    public Client getUnClient() {
        return unClient;
    }

    public void setUnClient(Client unClient) {
        this.unClient = unClient;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }
    
    
    
    

}
