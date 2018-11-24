package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;



import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T13:08:53.384Z[GMT]")

public abstract class ObtenerNotificacionesApiService {
    
    public abstract Response obtenerNotificaciones( @NotNull Long usuarioId,SecurityContext securityContext) throws NotFoundException;
    
}

