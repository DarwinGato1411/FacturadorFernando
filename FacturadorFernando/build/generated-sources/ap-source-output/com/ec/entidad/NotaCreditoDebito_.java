package com.ec.entidad;

import com.ec.entidad.DetalleNotaDebitoCredito;
import com.ec.entidad.Factura;
import com.ec.entidad.Usuario;
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
@StaticMetamodel(NotaCreditoDebito.class)
public class NotaCreditoDebito_ { 

    public static volatile SingularAttribute<NotaCreditoDebito, String> facTipo;
    public static volatile SingularAttribute<NotaCreditoDebito, Usuario> idUsuario;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facDescripcion;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facPlazo;
    public static volatile SingularAttribute<NotaCreditoDebito, Date> facFechaAutorizacion;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facNumeroText;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facClaveAutorizacion;
    public static volatile SingularAttribute<NotaCreditoDebito, String> mensajesri;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facDescuento;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facPath;
    public static volatile SingularAttribute<NotaCreditoDebito, Integer> facNumero;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facTotalBaseCero;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facSubtotal;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facCodIva;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facTipoIdentificadorComprobador;
    public static volatile SingularAttribute<NotaCreditoDebito, String> tipodocumento;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facAbono;
    public static volatile SingularAttribute<NotaCreditoDebito, String> codestablecimiento;
    public static volatile SingularAttribute<NotaCreditoDebito, String> codigoPorcentaje;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facSaldo;
    public static volatile SingularAttribute<NotaCreditoDebito, Integer> idFormaPago;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facTotal;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facCodIce;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facEstado;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facMoneda;
    public static volatile SingularAttribute<NotaCreditoDebito, String> tipodocumentomod;
    public static volatile CollectionAttribute<NotaCreditoDebito, DetalleNotaDebitoCredito> detalleNotaDebitoCreditoCollection;
    public static volatile SingularAttribute<NotaCreditoDebito, String> estadosri;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facTotalBaseGravaba;
    public static volatile SingularAttribute<NotaCreditoDebito, Date> facFechaSustento;
    public static volatile SingularAttribute<NotaCreditoDebito, String> puntoemision;
    public static volatile SingularAttribute<NotaCreditoDebito, Integer> facNumProforma;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facPorcentajeIva;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facUnidadTiempo;
    public static volatile SingularAttribute<NotaCreditoDebito, String> facClaveAcceso;
    public static volatile SingularAttribute<NotaCreditoDebito, Factura> idFactura;
    public static volatile SingularAttribute<NotaCreditoDebito, Date> facFecha;
    public static volatile SingularAttribute<NotaCreditoDebito, Integer> idNota;
    public static volatile SingularAttribute<NotaCreditoDebito, Integer> codTipoambiente;
    public static volatile SingularAttribute<NotaCreditoDebito, BigDecimal> facIva;
    public static volatile SingularAttribute<NotaCreditoDebito, String> mensajeInf;

}