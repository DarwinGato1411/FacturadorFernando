package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-24T17:22:02")
>>>>>>> 20f49c653932904ecd2357709f0fecbec34ee5d4
@StaticMetamodel(DetalleCompra.class)
public class DetalleCompra_ { 

    public static volatile SingularAttribute<DetalleCompra, String> detDescripcion;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodCodigoProvee;
    public static volatile SingularAttribute<DetalleCompra, CabeceraCompra> idCabecera;
    public static volatile SingularAttribute<DetalleCompra, Integer> idIngresoProd;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodTotal;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodCantidad;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> iprodSubtotal;
    public static volatile SingularAttribute<DetalleCompra, Producto> idProducto;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> detValorInicial;
    public static volatile SingularAttribute<DetalleCompra, BigDecimal> detFactor;

}