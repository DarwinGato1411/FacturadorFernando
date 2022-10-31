package com.ec.entidad.partida;

import com.ec.entidad.partida.CuCuenta;
import java.math.BigDecimal;
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
@StaticMetamodel(CuSubCuenta.class)
public class CuSubCuenta_ { 

    public static volatile SingularAttribute<CuSubCuenta, String> subcNumero;
    public static volatile SingularAttribute<CuSubCuenta, Integer> idSubCuenta;
    public static volatile SingularAttribute<CuSubCuenta, String> subcNombre;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcOtro;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcTotal;
    public static volatile SingularAttribute<CuSubCuenta, CuCuenta> idCuenta;
    public static volatile SingularAttribute<CuSubCuenta, BigDecimal> subcSaldo;

}