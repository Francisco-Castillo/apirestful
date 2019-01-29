/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fcastillo
 */
@Entity
@Table(name = "provincia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p"),
    @NamedQuery(name = "Provincia.findByProvinciaId", query = "SELECT p FROM Provincia p WHERE p.provinciaId = :provinciaId"),
    @NamedQuery(name = "Provincia.findByProvinciaNombre", query = "SELECT p FROM Provincia p WHERE p.provinciaNombre = :provinciaNombre"),
    @NamedQuery(name = "Provincia.findByProvinciaAbreviatura", query = "SELECT p FROM Provincia p WHERE p.provinciaAbreviatura = :provinciaAbreviatura"),
    @NamedQuery(name = "Provincia.findByProvinciaLatitud", query = "SELECT p FROM Provincia p WHERE p.provinciaLatitud = :provinciaLatitud"),
    @NamedQuery(name = "Provincia.findByProvinciaLongitud", query = "SELECT p FROM Provincia p WHERE p.provinciaLongitud = :provinciaLongitud")})
public class Provincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provincia_id")
    private Integer provinciaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "provincia_nombre")
    private String provinciaNombre;
    @Size(max = 5)
    @Column(name = "provincia_abreviatura")
    private String provinciaAbreviatura;
    @Size(max = 400)
    @Column(name = "provincia_latitud")
    private String provinciaLatitud;
    @Size(max = 400)
    @Column(name = "provincia_longitud")
    private String provinciaLongitud;
    @JoinColumn(name = "pais_id", referencedColumnName = "pais_id")
    @ManyToOne(optional = false)
    private Pais paisId;

    public Provincia() {
    }

    public Provincia(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public Provincia(Integer provinciaId, String provinciaNombre) {
        this.provinciaId = provinciaId;
        this.provinciaNombre = provinciaNombre;
    }

    public Integer getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(Integer provinciaId) {
        this.provinciaId = provinciaId;
    }

    public String getProvinciaNombre() {
        return provinciaNombre;
    }

    public void setProvinciaNombre(String provinciaNombre) {
        this.provinciaNombre = provinciaNombre;
    }

    public String getProvinciaAbreviatura() {
        return provinciaAbreviatura;
    }

    public void setProvinciaAbreviatura(String provinciaAbreviatura) {
        this.provinciaAbreviatura = provinciaAbreviatura;
    }

    public String getProvinciaLatitud() {
        return provinciaLatitud;
    }

    public void setProvinciaLatitud(String provinciaLatitud) {
        this.provinciaLatitud = provinciaLatitud;
    }

    public String getProvinciaLongitud() {
        return provinciaLongitud;
    }

    public void setProvinciaLongitud(String provinciaLongitud) {
        this.provinciaLongitud = provinciaLongitud;
    }

    public Pais getPaisId() {
        return paisId;
    }

    public void setPaisId(Pais paisId) {
        this.paisId = paisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinciaId != null ? provinciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincia)) {
            return false;
        }
        Provincia other = (Provincia) object;
        if ((this.provinciaId == null && other.provinciaId != null) || (this.provinciaId != null && !this.provinciaId.equals(other.provinciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fcastillo.paisesapi.Provincia[ provinciaId=" + provinciaId + " ]";
    }
    
}
