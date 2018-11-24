package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.GestionarNotificacionApiService;
import io.swagger.api.factories.GestionarNotificacionApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import java.util.Date;


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


@Path("/gestionarNotificacion")


@io.swagger.annotations.Api(description = "the gestionarNotificacion API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")

public class GestionarNotificacionApi  {
   private final GestionarNotificacionApiService delegate;

   public GestionarNotificacionApi(@Context ServletConfig servletContext) {
      GestionarNotificacionApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("GestionarNotificacionApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (GestionarNotificacionApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = GestionarNotificacionApiServiceFactory.getGestionarNotificacionApi();
      }

      this.delegate = delegate;
   }


    @PUT
    
    
    @Produces({ "text/plain", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Actualiza una notificacion", notes = "Actualiza una notificacion", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "La actualización se ha realizado correctamente", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Los valores introducidos no son correctos", response = Object.class) })
    public Response actualizarNotificacion(@ApiParam(value = "Identificador del usuario",required=true) @QueryParam("usuarioId") Long usuarioId
,@ApiParam(value = "Identificador de la notificacion",required=true) @QueryParam("notificacionId") Long notificacionId
,@ApiParam(value = "gravedad de la notificacion") @QueryParam("tipo") String tipo
,@ApiParam(value = "fecha de la notificacion") @QueryParam("fecha") Date fecha
,@ApiParam(value = "Estado de la alerta", allowableValues="esperando, enviada") @QueryParam("estado") String estado
,@ApiParam(value = "destinatario de la notificacion") @QueryParam("destinatario") String destinatario
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.actualizarNotificacion(usuarioId,notificacionId,tipo,fecha,estado,destinatario,securityContext);
    }

    @DELETE
    
    
    @Produces({ "text/plain" })
    @io.swagger.annotations.ApiOperation(value = "Borra una notificación especifica", notes = "Borra una notificación especifica", response = String.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "El borrado se ha realizado correctamente", response = String.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "La notificacion no ha sido borrada", response = String.class) })
    public Response borrarNotificacion(@ApiParam(value = "Identificador del usuario",required=true) @QueryParam("usuarioId") Long usuarioId
,@ApiParam(value = "Identificador de la notificacion",required=true) @QueryParam("notificacionId") Long notificacionId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.borrarNotificacion(usuarioId,notificacionId,securityContext);
    }

}

