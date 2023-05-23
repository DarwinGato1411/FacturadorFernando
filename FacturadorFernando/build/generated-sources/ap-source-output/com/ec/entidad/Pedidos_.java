package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, BigDecimal> pedCantidad;
    public static volatile SingularAttribute<Pedidos, String> pedProveedor;
    public static volatile SingularAttribute<Pedidos, Integer> codPedido;
    public static volatile SingularAttribute<Pedidos, Date> pedFecha;
    public static volatile SingularAttribute<Pedidos, String> pedEstado;
    public static volatile SingularAttribute<Pedidos, String> pedDescripcion;

}