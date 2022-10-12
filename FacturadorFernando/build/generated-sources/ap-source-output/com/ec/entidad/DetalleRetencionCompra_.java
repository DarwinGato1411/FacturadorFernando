package com.ec.entidad;

import com.ec.entidad.RetencionCompra;
import com.ec.entidad.TipoRetencion;
import com.ec.entidad.Tipoivaretencion;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(DetalleRetencionCompra.class)
public class DetalleRetencionCompra_ { 

    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcPorcentaje;
    public static volatile SingularAttribute<DetalleRetencionCompra, Tipoivaretencion> idTipoivaretencion;
    public static volatile SingularAttribute<DetalleRetencionCompra, Integer> drcCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, TipoRetencion> tireCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, RetencionCompra> rcoCodigo;
    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcValorRetenido;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcTipoRegistro;
    public static volatile SingularAttribute<DetalleRetencionCompra, BigDecimal> drcBaseImponible;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcDescripcion;
    public static volatile SingularAttribute<DetalleRetencionCompra, String> drcCodImpuestoAsignado;

}