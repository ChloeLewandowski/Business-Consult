package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Phase;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-04-24T17:31:20")
@StaticMetamodel(Consultant.class)
public class Consultant_ { 

    public static volatile SingularAttribute<Consultant, Integer> idConsultant;
    public static volatile SingularAttribute<Consultant, String> nomConsultant;
    public static volatile SingularAttribute<Consultant, String> villeConsultant;
    public static volatile CollectionAttribute<Consultant, Phase> desPhases;
    public static volatile SingularAttribute<Consultant, String> prenomConsultant;
    public static volatile SingularAttribute<Consultant, String> adresseConsultant;
    public static volatile SingularAttribute<Consultant, String> cpConsultant;

}