/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcastillo.paisesapi.resource;

import com.fcastillo.paisesapi.Provincia;
import com.fcastillo.paisesapi.ejb.ProvinciaFacadeLocal;
import com.fcastillo.paisesapi.interfaces.Operaciones;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.persistence.Query;
import javax.transaction.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Provincia")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Provincia")
public class ProvinciaResourceService implements Operaciones {

    @EJB
    ProvinciaFacadeLocal provinciaEJB;
    private List<Provincia> lstProvincia;
    private Provincia provincia;

    @Override
    public Response crear(String nombreLargo, String nombreCorto) {
        return Response.ok().build();
    }

    @Override
    @PUT
    @Path("/Cambiar")
    public Response actualizar() {
        return Response.ok().build();
    }

    @Override
    @DELETE
    @Path("/Eliminar")
    public Response eliminar(@ApiParam(value = "Codigo") @QueryParam("codigo") int codigo) {
        return Response.ok().build();
    }

    @Override
    @GET
    @Path("/Get/{id}")
    public Response obtener(@ApiParam(value = "codigo") @PathParam("id") int codigo) {
        provincia = provinciaEJB.find(codigo);
        if (provincia == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        JsonObjectBuilder job = Json.createObjectBuilder().add("provincia",Json.createObjectBuilder()
                .add("id", provincia.getProvinciaId())
                .add("nombre", provincia.getProvinciaNombre())
                .add("abreviatura", provincia.getProvinciaAbreviatura())
                .add("latitud", provincia.getProvinciaLatitud())
                .add("longitud", provincia.getProvinciaLongitud()))
                    .add("pais", Json.createObjectBuilder()
                        .add("id", provincia.getPaisId().getPaisId())
                            .add("nombre", provincia.getPaisId().getPaisNombreLargo()));
        return Response.status(Response.Status.OK).entity(job.build()).build();
    }
    /*
    @Override
    @GET
    @Path("/GetLista")
    public Response obtenerTodos(
            @ApiParam(value = "offset") @QueryParam("offset") Integer offset,
            @ApiParam(value = "limit") @QueryParam("limit") Integer limit,
            @ApiParam(value = "search") @QueryParam("search") String search,
            @ApiParam(value = "sort") @QueryParam("sort") int sort,
            @ApiParam(value = "order") @QueryParam("order") int order
    ) {
        lstProvincia = provinciaEJB.findAll();
        JsonArrayBuilder arregloProvincias = Json.createArrayBuilder();
        JsonObjectBuilder objetoJson;
        if (lstProvincia.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        for (Provincia item : lstProvincia) {
            arregloProvincias.add(Json.createObjectBuilder()
                    .add("id", item.getProvinciaId())
                    .add("nombre", item.getProvinciaNombre())
                    .add("abreviatura", item.getProvinciaAbreviatura())
                    .add("latitud", item.getProvinciaLatitud())
                    .add("longitud", item.getProvinciaLongitud())
                    .add("pais", Json.createObjectBuilder()
                            .add("id", item.getPaisId().getPaisId())
                            .add("nombrePais", item.getPaisId().getPaisNombreLargo())));
        }
        objetoJson = Json.createObjectBuilder().add("provincias", arregloProvincias);

        return Response.status(Response.Status.OK).entity(objetoJson.build()).build();
    }*/

    @Override
    @GET
    @Path("/GetFormData")
    public Response getFormData() {
        return Response.ok().build();
    }

    @Override
    public Response obtenerTodos(int idContinente, int sort, String search, int order, Integer offset, Integer limit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
