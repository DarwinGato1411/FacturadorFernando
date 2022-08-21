package com.ec.entidad;

import com.ec.entidad.DetalleRetencionCompra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-20T18:48:08")
@StaticMetamodel(TipoRetencion.class)
public class TipoRetencion_ { 

    public static volatile SingularAttribute<TipoRetencion, String> tireCodigo;
    public static volatile CollectionAttribute<TipoRetencion, DetalleRetencionCompra> detalleRetencionCompraCollection;
    public static volatile SingularAttribute<TipoRetencion, String> tireTipo;
    public static volatile SingularAttribute<TipoRetencion, String> tireNombre;
    public static volatile SingularAttribute<TipoRetencion, Double> tirePorcentajeRetencion;

}