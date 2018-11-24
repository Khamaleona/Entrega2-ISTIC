package io.swagger.api.factories;

import io.swagger.api.GestionarNotificacionApiService;
import io.swagger.api.impl.GestionarNotificacionApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")
public class GestionarNotificacionApiServiceFactory {
    private final static GestionarNotificacionApiService service = new GestionarNotificacionApiServiceImpl();

    public static GestionarNotificacionApiService getGestionarNotificacionApi() {
        return service;
    }
}
