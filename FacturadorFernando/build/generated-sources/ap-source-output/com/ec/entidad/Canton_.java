package com.ec.entidad;

import com.ec.entidad.Parroquia;
import com.ec.entidad.Provincia;
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
@StaticMetamodel(Canton.class)
public class Canton_ { 

    public static volatile SingularAttribute<Canton, Provincia> idProvincia;
    public static volatile SingularAttribute<Canton, Integer> cantNumero;
    public static volatile SingularAttribute<Canton, Integer> idCanton;
    public static volatile SingularAttribute<Canton, Boolean> cantEstado;
    public static volatile CollectionAttribute<Canton, Parroquia> parroquiaCollection;
    public static volatile SingularAttribute<Canton, String> cantNombre;

}