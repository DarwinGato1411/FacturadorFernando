package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import com.ec.entidad.Producto;
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
@StaticMetamodel(Kardex.class)
public class Kardex_ { 

    public static volatile SingularAttribute<Kardex, Date> karFechaKardex;
    public static volatile SingularAttribute<Kardex, Integer> idKardex;
    public static volatile SingularAttribute<Kardex, Date> karFechaIngreso;
    public static volatile CollectionAttribute<Kardex, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Kardex, String> karEstado;
    public static volatile SingularAttribute<Kardex, Producto> idProducto;
    public static volatile SingularAttribute<Kardex, String> karDetalle;
    public static volatile SingularAttribute<Kardex, Boolean> karIsActivo;
    public static volatile SingularAttribute<Kardex, Date> karFecha;
    public static volatile SingularAttribute<Kardex, BigDecimal> karTotal;

}