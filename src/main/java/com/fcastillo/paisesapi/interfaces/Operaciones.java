package com.fcastillo.paisesapi.interfaces;

import com.fcastillo.paisesapi.utilidades.Respuesta;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface Operaciones {

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Respuesta exitosa", response = Respuesta.class),
        @ApiResponse(code = 404, message = "No se econtro codigo de pais"),
        @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")

    })
    public Response crear(String nombreLargo, String nombreCorto);

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Respuesta exitosa", response = Respuesta.class),
        @ApiResponse(code = 404, message = "No se econtro codigo de pais"),
        @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")

    })
    public Response actualizar();

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Respuesta exitosa", response = Respuesta.class),
        @ApiResponse(code = 404, message = "No se econtro codigo de pais"),
        @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")

    })
    public Response eliminar(int codigo);

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Exito", response = Respuesta.class),
        @ApiResponse(code = 404, message = "Recurso no encontrado"),
        @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    public Response obtener(int codigo);

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Exito", response = Respuesta.class),
        @ApiResponse(code = 404, message = "Recurso no encontrado"),
        @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    public Response obtenerTodos(int idContinente ,int sort, String search, int order, Integer offset, Integer limit);

    public Response getFormData();

}
