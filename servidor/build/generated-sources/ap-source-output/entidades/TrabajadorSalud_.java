package entidades;

import entidades.Citas;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-05-18T20:04:56")
@StaticMetamodel(TrabajadorSalud.class)
public class TrabajadorSalud_ { 

    public static volatile SingularAttribute<TrabajadorSalud, String> cedulaProfesional;
    public static volatile SingularAttribute<TrabajadorSalud, String> nombreTrabajadorSalud;
    public static volatile SingularAttribute<TrabajadorSalud, String> contrasenia;
    public static volatile CollectionAttribute<TrabajadorSalud, Citas> citasCollection;
    public static volatile SingularAttribute<TrabajadorSalud, Integer> idTrabajadorSalud;

}