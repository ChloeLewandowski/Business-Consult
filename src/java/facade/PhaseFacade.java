/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
