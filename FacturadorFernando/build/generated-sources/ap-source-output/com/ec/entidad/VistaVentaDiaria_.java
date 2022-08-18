package com.ec.entidad;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-18T17:29:41")
@StaticMetamodel(VistaVentaDiaria.class)
public class VistaVentaDiaria_ { 

    public static volatile SingularAttribute<VistaVentaDiaria, Date> fecha;
    public static volatile SingularAttribute<VistaVentaDiaria, String> venta;
    public static volatile SingularAttribute<VistaVentaDiaria, BigDecimal> total;
    public static volatile SingularAttribute<VistaVentaDiaria, Long> id;

}