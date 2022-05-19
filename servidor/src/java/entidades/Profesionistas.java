/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arcke
 */
@Entity
@Table(name = "profesionistas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesionistas.findAll", query = "SELECT p FROM Profesionistas p"),
    @NamedQuery(name = "Profesionistas.findByIdProfesionista", query = "SELECT p FROM Profesionistas p WHERE p.idProfesionista = :idProfesionista"),
    @NamedQuery(name = "Profesionistas.findByNombreProfesionista", query = "SELECT p FROM Profesionistas p WHERE p.nombreProfesionista = :nombreProfesionista"),
    @NamedQuery(name = "Profesionistas.findByNumeroCedulaProfesional", query = "SELECT p FROM Profesionistas p WHERE p.numeroCedulaProfesional = :numeroCedulaProfesional"),
    @NamedQuery(name = "Profesionistas.findByGrado", query = "SELECT p FROM Profesionistas p WHERE p.grado = :grado")})
public class Profesionistas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesionista")
    private Integer idProfesionista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_profesionista")
    private String nombreProfesionista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "numero_cedula_profesional")
    private String numeroCedulaProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grado")
    private String grado;

    public Profesionistas() {
    }

    public Profesionistas(Integer idProfesionista) {
        this.idProfesionista = idProfesionista;
    }

    public Profesionistas(Integer idProfesionista, String nombreProfesionista, String numeroCedulaProfesional, String grado) {
        this.idProfesionista = idProfesionista;
        this.nombreProfesionista = nombreProfesionista;
        this.numeroCedulaProfesional = numeroCedulaProfesional;
        this.grado = grado;
    }

    public Integer getIdProfesionista() {
        return idProfesionista;
    }

    public void setIdProfesionista(Integer idProfesionista) {
        this.idProfesionista = idProfesionista;
    }

    public String getNombreProfesionista() {
        return nombreProfesionista;
    }

    public void setNombreProfesionista(String nombreProfesionista) {
        this.nombreProfesionista = nombreProfesionista;
    }

    public String getNumeroCedulaProfesional() {
        return numeroCedulaProfesional;
    }

    public void setNumeroCedulaProfesional(String numeroCedulaProfesional) {
        this.numeroCedulaProfesional = numeroCedulaProfesional;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesionista != null ? idProfesionista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesionistas)) {
            return false;
        }
        Profesionistas other = (Profesionistas) object;
        if ((this.idProfesionista == null && other.idProfesionista != null) || (this.idProfesionista != null && !this.idProfesionista.equals(other.idProfesionista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Profesionistas[ idProfesionista=" + idProfesionista + " ]";
    }
    
}
