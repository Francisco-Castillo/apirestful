package com.fcastillo.paisesapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public class NotFoundException extends WebApplicationException {

    /**
     * HTTP 404 (Not Found) exception.
     *
     * @param message String que representa el nombre de la entidad que generó la respuesta 404
     */
    public NotFoundException(ErrorMessage message) {
        super(Response.status(Response.Status.NOT_FOUND).entity(message).type("application/json").build());
    }

}
