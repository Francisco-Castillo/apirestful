package com.fcastillo.paisesapi.resource;

//<editor-fold defaultstate="collapsed" desc="imports">
import com.fcastillo.paisesapi.Pais;
import com.fcastillo.paisesapi.Provincia;
import com.fcastillo.paisesapi.apimodel.ProvinciaFormModel;
import com.fcastillo.paisesapi.ejb.ProvinciaFacadeLocal;
import com.fcastillo.paisesapi.exception.ErrorMessage;
import com.fcastillo.paisesapi.exception.NotFoundException;
import com.fcastillo.paisesapi.interfaces.OperacionesProvincia;
import com.fcastillo.paisesapi.interfaces.Pagination;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//</editor-fold>

@Path("/Provincia")
@Api(value = "Provincia")
public class ProvinciaResourceService implements OperacionesProvincia, Pagination {

    //<editor-fold defaultstate="collapsed" desc="fields">
    @EJB
    ProvinciaFacadeLocal provinciaEJB;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="crear()">
    @Override
    @POST
    @Path("Crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Añadir Provincia")
    public Response crear(@ApiParam(value = "provincia") ProvinciaFormModel provincia) {

        Provincia prv = new Provincia();
        Pais pais = new Pais();

        pais.setPaisId(provincia.getIdPais());
        prv.setProvinciaNombre(provincia.getNombre());
        prv.setProvinciaAbreviatura(provincia.getAbreviatura());
        prv.setProvinciaLatitud(provincia.getLatitud());
        prv.setProvinciaLongitud(provincia.getLongitud());
        prv.setPaisId(pais);

        return Response.status(Response.Status.CREATED).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="cambiar()">
    @Override
    @POST
    @Path("Cambiar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Actualizar información de una provincia")
    public Response cambiar(@ApiParam(value = "provincia", name = "form") ProvinciaFormModel form) {
        Provincia provActual = provinciaEJB.find(form.getIdProvincia());
        Pais pais = new Pais();

        if (provActual == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Provincia no encontrada", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }
        pais.setPaisId(form.getIdPais());
        provActual.setProvinciaNombre(form.getNombre());
        provActual.setProvinciaAbreviatura(form.getAbreviatura());
        provActual.setProvinciaLatitud(form.getLatitud());
        form.setLongitud(form.getLongitud());
        provActual.setPaisId(pais);

        provinciaEJB.edit(provActual);

        return Response.status(Response.Status.OK).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="eliminar()">
    @Override
    @DELETE
    @Path("Eliminar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Eliminar una provincia")
    public Response eliminar(@ApiParam(value = "Id Provincia", name = "id") @PathParam("id") int idProvincia) {
        Provincia prv = provinciaEJB.find(idProvincia);

        if (prv == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Provincia no encontrada", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }

        provinciaEJB.remove(prv);
        return Response.status(Response.Status.OK).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="obtener()">
    @Override
    @GET
    @Path("Get")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Buscar provincia por su Id")
    public Response obtener(@ApiParam(value = "id provincia", name = "idprovincia") @QueryParam("idprovincia") int idProvincia) {
        Provincia provincia = provinciaEJB.find(idProvincia);

        if (provincia == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Provincia no encontrada", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", provincia.getProvinciaId())
                .add("nombre", provincia.getProvinciaNombre())
                .add("abreviatura", provincia.getProvinciaAbreviatura())
                .add("ubicacion", Json.createObjectBuilder()
                        .add("latitud", provincia.getProvinciaLatitud())
                        .add("longitud", provincia.getProvinciaLongitud()));

        return Response.status(Response.Status.OK).entity(job.build()).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getList()">
    @Override
    @GET
    @Path("GetLista/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Retorna una lista de provincias", notes = "Permite paginar y filtrar")
    public Response getList(
            @ApiParam(name = "id") @QueryParam("id") int id,
            @ApiParam(name = "limit") @QueryParam("limit") @DefaultValue("10") int limit,
            @ApiParam(name = "offset") @QueryParam("offset") @DefaultValue("1") int offset,
            @ApiParam(name = "search") @QueryParam("search") String search) {
        List<Provincia> lstProvincia = provinciaEJB.getList(id, limit, offset, search);
        JsonArrayBuilder arrProvincias = Json.createArrayBuilder();
        for (Provincia p : lstProvincia) {
            arrProvincias.add(Json.createObjectBuilder()
                    .add("nombre", p.getProvinciaNombre()));
        }
        return Response.status(Response.Status.OK).entity(arrProvincias.build()).build();
    }//</editor-fold>

}
