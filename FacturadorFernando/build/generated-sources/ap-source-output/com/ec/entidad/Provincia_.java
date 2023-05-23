package com.ec.entidad;

import com.ec.entidad.Canton;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
@StaticMetamodel(Provincia.class)
public class Provincia_ { 

    public static volatile SingularAttribute<Provincia, Integer> idProvincia;
    public static volatile SingularAttribute<Provincia, String> provNombre;
    public static volatile SingularAttribute<Provincia, Boolean> provEstado;
    public static volatile CollectionAttribute<Provincia, Canton> cantonCollection;
    public static volatile SingularAttribute<Provincia, Integer> provNumero;

}