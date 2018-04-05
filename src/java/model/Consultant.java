/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Collection;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
@Entity
@Table(name="tb_Consultant")
public class Consultant implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idConsultant;
    private String prenomConsultant;
    private String nomConsultant;
    private String adresseConsultant;
    private String cpConsultant;
    private String villeConsultant;
    @OneToMany(mappedBy="unConsultant")
    private Collection<Phase> desPhases;
    
    public Consultant(){
        
    }
    public Consultant(Integer idConsultant, String prenomConsultant, String nomConsultant, String adresseConsultant, String cpConsultant, String villeConsultant) {
        this.idConsultant=idConsultant;
        this.prenomConsultant = prenomConsultant;
        this.nomConsultant = nomConsultant;
        this.adresseConsultant = adresseConsultant;
        this.cpConsultant = cpConsultant;
        this.villeConsultant = villeConsultant;
    }
    
    

    public Integer getIdConsultant() {
        return idConsultant;
    }

    public void setIdConsultant(Integer idConsultant) {
        this.idConsultant = idConsultant;
    }

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

    public String getCpConsultant() {
        return cpConsultant;
    }

    public void setCpConsultant(String cpConsultant) {
        this.cpConsultant = cpConsultant;
    }

    public String getVilleConsultant() {
        return villeConsultant;
    }

    public void setVilleConsultant(String villeConsultant) {
        this.villeConsultant = villeConsultant;
    }

    public Collection<Phase> getDesPhases() {
        return desPhases;
    }

    public void setDesPhases(Collection<Phase> desPhases) {
        this.desPhases = desPhases;
    }
    
    
    
    
    
}
