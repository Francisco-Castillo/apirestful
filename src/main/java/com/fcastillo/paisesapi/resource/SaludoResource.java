/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
@Path("/Hola")
//@Api(value = "/Hola", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
public class SaludoResource {

    @GET
    @Path("/{nombre}")
    public Response getMsg( @PathParam("nombre") String mensaje) {
        String salida = "Bienvenido " + mensaje;
        return Response.status(200).entity(salida).build();
    }
}
