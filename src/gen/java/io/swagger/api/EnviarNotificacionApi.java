package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.EnviarNotificacionApiService;
import io.swagger.api.factories.EnviarNotificacionApiServiceFactory;

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


@Path("/enviarNotificacion")


@io.swagger.annotations.Api(description = "the enviarNotificacion API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")

public class EnviarNotificacionApi  {
   private final EnviarNotificacionApiService delegate;

   public EnviarNotificacionApi(@Context ServletConfig servletContext) {
      EnviarNotificacionApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("EnviarNotificacionApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (EnviarNotificacionApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = EnviarNotificacionApiServiceFactory.getEnviarNotificacionApi();
      }

      this.delegate = delegate;
   }


    @POST
    
    
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Envía una nueva notificación de alerta", notes = "Envía una nueva notificación de alerta", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Notificación enviada correctamente", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "", response = Void.class) })
    public Response enviarNotificacion(@ApiParam(value = "Identificador del usuario",required=true) @QueryParam("usuarioId") Long usuarioId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.enviarNotificacion(usuarioId,securityContext);
    }

}

