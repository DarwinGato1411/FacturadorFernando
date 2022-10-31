package com.ec.entidad.docsri;

import com.ec.entidad.sri.DetalleRetencionCompraSri;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
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
@StaticMetamodel(RetencionCompraSri.class)
public class RetencionCompraSri_ { 

    public static volatile SingularAttribute<RetencionCompraSri, String> rcoPuntoEmision;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoSerie;
    public static volatile SingularAttribute<RetencionCompraSri, Double> rcoValorRetencionIva;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoPathret;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoMsmInfoSri;
    public static volatile SingularAttribute<RetencionCompraSri, String> drcEstadosri;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoDetalle;
    public static volatile SingularAttribute<RetencionCompraSri, BigDecimal> rcoBaseGravaIva;
    public static volatile SingularAttribute<RetencionCompraSri, String> drcMensajesri;
    public static volatile CollectionAttribute<RetencionCompraSri, DetalleRetencionCompraSri> detalleRetencionCompraSriCollection;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoRuc;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoNombre;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoSecuencialText;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoNumFactura;
    public static volatile SingularAttribute<RetencionCompraSri, Integer> rcoSecuencial;
    public static volatile SingularAttribute<RetencionCompraSri, Integer> rcoCodigo;
    public static volatile SingularAttribute<RetencionCompraSri, Date> cabFechaEmision;
    public static volatile SingularAttribute<RetencionCompraSri, String> rcoAutorizacion;
    public static volatile SingularAttribute<RetencionCompraSri, Boolean> rcoIva;
    public static volatile SingularAttribute<RetencionCompraSri, Integer> rcoPorcentajeIva;
    public static volatile SingularAttribute<RetencionCompraSri, Date> rcoFecha;
    public static volatile SingularAttribute<RetencionCompraSri, Date> rcoFechaAutorizacion;

}