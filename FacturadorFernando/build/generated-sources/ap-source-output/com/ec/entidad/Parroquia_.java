package com.ec.entidad;

import com.ec.entidad.Canton;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-20T18:48:08")
@StaticMetamodel(Parroquia.class)
public class Parroquia_ { 

    public static volatile SingularAttribute<Parroquia, String> parrZona;
    public static volatile SingularAttribute<Parroquia, Boolean> parrEstado;
    public static volatile SingularAttribute<Parroquia, BigDecimal> parrPrecio;
    public static volatile SingularAttribute<Parroquia, Integer> parrNumero;
    public static volatile SingularAttribute<Parroquia, BigDecimal> parrKiloAdicional;
    public static volatile SingularAttribute<Parroquia, Canton> idCanton;
    public static volatile CollectionAttribute<Parroquia, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Parroquia, Integer> idParroquia;
    public static volatile SingularAttribute<Parroquia, String> parrNombre;

}