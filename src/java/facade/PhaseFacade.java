/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

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

}
