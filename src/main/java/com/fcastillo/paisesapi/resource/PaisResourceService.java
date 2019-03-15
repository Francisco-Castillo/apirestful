package com.fcastillo.paisesapi.resource;

import com.fcastillo.paisesapi.Pais;
import com.fcastillo.paisesapi.Provincia;
import com.fcastillo.paisesapi.criterios.ComparatorNombrePais;
import com.fcastillo.paisesapi.criterios.ComparatorPoblacion;
import com.fcastillo.paisesapi.ejb.PaisFacadeLocal;
import com.fcastillo.paisesapi.utilidades.Respuesta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Default;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
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
import com.fcastillo.paisesapi.interfaces.Operaciones;
import java.util.stream.*;

@Path("/Pais")
@Api(value = "/Pais")
@Produces(MediaType.APPLICATION_JSON)
public class PaisResourceService implements Operaciones {

    private static final int NOMBRE_OFICIAL = 1;
    private static final int NOMBRE_CORTO = 2;
    private static final int CANTIDAD_DE_HABITANTES = 3;

    private static final int ORDEN_ASCENDENTE = 4;
    private static final int ORDEN_DESCENTE = 5;
    private Pais pais;

    private List<Pais> lstPaises = new ArrayList<>();

    @EJB
    PaisFacadeLocal paisEJB;
    JsonObject paisJson;

    @Override
    @POST
    @Path("/Crear")
    @ApiOperation(value = "Crea un nuevo pais", notes = "Inserta en la base de datos un nuevo pais")
    public Response crear(
            @ApiParam(value = "Nombre del pais") @FormParam("nombreLargo") String nombreLargo,
            @ApiParam(value = "Nombre corto") @FormParam("nombreCorto") String nombreCorto
    ) {
        pais = new Pais();
        pais.setPaisNombreLargo(nombreLargo);
        pais.setPaisNombreCorto(nombreCorto);
        paisEJB.create(pais);
        return Response.status(Response.Status.CREATED).build();
    }

    @Override
    @PUT
    @Path("/Cambiar/{id}")
    public Response actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @DELETE
    @Path("/Remove/{id}")
    @ApiOperation(value = "Permite eliminar un pais")
    public Response eliminar(@ApiParam(value = "Codigo de pais") @PathParam("id") int p) {

        pais = paisEJB.find(p);
        if (pais == null) {
            Respuesta r = new Respuesta();
            r.setCodigoDeEstado(0);
            r.setMensaje("No se encontro el pais con ID: " + p);
            return Response.status(Response.Status.NOT_FOUND).entity(r).build();
        }
        Respuesta r = new Respuesta();
        r.setCodigoDeEstado(200);
        r.setMensaje("Removido exitosamente");
        paisEJB.remove(pais);
        return Response.status(Response.Status.OK).entity(r).build();

    }

    @Override
    @GET
    @Path("/GetLista")
    @ApiOperation(value = "Retorna una lista de paises")
    public Response obtenerTodos(
            @ApiParam(value = "Id Continente") @QueryParam("idContinente") int idContinente,
            @ApiParam(value = "sort") @QueryParam("sort") int sort,
            @ApiParam(value = "search") @QueryParam("search") String search,
            @ApiParam(value = "order") @QueryParam("order") int order,
            @ApiParam(value = "offset") @QueryParam("offset") Integer offset,
            @ApiParam(value = "limit") @QueryParam("limit") Integer limit
    ) {
        List<Pais> nuevaLista;
        Long totalPaises = paisEJB.cantidadTotalDePaises();
        if (idContinente != 0) {
            lstPaises = paisEJB.findByContinente(idContinente);
        } else {
            lstPaises = paisEJB.findByParameters(offset, limit);
        }
        
        if (search != null) {
            nuevaLista = lstPaises.stream().filter(x -> x.getPaisNombreCorto().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        } else {
            nuevaLista = lstPaises;
        }
        
        JsonArrayBuilder arregloPaises = Json.createArrayBuilder();
        JsonArrayBuilder arregloProvincias = Json.createArrayBuilder();
        JsonObjectBuilder objetoJson;
        nuevaLista.stream().forEach((p) -> {
            p.getProvinciaCollection().stream().forEach((a) -> {
                arregloProvincias.add(Json.createObjectBuilder()
                        .add("id", a.getProvinciaId())
                        .add("Nombre", a.getProvinciaNombre())
                        .add("abreviatura", a.getProvinciaAbreviatura())
                        .add("latitud", a.getProvinciaLatitud())
                        .add("longitud", a.getProvinciaLongitud()));
            });
            arregloPaises.add(Json.createObjectBuilder()
                    .add("Id", p.getPaisId())
                    .add("nombreLargo", p.getPaisNombreLargo())
                    .add("nombreCorto", p.getPaisNombreCorto())
                    .add("abreviatura", p.getPaisAbreviatura())
                    .add("capital", p.getPaisCapital())
                    .add("poblacion", p.getPaisPoblacion())
                    .add("bandera", "resources/banderas/" + p.getBandera())
                    .add("continente", Json.createObjectBuilder()
                            .add("id", p.getContinenteId().getContinenteId())
                            .add("nombre", p.getContinenteId().getContinenteNombre()))
                    .add("provincias", arregloProvincias));
        });

        objetoJson = Json.createObjectBuilder().add("status", 200).add("total", totalPaises).add("paises", arregloPaises);
        return Response.ok(objetoJson.build()).build();
    }

    @Override
    @GET
    @Path("/GetPais/{Id}")
    @ApiOperation(value = "Permite obtener un pais", notes = "Para obtener un pais debe ingresar su código (Id)")
    public Response obtener(@ApiParam(value = "Codigo de pais") @QueryParam("Id") int codigo) {
        pais = paisEJB.find(codigo);
        if (pais == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        paisJson = Json.createObjectBuilder()
                .add("codigo", pais.getPaisId())
                .add("nombreLargo", pais.getPaisNombreLargo())
                .add("nombreCorto", pais.getPaisNombreCorto())
                .add("abreviatura", pais.getPaisAbreviatura())
                .build();
        return Response.status(Response.Status.OK).entity(paisJson.toString()).build();
    }

    @Override
    @GET
    @Path("/GetFormData")
    @ApiOperation(value = "Retorna datos para trabajar con formularios")
    public Response getFormData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
