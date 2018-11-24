package io.swagger.api.factories;

import io.swagger.api.NotificacionesApiService;
import io.swagger.api.impl.NotificacionesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T16:15:32.236Z[GMT]")
public class NotificacionesApiServiceFactory {
    private final static NotificacionesApiService service = new NotificacionesApiServiceImpl();

    public static NotificacionesApiService getNotificacionesApi() {
        return service;
    }
} 