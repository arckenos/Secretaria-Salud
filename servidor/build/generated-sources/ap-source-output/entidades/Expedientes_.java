package entidades;

import entidades.Pacientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-05-23T02:10:22")
@StaticMetamodel(Expedientes.class)
public class Expedientes_ { 

    public static volatile SingularAttribute<Expedientes, byte[]> archivoDocumento;
    public static volatile SingularAttribute<Expedientes, String> descripcion;
    public static volatile SingularAttribute<Expedientes, Pacientes> idPaciente;
    public static volatile SingularAttribute<Expedientes, String> tipoDocumento;
    public static volatile SingularAttribute<Expedientes, Integer> idExpediente;
    public static volatile SingularAttribute<Expedientes, String> nombreDocumento;
    public static volatile SingularAttribute<Expedientes, Short> esAccesible;
    public static volatile SingularAttribute<Expedientes, Date> fechaDocumento;
    public static volatile SingularAttribute<Expedientes, String> comentarios;

}