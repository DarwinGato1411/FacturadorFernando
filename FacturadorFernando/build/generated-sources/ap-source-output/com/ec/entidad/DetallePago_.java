package com.ec.entidad;

import com.ec.entidad.Factura;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(DetallePago.class)
public class DetallePago_ { 

    public static volatile SingularAttribute<DetallePago, BigDecimal> detpTotal;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpSubtotal;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpMulta;
    public static volatile SingularAttribute<DetallePago, Integer> idDetallePago;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpAbono;
    public static volatile SingularAttribute<DetallePago, Factura> idFactura;
    public static volatile SingularAttribute<DetallePago, Date> detpFechaPago;
    public static volatile SingularAttribute<DetallePago, Integer> detpNumPago;
    public static volatile SingularAttribute<DetallePago, Date> detpFechaCobro;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpSaldo;

}