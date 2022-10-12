package com.ec.entidad;

import com.ec.entidad.DetalleGasto;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(Gatos.class)
public class Gatos_ { 

    public static volatile SingularAttribute<Gatos, Integer> idGasto;
    public static volatile CollectionAttribute<Gatos, DetalleGasto> detalleGastoCollection;
    public static volatile SingularAttribute<Gatos, String> gasRazonSocial;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasIva;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasValorTotal;
    public static volatile SingularAttribute<Gatos, String> gasNumeroComprobante;
    public static volatile SingularAttribute<Gatos, Date> gasFecha;
    public static volatile SingularAttribute<Gatos, BigDecimal> gasSubtotal;

}