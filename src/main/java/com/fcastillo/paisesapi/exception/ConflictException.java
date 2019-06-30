package com.fcastillo.paisesapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public class ConflictException extends WebApplicationException {

    /**
     * HTTP 409 (Conflict) exception
     *
     * @param message
     */
    public ConflictException(ErrorMessage message) {
        super(Response.status(Response.Status.CONFLICT).entity(message).type("application/json").build());
    }

}
