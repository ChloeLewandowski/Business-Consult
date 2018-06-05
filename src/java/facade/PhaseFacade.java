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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Phase;

/**
 *
 * @author Chloé Lewandowski
 */
@Stateless
public class PhaseFacade extends AbstractFacade<Phase> {

    @PersistenceContext(unitName = "BusinessConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhaseFacade() {
        super(Phase.class);
    }

    //retourne une liste de phases associées à un code projet passé en paramêtre
    public List retournerPhasesProjet(Integer idProjet) {
        try {

            Query query = em.createQuery("SELECT p FROM Phase AS p WHERE p.unProjet.idProjet= :id").setParameter("id", idProjet);
            List<Phase> listPhase = query.getResultList();

            return listPhase;

        } catch (NoResultException e) {
            return null;
        }
    }
    
      public void insertPhase(String libelle,String description,Date dateDebut, Date dateFin, Integer idconsultant, Integer idprojet){
    Query query = em.createNativeQuery("INSERT INTO TB_PHASE (LIBELLEPHASE, DESCRIPTIONPHASE, DATEDEBUTPHASE, DATEFINPHASE,IDCONSULTANT,IDPROJET) " +
            " VALUES(?,?,?,?,?,?)");
        query.setParameter(1, libelle);
        query.setParameter(2, description);
        query.setParameter(3, dateDebut);
        query.setParameter(4, dateFin);
        query.setParameter(5, idconsultant);
        query.setParameter(6, idprojet);
        query.executeUpdate();
    }
      
    public Integer rechercheSiFactureExiste(Integer idPhase) {
        Integer numFacture=0;
        Query q = em.createNativeQuery("SELECT numFacture FROM TB_PHASESFACTUREES WHERE CODEPHASE=?");
        q.setParameter(1, idPhase);
        if (q.getResultList().size() > 0) {
            List<Integer> results = q.getResultList();
             numFacture = results.get(0);
        }
        return numFacture;   
    }
    
    public void associeNouvelleFacture(Integer numFacture, Integer codePhase){
        
         Query q = em.createNativeQuery("INSERT INTO TB_PHASESFACTUREES(NUMFACTURE, CODEPHASE) VALUES (?,?)");
         q.setParameter(1, numFacture);
         q.setParameter(2, codePhase);
         q.executeUpdate();
                 
             
        
    }
}
