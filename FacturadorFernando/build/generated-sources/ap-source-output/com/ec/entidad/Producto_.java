package com.ec.entidad;

import com.ec.entidad.DetalleFactura;
import com.ec.entidad.Kardex;
import com.ec.entidad.ProductoProveedor;
import com.ec.entidad.Subcategoria;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.sri.DetalleCompraSri;
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
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, byte[]> prodQr;
    public static volatile SingularAttribute<Producto, Boolean> prodGrabaIva;
    public static volatile SingularAttribute<Producto, BigDecimal> prodCantidadInicial;
    public static volatile SingularAttribute<Producto, String> prodAbreviado;
    public static volatile SingularAttribute<Producto, BigDecimal> prodUtilidadDos;
    public static volatile SingularAttribute<Producto, BigDecimal> prodPrecioSinSubsidio;
    public static volatile SingularAttribute<Producto, BigDecimal> pordCostoPromedioCompra;
    public static volatile SingularAttribute<Producto, BigDecimal> prodCostoPreferencialDos;
    public static volatile SingularAttribute<Producto, Boolean> prodImprimeCodbar;
    public static volatile SingularAttribute<Producto, BigDecimal> prodFactorConversion;
    public static volatile SingularAttribute<Producto, Boolean> prodIsPrincipal;
    public static volatile CollectionAttribute<Producto, DetalleFactura> detalleFacturaCollection;
    public static volatile SingularAttribute<Producto, BigDecimal> prodPorcentajeIce;
    public static volatile SingularAttribute<Producto, String> prodNombre;
    public static volatile SingularAttribute<Producto, String> prodUnidadMedida;
    public static volatile SingularAttribute<Producto, String> prodPathCodbar;
    public static volatile SingularAttribute<Producto, Date> prodFechaRegistro;
    public static volatile SingularAttribute<Producto, Boolean> prodGrabaIce;
    public static volatile SingularAttribute<Producto, String> prodCodigo;
    public static volatile SingularAttribute<Producto, BigDecimal> prodTrasnporte;
    public static volatile SingularAttribute<Producto, BigDecimal> prodUtilidadPreferencial;
    public static volatile SingularAttribute<Producto, BigDecimal> prodCostoPreferencialTres;
    public static volatile SingularAttribute<Producto, String> prodUnidadConversion;
    public static volatile SingularAttribute<Producto, BigDecimal> pordCostoVentaFinal;
    public static volatile SingularAttribute<Producto, Subcategoria> idSubCategoria;
    public static volatile SingularAttribute<Producto, String> proGlp;
    public static volatile CollectionAttribute<Producto, Kardex> kardexCollection;
    public static volatile SingularAttribute<Producto, Integer> prodEstado;
    public static volatile SingularAttribute<Producto, BigDecimal> prodCostoPreferencial;
    public static volatile SingularAttribute<Producto, Integer> prodPrincipal;
    public static volatile SingularAttribute<Producto, String> prodTieneSubsidio;
    public static volatile SingularAttribute<Producto, BigDecimal> prodIva;
    public static volatile SingularAttribute<Producto, BigDecimal> pordCostoVentaRef;
    public static volatile SingularAttribute<Producto, BigDecimal> prodUtilidadNormal;
    public static volatile SingularAttribute<Producto, BigDecimal> prodSubsidio;
    public static volatile CollectionAttribute<Producto, DetalleCompraSri> detalleCompraSriCollection;
    public static volatile SingularAttribute<Producto, Boolean> prodEsproducto;
    public static volatile SingularAttribute<Producto, BigDecimal> pordCostoCompra;
    public static volatile SingularAttribute<Producto, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<Producto, Integer> idProducto;
    public static volatile CollectionAttribute<Producto, ProductoProveedor> productoProveedorCollection;
    public static volatile SingularAttribute<Producto, BigDecimal> prodManoObra;
    public static volatile SingularAttribute<Producto, BigDecimal> prodCantMinima;

}