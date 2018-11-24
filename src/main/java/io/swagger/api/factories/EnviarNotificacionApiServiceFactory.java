package io.swagger.api.factories;

import io.swagger.api.EnviarNotificacionApiService;
import io.swagger.api.impl.EnviarNotificacionApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-23T18:08:58.527Z[GMT]")
public class EnviarNotificacionApiServiceFactory {
    private final static EnviarNotificacionApiService service = new EnviarNotificacionApiServiceImpl();

    public static EnviarNotificacionApiService getEnviarNotificacionApi() {
        return service;
    }
}
