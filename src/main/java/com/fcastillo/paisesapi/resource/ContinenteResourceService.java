/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.resource;

import com.fcastillo.paisesapi.Continente;
import com.fcastillo.paisesapi.ejb.ContinenteFacadeLocal;
import com.fcastillo.paisesapi.interfaces.Operaciones;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
@Path("/Continente")
@Api(value = "Continente")
public class ContinenteResourceService implements Operaciones {

    @EJB
    ContinenteFacadeLocal continenteEJB;
    private List<Continente> lstContinente;
    private Continente continente;

    @Override
    @POST
    @Path("/Crear")
    public Response crear(
            @ApiParam("Nombre") @FormParam("nombre") String nombreLargo,
            @ApiParam("corto") @FormParam("corto") String nombreCorto) {
        return Response.ok().build();
    }

    @Override
    public Response actualizar() {
        return Response.ok().build();
    }

    @Override
    public Response eliminar(int codigo) {
        return Response.ok().build();
    }

    @Override
    @GET
    @Path("/Get/{id}")
    public Response obtener(@ApiParam(value = "id") @PathParam("id") int codigo) {
        continente = continenteEJB.find(codigo);
        if (continente == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        JsonObjectBuilder job = Json.createObjectBuilder().add("continente", Json.createObjectBuilder()
                .add("id", continente.getContinenteId())
                .add("nombre", continente.getContinenteNombre()));
        return Response.status(Response.Status.OK).entity(job.build()).build();
    }

    @Override
    @GET
    @Path("/GetLista")
    @ApiOperation(value = "Retorna una lista de continentes")
    public Response obtenerTodos(
            @ApiParam("offset") @QueryParam("offset") @DefaultValue("0") Integer offset,
            @ApiParam("limit") @QueryParam("limit") @DefaultValue("5") Integer limit,
            @ApiParam("search") @QueryParam("search") String search,
            @ApiParam("sort") @QueryParam("sort") int sort,
            @ApiParam("order") @QueryParam("order") int order
    ) {
        lstContinente = continenteEJB.findByParameters(offset, limit);
        JsonArrayBuilder arregloContinente = Json.createArrayBuilder();
        JsonObjectBuilder job;
        if (lstContinente == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for (Continente item : lstContinente) {
            arregloContinente.add(Json.createObjectBuilder()
                    .add("id", item.getContinenteId())
                    .add("nombre", item.getContinenteNombre()));
        }
        job = Json.createObjectBuilder().add("continente", arregloContinente);
        return Response.status(Response.Status.OK).entity(job.build()).build();
    }

    @Override
    public Response getFormData() {
        return Response.ok().build();
    }

}
