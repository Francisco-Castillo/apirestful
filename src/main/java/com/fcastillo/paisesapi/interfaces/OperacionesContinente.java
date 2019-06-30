package com.fcastillo.paisesapi.interfaces;

import com.fcastillo.paisesapi.apimodel.ContinenteFormModel;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public interface OperacionesContinente {

    public Response crear(ContinenteFormModel continente);

    public Response cambiar(ContinenteFormModel continente);

    public Response eliminar(int idContinente);

    public Response obtener(int idContinente);

}
