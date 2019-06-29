package com.fcastillo.paisesapi.exception;

import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public class ErrorMessage {

    public String codigo;
    public String descripcion;
    public String enlace;
    public Response.Status status;

    public ErrorMessage(String codigo, String descripcion, String enlace, Response.Status status) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.status = status;
    }

}
