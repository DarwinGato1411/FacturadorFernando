package com.ec.entidad;

import com.ec.entidad.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
@StaticMetamodel(FormaPago.class)
public class FormaPago_ { 

    public static volatile SingularAttribute<FormaPago, Integer> idFormaPago;
    public static volatile SingularAttribute<FormaPago, String> forNombre;
    public static volatile SingularAttribute<FormaPago, String> plazo;
    public static volatile SingularAttribute<FormaPago, String> unidadTiempo;
    public static volatile SingularAttribute<FormaPago, Boolean> isprincipal;
    public static volatile SingularAttribute<FormaPago, String> forCodigo;
    public static volatile CollectionAttribute<FormaPago, Factura> facturaCollection;

}