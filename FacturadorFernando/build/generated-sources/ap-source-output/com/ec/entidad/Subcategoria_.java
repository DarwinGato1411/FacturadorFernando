package com.ec.entidad;

import com.ec.entidad.Categoria;
import com.ec.entidad.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-11-26T22:12:27")
@StaticMetamodel(Subcategoria.class)
public class Subcategoria_ { 

    public static volatile SingularAttribute<Subcategoria, Integer> idSubCategoria;
    public static volatile SingularAttribute<Subcategoria, String> subCatDescripcion;
    public static volatile CollectionAttribute<Subcategoria, Producto> productoCollection;
    public static volatile SingularAttribute<Subcategoria, Categoria> idCategoria;

}