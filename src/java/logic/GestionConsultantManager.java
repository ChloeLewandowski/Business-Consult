/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import facade.ConsultantFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import model.Consultant;

/**
 *
 * @author Chloé Lewandowski
 */
@ApplicationScoped
@ManagedBean
public class GestionConsultantManager implements java.io.Serializable {

    private List<Consultant> consultantList;
    @EJB
    private ConsultantFacade cf = new ConsultantFacade();
    
    @PostConstruct
    public void initCltTab(){
        consultantList= cf.findAll();
    }

    public List<Consultant> getConsultantList() {
        return consultantList;
    }

    public void setConsultantList(List<Consultant> consultantList) {
        this.consultantList = consultantList;
    }

}
