/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.UserFacade;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.User;


/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class LoginManager implements java.io.Serializable{

    private User user;
    private String loginUser; 
    private String passwordUser;
    private String submessage;
    private String message;
    @EJB
    UserFacade uf= new UserFacade();
    
    
    
 
   

    public String send() {
        
        user = uf.getUser(getLoginUser(), getPasswordUser());
        if (user == null) {
            user = new User();
            message="Erreur de connexion: veuillez vérifier votre identifiant et/ou votre mot de passe";
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Identifiants incorrect", " Vérifiez vos logins et réessayez"));
            return null;
        } else {
            return "accueil";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }
    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
 
    
    
    
    

}
