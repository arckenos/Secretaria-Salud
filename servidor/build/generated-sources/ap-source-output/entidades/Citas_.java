package entidades;

import entidades.Pacientes;
import entidades.TrabajadorSalud;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-05-19T18:07:32")
@StaticMetamodel(Citas.class)
public class Citas_ { 

    public static volatile SingularAttribute<Citas, Pacientes> idPaciente;
    public static volatile SingularAttribute<Citas, Integer> idCitas;
    public static volatile SingularAttribute<Citas, TrabajadorSalud> idTrabajadorSalud;

}