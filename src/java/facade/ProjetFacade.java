/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Projet;

/**
 *
 * @author Chloé Lewandowski
 */
@Stateless
public class ProjetFacade extends AbstractFacade<Projet> {

    @PersistenceContext(unitName = "BusinessConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjetFacade() {
        super(Projet.class);
    }
    
    //ajout d'un projet en base
   public void insertProjet(String libelleProjet,Date dateDebProjP,Date dateFinProjP, 
           Date dateDebProjE, Date dateFinProjE, String descriptionProjet, Integer idClt){
    
       Query query = em.createNativeQuery("INSERT INTO TB_PROJET (LIBELLEPROJET, DATEDEBPROJETPREVUE, DATEFINPROJETPREVUE, "
               + "DATEDEBPROJETEFFECTIVE,DATEFINPROJETEFFECTIVE,DESCRIPTIONPROJET,IDCLT) " +
            " VALUES(?,?,?,?,?,?,?)");
        query.setParameter(1, libelleProjet);
        query.setParameter(2, dateDebProjP);
        query.setParameter(3, dateFinProjP);
        query.setParameter(4, dateDebProjE);
        query.setParameter(5, dateFinProjE);
        query.setParameter(6, descriptionProjet);
        query.setParameter(7, idClt);
        
        query.executeUpdate();
        
    }
}
