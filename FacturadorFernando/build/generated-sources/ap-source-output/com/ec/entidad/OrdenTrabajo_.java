package com.ec.entidad;

import com.ec.entidad.Cliente;
import com.ec.entidad.EstadoFacturas;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
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
@StaticMetamodel(OrdenTrabajo.class)
public class OrdenTrabajo_ { 

    public static volatile SingularAttribute<OrdenTrabajo, BigDecimal> ordSubtotal;
    public static volatile SingularAttribute<OrdenTrabajo, Integer> idOrdenTrabajo;
    public static volatile SingularAttribute<OrdenTrabajo, BigDecimal> ordAbono;
    public static volatile SingularAttribute<OrdenTrabajo, Boolean> ordPresupuesto;
    public static volatile SingularAttribute<OrdenTrabajo, Integer> ordNumero;
    public static volatile SingularAttribute<OrdenTrabajo, BigDecimal> ordTotal;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordMarca;
    public static volatile SingularAttribute<OrdenTrabajo, BigDecimal> ordSaldo;
    public static volatile SingularAttribute<OrdenTrabajo, Usuario> idUsuario;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordObservacion;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordNumText;
    public static volatile SingularAttribute<OrdenTrabajo, Date> ordFecha;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordTitulo;
    public static volatile SingularAttribute<OrdenTrabajo, BigDecimal> ordIva;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordEstado;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordDetalle;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordTipo;
    public static volatile SingularAttribute<OrdenTrabajo, EstadoFacturas> idEstado;
    public static volatile SingularAttribute<OrdenTrabajo, Boolean> ordGarantia;
    public static volatile SingularAttribute<OrdenTrabajo, Cliente> idCliente;
    public static volatile SingularAttribute<OrdenTrabajo, String> ordModelo;
    public static volatile SingularAttribute<OrdenTrabajo, Integer> ordNumProforma;

}