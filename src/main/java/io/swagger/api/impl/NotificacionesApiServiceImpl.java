package io.swagger.api.impl;

import com.google.gson.Gson;
import io.swagger.api.*;
import io.swagger.api.Entities.Notificacion;

import java.util.ArrayList;
import java.util.Date;


import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T17:02:48.240Z[GMT]")

public class NotificacionesApiServiceImpl extends NotificacionesApiService {

    private ArrayList<Notificacion> notificaciones = new ArrayList<>();
    
    @Override
    public Response actualizarNotificacion( @NotNull String usuarioId,  @NotNull String notificacionId,
                                            String alertaId,  Date fecha,  String estado,  String destinatario, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        Boolean flag = false;
        Notificacion notificacion;

        for (int i=0; i<notificaciones.size(); i++){
            if(notificaciones.get(i).getNotificacionId() == notificacionId){
                flag = true;

                notificacion = notificaciones.get(i);
                notificaciones.remove(i);

                notificacion.setUsuarioId(usuarioId);
                notificacion.setAlertaId(alertaId);
                notificacion.setFecha(fecha);
                notificacion.setEstado(estado);
                notificacion.setContacto(destinatario);

                notificaciones.add(i,notificacion);
            }
        }

        if(flag){
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Actualización realizada")).build();
        }else{
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No existe esa notificacion")).build();
        }
    }
    
    @Override
    public Response borrarNotificacion( @NotNull String usuarioId,  @NotNull String notificacionId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!

        Boolean flag = false;

        for(int i=0; i<notificaciones.size(); i++){
            if(notificaciones.get(i).getNotificacionId() == notificacionId){
                flag = true;
                notificaciones.remove(i);
            }
        }

        if(flag){
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Notificación eliminada")).build();
        }else{
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No existe esa notificacion")).build();
        }
    }
    
    @Override
    public Response crearNotificacion( @NotNull String usuarioId,  @NotNull String alertaId, SecurityContext securityContext) throws NotFoundException {

        boolean flag = false;
        String notificacionId = String.valueOf(notificaciones.size()-1);

        Notificacion notificacion = new Notificacion(usuarioId, alertaId, notificacionId);
        if(notificaciones.add(notificacion)){
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        }else{
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No ha sido posible insertar.")).build();
        }
    }
    
    @Override
    public Response obtenerNotificaciones( @NotNull String usuarioId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        ArrayList<Notificacion> results = new ArrayList<>();
        for (Notificacion n: notificaciones) {
            if(n.getUsuarioId() == usuarioId){
                results.add(n);
            }
        }

        if(results.size() > 0){
            Gson gson = new Gson();
            String JSON = gson.toJson(results);

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, JSON)).build();
        }else{
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No ha sido posible insertar.")).build();
        }
    }
    
}