package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Consultant;
import model.Projet;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-04-24T17:31:20")
@StaticMetamodel(Phase.class)
public class Phase_ { 

    public static volatile SingularAttribute<Phase, Projet> unProjet;
    public static volatile SingularAttribute<Phase, Date> dateDebutPhase;
    public static volatile SingularAttribute<Phase, Consultant> unConsultant;
    public static volatile SingularAttribute<Phase, Integer> codePhase;
    public static volatile SingularAttribute<Phase, String> DescriptionPhase;
    public static volatile SingularAttribute<Phase, String> LibellePhase;
    public static volatile SingularAttribute<Phase, Date> dateFinPhase;

}