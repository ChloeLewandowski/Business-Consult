/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chloé Lewandowski
 */
@Entity
@Table(name="tb_Utilisateur")
public class User implements java.io.Serializable {
    @Id
    @Column(name="loginUtil")
    private String loginUser;
    @Column(name="passwordUtil")
    private String passwordUser;
    
    public User(){
        
    }


    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }
    

    public String getPassword() {
        return passwordUser;
    }

    public void setPassword(String password) {
        this.passwordUser= password;
    }
    
    
    
    
    
}
