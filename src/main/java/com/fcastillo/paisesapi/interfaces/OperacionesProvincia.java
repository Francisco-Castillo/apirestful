package com.fcastillo.paisesapi.interfaces;

import com.fcastillo.paisesapi.apimodel.ProvinciaFormModel;
import javax.ws.rs.core.Response;

/**
 *
 * @author fcastillo
 */
public interface OperacionesProvincia {

    public Response crear(ProvinciaFormModel provincia);

    public Response cambiar(ProvinciaFormModel provincia);

    public Response eliminar(int idProvincia);

    public Response obtener(int idProvincia);

}
