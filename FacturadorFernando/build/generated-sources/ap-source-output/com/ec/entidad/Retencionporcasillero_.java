package com.ec.entidad;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-18T17:29:41")
@StaticMetamodel(Retencionporcasillero.class)
public class Retencionporcasillero_ { 

    public static volatile SingularAttribute<Retencionporcasillero, Double> valorRetenido;
    public static volatile SingularAttribute<Retencionporcasillero, String> tireCodigo;
    public static volatile SingularAttribute<Retencionporcasillero, String> tipoRetencion;
    public static volatile SingularAttribute<Retencionporcasillero, Date> cabFechaEmision;
    public static volatile SingularAttribute<Retencionporcasillero, BigInteger> numeroComprobante;
    public static volatile SingularAttribute<Retencionporcasillero, BigInteger> id;

}