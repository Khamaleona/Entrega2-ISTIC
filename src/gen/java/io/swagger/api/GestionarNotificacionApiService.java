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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")

public abstract class GestionarNotificacionApiService {
    
    public abstract Response actualizarNotificacion( @NotNull Long usuarioId, @NotNull Long notificacionId, String tipo, Date fecha, String estado, String destinatario,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response borrarNotificacion( @NotNull Long usuarioId, @NotNull Long notificacionId,SecurityContext securityContext) throws NotFoundException;
    
}

