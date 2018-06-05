package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Phase;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-04-24T17:31:20")
@StaticMetamodel(Projet.class)
public class Projet_ { 

    public static volatile SingularAttribute<Projet, Date> dateDebProjetEffective;
    public static volatile CollectionAttribute<Projet, Phase> desPhases;
    public static volatile SingularAttribute<Projet, Date> dateFinProjetEffective;
    public static volatile SingularAttribute<Projet, Date> dateDebProjetPrevue;
    public static volatile SingularAttribute<Projet, Date> dateFinProjetPrevue;
    public static volatile SingularAttribute<Projet, String> libelleProjet;
    public static volatile SingularAttribute<Projet, Integer> idProjet;
    public static volatile SingularAttribute<Projet, String> descriptionProjet;

}