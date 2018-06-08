/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.User;

/**
 *
 * @author Chloé Lewandowski
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    @PersistenceContext(unitName = "BusinessConsultPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public User getUser(String nameUser, String password) {
        try {
            User u = (User) em.createQuery("SELECT u from User u where"
                    + " u.loginUser = :name and u.passwordUser "
                    + "= :password").setParameter("name", nameUser).setParameter("password", password).getSingleResult();
            return u;
        } catch (NoResultException e) {
            return null;
        }
    }

    public UserFacade() {
        super(User.class);
    }

}
