/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Facture;

/**
 *
 * @author Chloé Lewandowski
 */
@Stateless
public class FactureFacade extends AbstractFacade<Facture> {

    @PersistenceContext(unitName = "BusinessConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactureFacade() {
        super(Facture.class);
    }
    
    public void insertFacture(Double montantHT, Double montantTTC, Date dateFacture, Integer idClient){
        Query query = em.createNativeQuery("INSERT INTO TB_FACTURE (MONTANTFACTUREHT, MONTANTFACTURETTC, DATEFACTURE,IDCLT) " +
            " VALUES(?,?,?,?)");
         query.setParameter(1, montantHT);
        query.setParameter(2, montantTTC);
        query.setParameter(3, dateFacture);
        query.setParameter(4, idClient);
        query.executeUpdate();
    }
    
    public Integer rechercherDernierEnregistrement(){
        Query q = em.createNativeQuery("SELECT NUMFACTURE FROM TB_FACTURE WHERE NUMFACTURE = (SELECT MAX(NUMFACTURE) FROM TB_FACTURE)");
        
        List<Integer> results = q.getResultList();
        Integer numFacture=results.get(0);
        return numFacture;
    }
}
