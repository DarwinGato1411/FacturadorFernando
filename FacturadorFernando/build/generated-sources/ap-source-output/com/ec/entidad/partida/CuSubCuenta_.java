package com.ec.entidad.partida;

import com.ec.entidad.partida.CuCuenta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
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