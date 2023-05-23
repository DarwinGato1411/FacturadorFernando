package com.ec.entidad;

import com.ec.entidad.Producto;
import com.ec.entidad.ProductoProveedorPK;
import com.ec.entidad.Proveedores;
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
@StaticMetamodel(ProductoProveedor.class)
public class ProductoProveedor_ { 

    public static volatile SingularAttribute<ProductoProveedor, Proveedores> proveedores;
    public static volatile SingularAttribute<ProductoProveedor, ProductoProveedorPK> productoProveedorPK;
    public static volatile SingularAttribute<ProductoProveedor, BigDecimal> prodProvCosto;
    public static volatile SingularAttribute<ProductoProveedor, Date> prodProvFechaReg;
    public static volatile SingularAttribute<ProductoProveedor, Producto> producto;

}