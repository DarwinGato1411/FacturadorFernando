package com.ec.entidad.partida;

import com.ec.entidad.partida.CuGrupo;
import com.ec.entidad.partida.CuSubCuenta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-09-20T14:00:40")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-03T19:05:36")
>>>>>>> 325327ab12bbd95aaa3f955d341ce684d4836ab4
@StaticMetamodel(CuCuenta.class)
public class CuCuenta_ { 

    public static volatile SingularAttribute<CuCuenta, BigDecimal> grupTotal;
    public static volatile SingularAttribute<CuCuenta, String> grupNumero;
    public static volatile SingularAttribute<CuCuenta, BigDecimal> grupSaldo;
    public static volatile CollectionAttribute<CuCuenta, CuSubCuenta> cuSubCuentaCollection;
    public static volatile SingularAttribute<CuCuenta, Integer> idCuenta;
    public static volatile SingularAttribute<CuCuenta, String> grupNombre;
    public static volatile SingularAttribute<CuCuenta, BigDecimal> grupOtro;
    public static volatile SingularAttribute<CuCuenta, CuGrupo> idGrupo;

}