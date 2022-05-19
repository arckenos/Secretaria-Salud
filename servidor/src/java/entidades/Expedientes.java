/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arcke
 */
@Entity
@Table(name = "expedientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expedientes.findAll", query = "SELECT e FROM Expedientes e"),
    @NamedQuery(name = "Expedientes.findByIdExpediente", query = "SELECT e FROM Expedientes e WHERE e.idExpediente = :idExpediente"),
    @NamedQuery(name = "Expedientes.findByNombreDocumento", query = "SELECT e FROM Expedientes e WHERE e.nombreDocumento = :nombreDocumento"),
    @NamedQuery(name = "Expedientes.findByTipoDocumento", query = "SELECT e FROM Expedientes e WHERE e.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Expedientes.findByFechaDocumento", query = "SELECT e FROM Expedientes e WHERE e.fechaDocumento = :fechaDocumento"),
    @NamedQuery(name = "Expedientes.findByDescripcion", query = "SELECT e FROM Expedientes e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Expedientes.findByComentarios", query = "SELECT e FROM Expedientes e WHERE e.comentarios = :comentarios"),
    @NamedQuery(name = "Expedientes.findByEsAccesible", query = "SELECT e FROM Expedientes e WHERE e.esAccesible = :esAccesible")})
public class Expedientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_expediente")
    private Integer idExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_documento")
    private String nombreDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_documento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDocumento;
    @Basic(optional = false)    
    @Lob
    @Column(name = "archivo_documento")
    private byte[] archivoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "es_accesible")
    private short esAccesible;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Pacientes idPaciente;

    public Expedientes() {
    }

    public Expedientes(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public Expedientes(Integer idExpediente, String nombreDocumento, String tipoDocumento, Date fechaDocumento, byte[] archivoDocumento, String descripcion, String comentarios, short esAccesible) {
        this.idExpediente = idExpediente;
        this.nombreDocumento = nombreDocumento;
        this.tipoDocumento = tipoDocumento;
        this.fechaDocumento = fechaDocumento;
        this.archivoDocumento = archivoDocumento;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.esAccesible = esAccesible;
    }

    public Integer getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(Integer idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public byte[] getArchivoDocumento() {
        return archivoDocumento;
    }

    public void setArchivoDocumento(byte[] archivoDocumento) {
        this.archivoDocumento = archivoDocumento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public short getEsAccesible() {
        return esAccesible;
    }

    public void setEsAccesible(short esAccesible) {
        this.esAccesible = esAccesible;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpediente != null ? idExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expedientes)) {
            return false;
        }
        Expedientes other = (Expedientes) object;
        if ((this.idExpediente == null && other.idExpediente != null) || (this.idExpediente != null && !this.idExpediente.equals(other.idExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Expedientes[ idExpediente=" + idExpediente + " ]";
    }
    
}
