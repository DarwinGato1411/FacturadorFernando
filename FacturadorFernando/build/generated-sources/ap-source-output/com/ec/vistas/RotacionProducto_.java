package com.ec.vistas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-18T17:29:41")
@StaticMetamodel(RotacionProducto.class)
public class RotacionProducto_ { 

    public static volatile SingularAttribute<RotacionProducto, BigDecimal> cantidadVenta;
    public static volatile SingularAttribute<RotacionProducto, String> prodNombre;
    public static volatile SingularAttribute<RotacionProducto, Date> facFecha;
    public static volatile SingularAttribute<RotacionProducto, Integer> codTipoambiente;
    public static volatile SingularAttribute<RotacionProducto, Integer> idProducto;
    public static volatile SingularAttribute<RotacionProducto, BigInteger> idRotacion;
    public static volatile SingularAttribute<RotacionProducto, BigDecimal> valorVentaProducto;

}