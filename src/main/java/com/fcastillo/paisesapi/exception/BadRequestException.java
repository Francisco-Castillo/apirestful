
package com.fcastillo.paisesapi.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public class BadRequestException extends WebApplicationException {

    /**
     * HTTP 404 (Bad Request) Exception
     *
     * @param message
     */
    public BadRequestException(ErrorMessage message) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(message).type("application/json").build());
    }

}
