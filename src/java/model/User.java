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
@Table(name="tb_utilisateur")
public class User implements java.io.Serializable {
    @Column(name="idUtil")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idUser;
    @Column(name="loginUtil")
    private String loginUser;
    @Column(name="passwordUtil")
    private String passwordUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

   

    public String getPassword() {
        return passwordUser;
    }

    public void setPassword(String password) {
        this.passwordUser= password;
    }
    
    
    
    
    
}
