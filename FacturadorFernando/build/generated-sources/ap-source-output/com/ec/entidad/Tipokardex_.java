package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(Tipokardex.class)
public class Tipokardex_ { 

    public static volatile SingularAttribute<Tipokardex, Boolean> tidEstado;
    public static volatile SingularAttribute<Tipokardex, String> tipkDescripcion;
    public static volatile SingularAttribute<Tipokardex, String> tipkSigla;
    public static volatile CollectionAttribute<Tipokardex, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Tipokardex, Integer> idTipokardex;

}