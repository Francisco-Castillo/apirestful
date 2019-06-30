package com.fcastillo.paisesapi.apimodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fcastillo
 */
@ApiModel(value = "Pais")
public class PaisFormModel {
    @ApiModelProperty(position = 1)
    @NotNull(message = "Provincia se esperab")
    private int idPais;
    @ApiModelProperty(position = 2)
    @NotNull(message = "Provincia se esperab")
    private String nombreLargo;
    @ApiModelProperty(position = 3)
    @NotNull(message = "Provincia se esperab")
    private String nombreCorto;
    @ApiModelProperty(position = 4)
    @NotNull(message = "Provincia se esperab")
    private String abreviatura;
    @ApiModelProperty(position = 5)
    @NotNull(message = "Provincia se esperab")
    private String capital;
    @ApiModelProperty(position = 6)
    @NotNull(message = "Provincia se esperab")
    private int poblacion;
    @ApiModelProperty(position = 7)
    @NotNull(message = "Provincia se esperab")
    private String bandera;
    @ApiModelProperty(position = 8)
    @NotNull(message = "Provincia se esperab")
    private String resenia;
    @ApiModelProperty(position = 9)
    @NotNull(message = "Provincia se esperab")
    private int idContinente;

    public PaisFormModel(int idPais, String nombreLargo, String nombreCorto, String abreviatura, String capital, int poblacion, String bandera, String resenia, int idContinente) {
        this.idPais = idPais;
        this.nombreLargo = nombreLargo;
        this.nombreCorto = nombreCorto;
        this.abreviatura = abreviatura;
        this.capital = capital;
        this.poblacion = poblacion;
        this.bandera = bandera;
        this.resenia = resenia;
        this.idContinente = idContinente;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
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

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

}
