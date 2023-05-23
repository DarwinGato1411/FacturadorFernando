package com.ec.entidad.sri;

import com.ec.entidad.sri.CabeceraCompraSri;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T23:31:50")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-17T00:04:00")
>>>>>>> 17babff2bfe9902cab453961a400172c82173985
@StaticMetamodel(CategoriaCompras.class)
public class CategoriaCompras_ { 

    public static volatile SingularAttribute<CategoriaCompras, Integer> idCategoriaCompras;
    public static volatile SingularAttribute<CategoriaCompras, String> catcCodigo;
    public static volatile SingularAttribute<CategoriaCompras, String> catcNombre;
    public static volatile CollectionAttribute<CategoriaCompras, CabeceraCompraSri> cabeceraCompraSriCollection;
    public static volatile SingularAttribute<CategoriaCompras, Boolean> catcIsprincipal;

}