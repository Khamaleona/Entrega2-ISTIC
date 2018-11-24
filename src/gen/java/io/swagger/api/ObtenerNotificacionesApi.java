package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ObtenerNotificacionesApiService;
import io.swagger.api.factories.ObtenerNotificacionesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;



import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

import javax.validation.constraints.*;


@Path("/obtenerNotificaciones")


@io.swagger.annotations.Api(description = "the obtenerNotificaciones API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T13:08:53.384Z[GMT]")

public class ObtenerNotificacionesApi  {
   private final ObtenerNotificacionesApiService delegate;

   public ObtenerNotificacionesApi(@Context ServletConfig servletContext) {
      ObtenerNotificacionesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ObtenerNotificacionesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ObtenerNotificacionesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ObtenerNotificacionesApiServiceFactory.getObtenerNotificacionesApi();
      }

      this.delegate = delegate;
   }


    @GET
    
    
    @Produces({ "application/json", "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Obtiene todas las notificaciones enviadas para el usuario dado", notes = "Obtiene todas las notificaciones enviadas para el usuario dado", response = Object.class, responseContainer = "List", tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Notificaciones obtenidas correctamente", response = Object.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "No ha podido realizarse dicha accion. Comprobar que el identificador introducido es correcto", response = String.class) })
    public Response obtenerNotificaciones(@ApiParam(value = "Identificador del Usuario",required=true) @QueryParam("usuarioId") Long usuarioId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.obtenerNotificaciones(usuarioId,securityContext);
    }

}

