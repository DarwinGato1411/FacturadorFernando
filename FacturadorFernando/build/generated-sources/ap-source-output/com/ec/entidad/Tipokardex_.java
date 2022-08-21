package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-20T18:48:08")
@StaticMetamodel(Tipokardex.class)
public class Tipokardex_ { 

    public static volatile SingularAttribute<Tipokardex, Boolean> tidEstado;
    public static volatile SingularAttribute<Tipokardex, String> tipkDescripcion;
    public static volatile SingularAttribute<Tipokardex, String> tipkSigla;
    public static volatile CollectionAttribute<Tipokardex, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<Tipokardex, Integer> idTipokardex;

}