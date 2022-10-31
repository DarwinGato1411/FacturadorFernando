package com.ec.entidad;

import com.ec.entidad.Canton;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
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