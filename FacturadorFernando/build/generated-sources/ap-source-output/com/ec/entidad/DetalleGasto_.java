package com.ec.entidad;

import com.ec.entidad.Gatos;
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
@StaticMetamodel(DetalleGasto.class)
public class DetalleGasto_ { 

    public static volatile SingularAttribute<DetalleGasto, Gatos> idGasto;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasIva;
    public static volatile SingularAttribute<DetalleGasto, String> dgasDescripcion;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasCatidad;
    public static volatile SingularAttribute<DetalleGasto, Integer> idDetalleGasto;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasTotal;
    public static volatile SingularAttribute<DetalleGasto, BigDecimal> dgasSubtotal;

}