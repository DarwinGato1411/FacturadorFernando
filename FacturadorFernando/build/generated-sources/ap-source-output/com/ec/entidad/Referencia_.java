package com.ec.entidad;

import com.ec.entidad.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(Referencia.class)
public class Referencia_ { 

    public static volatile SingularAttribute<Referencia, String> refCodigo;
    public static volatile SingularAttribute<Referencia, String> refNombre;
    public static volatile SingularAttribute<Referencia, Integer> idReferencia;
    public static volatile SingularAttribute<Referencia, Boolean> isprincipal;
    public static volatile CollectionAttribute<Referencia, Factura> facturaCollection;

}