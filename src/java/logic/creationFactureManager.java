/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.FactureFacade;
import facade.PhaseFacade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Client;
import model.Facture;
import model.Phase;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class creationFactureManager implements java.io.Serializable {
    
    Facture factureAffichee= new Facture();
    private Phase phaseSelec= new Phase();
    Client cliFacture= new Client();
    private Long montantHT;
    private Double tauxTaxes=1.2;
    private Long montantTTC=null;
    DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
    Date dateFacture = new Date();
    
    public Integer existe;
    @EJB
    PhaseFacade pf= new PhaseFacade();
    @EJB
    FactureFacade ff= new FactureFacade();
    
    
     public String creerFacture(){
       
       
        existe=pf.rechercheSiFactureExiste(phaseSelec.getCodePhase());
        if (existe!=0){
         //je recherche la facture en base à l'aide du numéro fourni 
         factureAffichee=ff.find(existe);
         } else {
            /*si la phase n'avait pas de date de fin définie j'en rentre une à la date du jour et 
            j'édite également mon objet en base*/
            if (phaseSelec.getDateFinPhase()==null){
                phaseSelec.setDateFinPhase(java.sql.Timestamp.valueOf(LocalDateTime.now()));
                pf.edit(phaseSelec);
            }
             /*je crée la facture à partir des infos:
             on calcul d'abord l'écart entre la date de fin et la date de début
             puis on convertit chacune des dates en milisecondes et ensuite on les reconvertit en jours
             enfin multiplie l'écart par 7 (car 7h de travail par jour) puis par 20 qui est le prix HT à l'heure*/
             montantHT = (((phaseSelec.getDateFinPhase().getTime()) - (phaseSelec.getDateDebutPhase().getTime())) / (1000 * 60 * 60 * 24)) * 7 * 20;
             //pour avoir le montant TTC je multiplie mon prix HT par 20%
             montantTTC = (long)(montantHT*(tauxTaxes));
             dateFacture=(java.sql.Timestamp.valueOf(LocalDateTime.now()));
             cliFacture=this.phaseSelec.getUnProjet().getUnClient();
             ff.insertFacture((double)montantHT, (double)montantTTC, dateFacture, cliFacture.getIdClt());
             Integer numfacture=ff.rechercherDernierEnregistrement();
             pf.associeNouvelleFacture(numfacture, phaseSelec.getCodePhase());

         }

         String s = "creationFacturePhase.xhtml";
         return s;

    }
     
     public void genererPDF(){
         JRBeanCollectionDataSource jbx;
         
     }
     

    public Phase getPhaseSelec() {
        return phaseSelec;
    }

    public void setPhaseSelec(Phase phaseSelec) {
        this.phaseSelec = phaseSelec;
    }

    public Long getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(Long montantHT) {
        this.montantHT = montantHT;
    }

    public Long getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Long montantTTC) {
        this.montantTTC = montantTTC;
    }

    public Integer getExiste() {
        return existe;
    }

    public void setExiste(Integer existe) {
        this.existe = existe;
    }

    public Facture getFactureAffichee() {
        return factureAffichee;
    }

    public void setFactureAffichee(Facture factureAffichee) {
        this.factureAffichee = factureAffichee;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Client getCliFacture() {
        return cliFacture;
    }

    public void setCliFacture(Client cliFacture) {
        this.cliFacture = cliFacture;
    }

    public Double getTauxTaxes() {
        return tauxTaxes;
    }

    public void setTauxTaxes(Double tauxTaxes) {
        this.tauxTaxes = tauxTaxes;
    }
    
    
    
    
    
    
    
    
    
    
     
     
    
}
