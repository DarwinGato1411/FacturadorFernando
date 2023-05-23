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
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
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