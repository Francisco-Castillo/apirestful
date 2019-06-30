package com.fcastillo.paisesapi.interfaces;

import com.fcastillo.paisesapi.apimodel.PaisFormModel;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public interface OperacionesPais {

    public Response crear(PaisFormModel pais);

    public Response cambiar(PaisFormModel pais);

    public Response eliminar(int idPais);

    public Response obtener(int idPais);
}
