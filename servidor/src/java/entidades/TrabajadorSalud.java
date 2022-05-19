/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arcke
 */
@Entity
@Table(name = "trabajador_salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrabajadorSalud.findAll", query = "SELECT t FROM TrabajadorSalud t"),
    @NamedQuery(name = "TrabajadorSalud.findByIdTrabajadorSalud", query = "SELECT t FROM TrabajadorSalud t WHERE t.idTrabajadorSalud = :idTrabajadorSalud"),
    @NamedQuery(name = "TrabajadorSalud.findByCedulaProfesional", query = "SELECT t FROM TrabajadorSalud t WHERE t.cedulaProfesional = :cedulaProfesional"),
    @NamedQuery(name = "TrabajadorSalud.findByContrasenia", query = "SELECT t FROM TrabajadorSalud t WHERE t.contrasenia = :contrasenia"),
    @NamedQuery(name = "TrabajadorSalud.findByNombreTrabajadorSalud", query = "SELECT t FROM TrabajadorSalud t WHERE t.nombreTrabajadorSalud = :nombreTrabajadorSalud")})
public class TrabajadorSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_trabajador_salud")
    private Integer idTrabajadorSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cedula_profesional")
    private String cedulaProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_trabajador_salud")
    private String nombreTrabajadorSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTrabajadorSalud")
    private Collection<Citas> citasCollection;

    public TrabajadorSalud() {
    }

    public TrabajadorSalud(Integer idTrabajadorSalud) {
        this.idTrabajadorSalud = idTrabajadorSalud;
    }

    public TrabajadorSalud(Integer idTrabajadorSalud, String cedulaProfesional, String contrasenia, String nombreTrabajadorSalud) {
        this.idTrabajadorSalud = idTrabajadorSalud;
        this.cedulaProfesional = cedulaProfesional;
        this.contrasenia = contrasenia;
        this.nombreTrabajadorSalud = nombreTrabajadorSalud;
    }

    public Integer getIdTrabajadorSalud() {
        return idTrabajadorSalud;
    }

    public void setIdTrabajadorSalud(Integer idTrabajadorSalud) {
        this.idTrabajadorSalud = idTrabajadorSalud;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreTrabajadorSalud() {
        return nombreTrabajadorSalud;
    }

    public void setNombreTrabajadorSalud(String nombreTrabajadorSalud) {
        this.nombreTrabajadorSalud = nombreTrabajadorSalud;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrabajadorSalud != null ? idTrabajadorSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrabajadorSalud)) {
            return false;
        }
        TrabajadorSalud other = (TrabajadorSalud) object;
        if ((this.idTrabajadorSalud == null && other.idTrabajadorSalud != null) || (this.idTrabajadorSalud != null && !this.idTrabajadorSalud.equals(other.idTrabajadorSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TrabajadorSalud[ idTrabajadorSalud=" + idTrabajadorSalud + " ]";
    }
    
}
