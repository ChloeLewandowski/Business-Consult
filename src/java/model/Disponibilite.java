/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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
@Table(name="tb_Disponibilite")
public class Disponibilite implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codeDisponibilite;
    private String libelleDisponibilite;
    
    public Disponibilite(){
        
    }

    public int getCodeDisponibilite() {
        return codeDisponibilite;
    }

    public void setCodeDisponibilite(int codeDisponibilite) {
        this.codeDisponibilite = codeDisponibilite;
    }

    public String getLibelleDisponibilite() {
        return libelleDisponibilite;
    }

    public void setLibelleDisponibilite(String libelleDisponibilite) {
        this.libelleDisponibilite = libelleDisponibilite;
    }
    
    
    
}
