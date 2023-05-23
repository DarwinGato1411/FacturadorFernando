package com.ec.entidad.docsri;

import com.ec.entidad.sri.DetalleRetencionCompraSri;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
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