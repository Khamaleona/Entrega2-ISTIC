package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import java.util.Date;


import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T17:02:48.240Z[GMT]")

public abstract class NotificacionesApiService {
    
    public abstract Response actualizarNotificacion( @NotNull String usuarioId, @NotNull String notificacionId, String alertaId, Date fecha, String estado, String destinatario,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response borrarNotificacion( @NotNull String usuarioId, @NotNull String notificacionId,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response crearNotificacion( @NotNull String usuarioId, @NotNull String alertaId,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response obtenerNotificaciones( @NotNull String usuarioId,SecurityContext securityContext) throws NotFoundException;
    
}