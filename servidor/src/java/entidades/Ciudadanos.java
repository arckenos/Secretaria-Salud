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
@Table(name = "ciudadanos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadanos.findAll", query = "SELECT c FROM Ciudadanos c"),
    @NamedQuery(name = "Ciudadanos.findByIdCiudadano", query = "SELECT c FROM Ciudadanos c WHERE c.idCiudadano = :idCiudadano"),
    @NamedQuery(name = "Ciudadanos.findByCurpCiudadano", query = "SELECT c FROM Ciudadanos c WHERE c.curpCiudadano = :curpCiudadano"),
    @NamedQuery(name = "Ciudadanos.findByNombreCiudadano", query = "SELECT c FROM Ciudadanos c WHERE c.nombreCiudadano = :nombreCiudadano"),
    @NamedQuery(name = "Ciudadanos.findByFechaNacimiento", query = "SELECT c FROM Ciudadanos c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Ciudadanos.findByLugarResidencia", query = "SELECT c FROM Ciudadanos c WHERE c.lugarResidencia = :lugarResidencia"),
    @NamedQuery(name = "Ciudadanos.findByHuellaDigital", query = "SELECT c FROM Ciudadanos c WHERE c.huellaDigital = :huellaDigital")})
public class Ciudadanos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ciudadano")
    private Integer idCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "curp_ciudadano")
    private String curpCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_ciudadano")
    private String nombreCiudadano;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugar_residencia")
    private String lugarResidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "huella_digital")
    private String huellaDigital;

    public Ciudadanos() {
    }

    public Ciudadanos(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public Ciudadanos(Integer idCiudadano, String curpCiudadano, String nombreCiudadano, Date fechaNacimiento, String lugarResidencia, String huellaDigital) {
        this.idCiudadano = idCiudadano;
        this.curpCiudadano = curpCiudadano;
        this.nombreCiudadano = nombreCiudadano;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarResidencia = lugarResidencia;
        this.huellaDigital = huellaDigital;
    }

    public Integer getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Integer idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    public String getCurpCiudadano() {
        return curpCiudadano;
    }

    public void setCurpCiudadano(String curpCiudadano) {
        this.curpCiudadano = curpCiudadano;
    }

    public String getNombreCiudadano() {
        return nombreCiudadano;
    }

    public void setNombreCiudadano(String nombreCiudadano) {
        this.nombreCiudadano = nombreCiudadano;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getHuellaDigital() {
        return huellaDigital;
    }

    public void setHuellaDigital(String huellaDigital) {
        this.huellaDigital = huellaDigital;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudadano != null ? idCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadanos)) {
            return false;
        }
        Ciudadanos other = (Ciudadanos) object;
        if ((this.idCiudadano == null && other.idCiudadano != null) || (this.idCiudadano != null && !this.idCiudadano.equals(other.idCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ciudadanos[ idCiudadano=" + idCiudadano + " ]";
    }
    
}
