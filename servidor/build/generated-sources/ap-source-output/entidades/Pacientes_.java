package entidades;

import entidades.Citas;
import entidades.Expedientes;
import entidades.Pacientes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-05-18T20:04:56")
@StaticMetamodel(Pacientes.class)
public class Pacientes_ { 

    public static volatile SingularAttribute<Pacientes, Integer> idPaciente;
    public static volatile SingularAttribute<Pacientes, Pacientes> tutorPaciente;
    public static volatile SingularAttribute<Pacientes, String> fechaNacimiento;
    public static volatile CollectionAttribute<Pacientes, Expedientes> expedientesCollection;
    public static volatile SingularAttribute<Pacientes, String> contrasenia;
    public static volatile CollectionAttribute<Pacientes, Citas> citasCollection;
    public static volatile SingularAttribute<Pacientes, String> nombreCompleto;
    public static volatile CollectionAttribute<Pacientes, Pacientes> pacientesCollection;
    public static volatile SingularAttribute<Pacientes, String> curpPaciente;

}