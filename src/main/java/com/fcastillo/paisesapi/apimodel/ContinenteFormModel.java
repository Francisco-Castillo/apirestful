package com.fcastillo.paisesapi.apimodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author fcastillo
 */
@ApiModel(value = "Continente")
public class ContinenteFormModel {

    @ApiModelProperty(position = 1)
    private int idContinente;

    @ApiModelProperty(position = 2)
    private String nombre;

    public ContinenteFormModel() {
    }

    public ContinenteFormModel(int idContinente, String nombre) {
        this.idContinente = idContinente;
        this.nombre = nombre;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
