package com.fcastillo.paisesapi.resource;

//<editor-fold defaultstate="collapsed" desc="imports">
import com.fcastillo.paisesapi.Continente;
import com.fcastillo.paisesapi.apimodel.ContinenteFormModel;
import com.fcastillo.paisesapi.ejb.ContinenteFacadeLocal;
import com.fcastillo.paisesapi.exception.ConflictException;
import com.fcastillo.paisesapi.exception.ErrorMessage;
import com.fcastillo.paisesapi.exception.NotFoundException;
import com.fcastillo.paisesapi.interfaces.OperacionesContinente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//</editor-fold>

/**
 *
 * @author Francisco Castillo
 * @version 1.0
 * @since Julio 2019
 */
@Path("/Continente")
@Api(value = "Continente")
public class ContinenteResourceService implements OperacionesContinente {

    //<editor-fold defaultstate="collapsed" desc="fields">
    @EJB
    ContinenteFacadeLocal continenteEJB;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="crear()">
    @Override
    @POST
    @Path("Crear")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Añadir un nuevo continente")
    public Response crear(@ApiParam(value = "Continente", name = "form") ContinenteFormModel form) {

        if (continenteEJB.exists(form.getIdContinente())) {
            ErrorMessage errorMessage = new ErrorMessage("409", "El continente con el ID: " + form.getIdContinente() + " ya se encuentra registrado", "", Response.Status.CONFLICT);
            throw new ConflictException(errorMessage);
        }
        Continente continente = new Continente(form.getNombre());
        continenteEJB.create(continente);
        return Response.status(Response.Status.CREATED).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="cambiar()">
    @Override
    @POST
    @Path("Cambiar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Actualizar información de un continente")
    public Response cambiar(@ApiParam(value = "Continente", name = "form") ContinenteFormModel form) {
        Continente continente = continenteEJB.find(form.getIdContinente());

        if (continente == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Continente no encontrado", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }

        continente.setContinenteId(form.getIdContinente());
        continente.setContinenteNombre(form.getNombre());

        continenteEJB.edit(continente);
        return Response.status(Response.Status.OK).build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="eliminar()">
    @Override
    @DELETE
    @Path("Eliminar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Eliminar continente")
    public Response eliminar(@ApiParam(value = "id continente", name = "id") @PathParam("id") int idContinente) {
        Continente continente = continenteEJB.find(idContinente);

        if (continente == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Continente no encontrado", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }

        continenteEJB.remove(continente);
        return Response.ok().build();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="obtener()">
    @Override
    @GET
    @Path("Get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Buscar continente por su Id")
    public Response obtener(@ApiParam(value = "id continente", name = "idContinente") @QueryParam("idContinente") int idContinente) {
        Continente continente = continenteEJB.find(idContinente);

        if (continente == null) {
            ErrorMessage errorMessage = new ErrorMessage("404", "Continente no encontrado", "", Response.Status.NOT_FOUND);
            throw new NotFoundException(errorMessage);
        }
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", continente.getContinenteId());
        job.add("nombre", continente.getContinenteNombre());

        return Response.status(Response.Status.OK).entity(job.build()).build();
    }//</editor-fold>

}
