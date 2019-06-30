/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author fcastillo
 */
@Entity
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByPaisId", query = "SELECT p FROM Pais p WHERE p.paisId = :paisId"),
    @NamedQuery(name = "Pais.findByPaisNombreLargo", query = "SELECT p FROM Pais p WHERE p.paisNombreLargo = :paisNombreLargo"),
    @NamedQuery(name = "Pais.findByPaisNombreCorto", query = "SELECT p FROM Pais p WHERE p.paisNombreCorto = :paisNombreCorto"),
    @NamedQuery(name = "Pais.findByPaisAbreviatura", query = "SELECT p FROM Pais p WHERE p.paisAbreviatura = :paisAbreviatura"),
    @NamedQuery(name = "Pais.findByPaisCapital", query = "SELECT p FROM Pais p WHERE p.paisCapital = :paisCapital"),
    @NamedQuery(name = "Pais.findByPaisPoblacion", query = "SELECT p FROM Pais p WHERE p.paisPoblacion = :paisPoblacion"),
    @NamedQuery(name = "Pais.findByBandera", query = "SELECT p FROM Pais p WHERE p.bandera = :bandera"),
    @NamedQuery(name = "Pais.findByResenia", query = "SELECT p FROM Pais p WHERE p.resenia = :resenia")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pais_id")
    private Integer paisId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "pais_nombre_largo")
    private String paisNombreLargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pais_nombre_corto")
    private String paisNombreCorto;
    @Size(max = 5)
    @Column(name = "pais_abreviatura")
    private String paisAbreviatura;
    @Size(max = 50)
    @Column(name = "pais_capital")
    private String paisCapital;
    @Column(name = "pais_poblacion")
    private Integer paisPoblacion;
    @Size(max = 40)
    @Column(name = "bandera")
    private String bandera;
    @Size(max = 400)
    @Column(name = "resenia")
    private String resenia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisId")
    private Collection<Provincia> provinciaCollection;
    @JoinColumn(name = "continente_id", referencedColumnName = "continente_id")
    @ManyToOne(optional = false)
    private Continente continenteId;

    public Pais() {
    }

    public Pais(Integer paisId) {
        this.paisId = paisId;
    }

    public Pais(Integer paisId, String paisNombreLargo, String paisNombreCorto) {
        this.paisId = paisId;
        this.paisNombreLargo = paisNombreLargo;
        this.paisNombreCorto = paisNombreCorto;
    }

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getPaisNombreLargo() {
        return paisNombreLargo;
    }

    public void setPaisNombreLargo(String paisNombreLargo) {
        this.paisNombreLargo = paisNombreLargo;
    }

    public String getPaisNombreCorto() {
        return paisNombreCorto;
    }

    public void setPaisNombreCorto(String paisNombreCorto) {
        this.paisNombreCorto = paisNombreCorto;
    }

    public String getPaisAbreviatura() {
        return paisAbreviatura;
    }

    public void setPaisAbreviatura(String paisAbreviatura) {
        this.paisAbreviatura = paisAbreviatura;
    }

    public String getPaisCapital() {
        return paisCapital;
    }

    public void setPaisCapital(String paisCapital) {
        this.paisCapital = paisCapital;
    }

    public Integer getPaisPoblacion() {
        return paisPoblacion;
    }

    public void setPaisPoblacion(Integer paisPoblacion) {
        this.paisPoblacion = paisPoblacion;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    @XmlTransient
    public Collection<Provincia> getProvinciaCollection() {
        return provinciaCollection;
    }

    public void setProvinciaCollection(Collection<Provincia> provinciaCollection) {
        this.provinciaCollection = provinciaCollection;
    }

    public Continente getContinenteId() {
        return continenteId;
    }

    public void setContinenteId(Continente continenteId) {
        this.continenteId = continenteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fcastillo.paisesapi.Pais[ paisId=" + paisId + " ]";
    }
    
}
