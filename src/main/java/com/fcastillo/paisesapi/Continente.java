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
@Table(name = "continente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continente.findAll", query = "SELECT c FROM Continente c"),
    @NamedQuery(name = "Continente.findByContinenteId", query = "SELECT c FROM Continente c WHERE c.continenteId = :continenteId"),
    @NamedQuery(name = "Continente.findByContinenteNombre", query = "SELECT c FROM Continente c WHERE c.continenteNombre = :continenteNombre")})
public class Continente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "continente_id")
    private Integer continenteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "continente_nombre")
    private String continenteNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "continenteId")
    private Collection<Pais> paisCollection;

    public Continente() {
    }

    public Continente(Integer continenteId) {
        this.continenteId = continenteId;
    }

    public Continente(Integer continenteId, String continenteNombre) {
        this.continenteId = continenteId;
        this.continenteNombre = continenteNombre;
    }

    public Integer getContinenteId() {
        return continenteId;
    }

    public void setContinenteId(Integer continenteId) {
        this.continenteId = continenteId;
    }

    public String getContinenteNombre() {
        return continenteNombre;
    }

    public void setContinenteNombre(String continenteNombre) {
        this.continenteNombre = continenteNombre;
    }

    @XmlTransient
    public Collection<Pais> getPaisCollection() {
        return paisCollection;
    }

    public void setPaisCollection(Collection<Pais> paisCollection) {
        this.paisCollection = paisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (continenteId != null ? continenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continente)) {
            return false;
        }
        Continente other = (Continente) object;
        if ((this.continenteId == null && other.continenteId != null) || (this.continenteId != null && !this.continenteId.equals(other.continenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fcastillo.paisesapi.Continente[ continenteId=" + continenteId + " ]";
    }
    
}
