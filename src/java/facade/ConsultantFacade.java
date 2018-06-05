/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Consultant;

/**
 *
 * @author Chloé Lewandowski
 */
@Stateless
public class ConsultantFacade extends AbstractFacade<Consultant> {

    @PersistenceContext(unitName = "BusinessConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultantFacade() {
        super(Consultant.class);
    }
    
    //ajout d'un consultant en base 
     public void insertConsultant(String prenom,String nom,String adresse, String cp, String ville){
    Query query = em.createNativeQuery("INSERT INTO TB_CONSULTANT (PRENOMCONSULTANT, NOMCONSULTANT, ADRESSECONSULTANT, CPCONSULTANT,VILLECONSULTANT) " +
            " VALUES(?,?,?,?,?)");
        query.setParameter(1, prenom);
        query.setParameter(2, nom);
        query.setParameter(3, adresse);
        query.setParameter(4, cp);
        query.setParameter(5, ville);
        query.executeUpdate();
    }
    
}
