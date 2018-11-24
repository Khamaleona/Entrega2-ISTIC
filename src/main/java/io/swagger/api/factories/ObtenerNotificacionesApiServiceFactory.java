package io.swagger.api.factories;

import io.swagger.api.ObtenerNotificacionesApiService;
import io.swagger.api.impl.ObtenerNotificacionesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")
public class ObtenerNotificacionesApiServiceFactory {
    private final static ObtenerNotificacionesApiService service = new ObtenerNotificacionesApiServiceImpl();

    public static ObtenerNotificacionesApiService getObtenerNotificacionesApi() {
        return service;
    }
}
