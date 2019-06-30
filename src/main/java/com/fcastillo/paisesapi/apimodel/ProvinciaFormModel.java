package com.fcastillo.paisesapi.apimodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "provincia")
public class ProvinciaFormModel {

    private int idProvincia;
    private String nombre;
    private String abreviatura;
    private String latitud;
    private String longitud;
    private int idPais;

    @ApiModelProperty(position = 1)
    @NotNull(message = "Provincia se esperab")
    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    @ApiModelProperty(position = 2, required = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @ApiModelProperty(position = 3, required = true, name = "abreviatura")
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @ApiModelProperty(position = 4, required = true, name = "latitud")
    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    @ApiModelProperty(position = 5, required = true, name = "longitud")
    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @ApiModelProperty(position = 6, required = true)
    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public boolean validate() {
        boolean valido = true;
        if (nombre.equals("") && abreviatura.equals("") && latitud.equals("") && longitud.equals("")  && idPais == 0) {
            valido = false;
        }
        return valido;
    }
}
