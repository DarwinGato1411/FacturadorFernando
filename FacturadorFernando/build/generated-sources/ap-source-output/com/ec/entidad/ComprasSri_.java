package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
@StaticMetamodel(ComprasSri.class)
public class ComprasSri_ { 

    public static volatile SingularAttribute<ComprasSri, String> csriTipoEmision;
    public static volatile SingularAttribute<ComprasSri, String> csriAutorizacion;
    public static volatile SingularAttribute<ComprasSri, String> csriClaveAcceso;
    public static volatile SingularAttribute<ComprasSri, String> csriComprobante;
    public static volatile SingularAttribute<ComprasSri, BigDecimal> idCompSri;
    public static volatile SingularAttribute<ComprasSri, String> csriSerieComprobante;
    public static volatile SingularAttribute<ComprasSri, Date> csriFechaAutorizacion;
    public static volatile SingularAttribute<ComprasSri, String> csriRazonSocial;
    public static volatile SingularAttribute<ComprasSri, String> csriIdentificacionReceptor;
    public static volatile SingularAttribute<ComprasSri, String> csriRucEmisor;
    public static volatile SingularAttribute<ComprasSri, String> csriVerificado;
    public static volatile SingularAttribute<ComprasSri, String> csriTotal;
    public static volatile SingularAttribute<ComprasSri, Date> csriFechaEmision;

}