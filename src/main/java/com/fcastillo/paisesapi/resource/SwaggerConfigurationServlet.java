
package com.fcastillo.paisesapi.resource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.models.Info;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author fcastillo
 * @since 30 de Junio de 2019
 * @version 2.0
 */
@WebServlet(name = "SwaggerConfigurationServlet", loadOnStartup = 2)
public class SwaggerConfigurationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

  
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        BeanConfig beanConfig = new BeanConfig();
      
        beanConfig.setBasePath("paisesAPI/api");
        beanConfig.setHost("localhost:8080");
        beanConfig.setTitle("API RESTful con JAX-RS");
        beanConfig.setDescription("API desarrollada con propositos educativos para el taller de Interoperabilidad con Servcios Web | FCEyT - UNSE");
        beanConfig.setContact("cefrancastillo@gmail.com");
        beanConfig.setVersion("1.0.0");
        beanConfig.setResourcePackage("com.fcastillo.paisesapi.resource");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
        beanConfig.setSchemes(new String[]{"http"});
       
        

    }

}
