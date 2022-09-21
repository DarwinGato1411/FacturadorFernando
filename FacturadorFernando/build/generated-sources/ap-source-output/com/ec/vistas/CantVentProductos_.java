package com.ec.vistas;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-20T19:18:28")
@StaticMetamodel(CantVentProductos.class)
public class CantVentProductos_ { 

    public static volatile SingularAttribute<CantVentProductos, BigDecimal> compra;
    public static volatile SingularAttribute<CantVentProductos, Long> idDetalle;
    public static volatile SingularAttribute<CantVentProductos, String> prodNombre;
    public static volatile SingularAttribute<CantVentProductos, Date> facFecha;
    public static volatile SingularAttribute<CantVentProductos, BigDecimal> cantidad;
    public static volatile SingularAttribute<CantVentProductos, Integer> idProducto;
    public static volatile SingularAttribute<CantVentProductos, BigDecimal> diferencia;

}