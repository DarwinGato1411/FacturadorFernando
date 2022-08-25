package com.ec.entidad;

import com.ec.entidad.Factura;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-24T20:51:17")
@StaticMetamodel(RetencionVenta.class)
public class RetencionVenta_ { 

    public static volatile SingularAttribute<RetencionVenta, String> rveEstablecimiento;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveValorRetencionIva30;
    public static volatile SingularAttribute<RetencionVenta, Integer> rveCodigo;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveValorRetencionIva70;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveValorRetencionIva100;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveValorRetencionRenta;
    public static volatile SingularAttribute<RetencionVenta, String> rveAutorizacion;
    public static volatile SingularAttribute<RetencionVenta, Date> rveFecha;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveRenta;
    public static volatile SingularAttribute<RetencionVenta, BigDecimal> rveSecuencial;
    public static volatile SingularAttribute<RetencionVenta, Factura> idFactura;
    public static volatile SingularAttribute<RetencionVenta, String> rvePuntoEmision;
    public static volatile SingularAttribute<RetencionVenta, String> rveSerie;

}