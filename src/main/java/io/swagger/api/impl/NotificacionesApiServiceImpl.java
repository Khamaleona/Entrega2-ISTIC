package io.swagger.api.impl;

import com.google.gson.Gson;
import io.swagger.api.*;
import io.swagger.api.Entities.Notificacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaJerseyServerCodegen", date = "2018-11-24T17:02:48.240Z[GMT]")

public class NotificacionesApiServiceImpl extends NotificacionesApiService {

    private ArrayList<Notificacion> notificaciones = new ArrayList<>();
    
    private void inicializarNotificaciones(){
        Notificacion n1 = new Notificacion("Irene","Alerta1","Notificacion1");
        Notificacion n2 = new Notificacion("Victor", "Alerta2", "Notificacion2");
        Notificacion n3 = new Notificacion("Irene", "Alerta3", "Notificacion3");
        
        Calendar cal = Calendar.getInstance();
        
        n1.setFecha(cal.getTime());
        n1.setContacto("617929906");
        n1.setEstado("Pendiente");
        
        n2.setFecha(cal.getTime());
        n2.setContacto("617929906");
        n2.setEstado("Pendiente");
        
        n3.setFecha(cal.getTime());
        n3.setContacto("617929906");
        n3.setEstado("Pendiente");
        
        notificaciones.add(n1);
        notificaciones.add(n2);
        notificaciones.add(n3);
    }
    
    @Override
    public Response actualizarNotificacion( @NotNull String usuarioId,  @NotNull String notificacionId,
                                            String alertaId,  Date fecha,  String estado,  String destinatario, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        Boolean flag = false;
        Notificacion notificacion;
        inicializarNotificaciones();

        for (int i=0; i<notificaciones.size(); i++){
            if(notificaciones.get(i).getNotificacionId().equals(notificacionId)){
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
        inicializarNotificaciones();

        for(int i=0; i<notificaciones.size(); i++){
            if(notificaciones.get(i).getNotificacionId().equals(notificacionId) && 
                notificaciones.get(i).getUsuarioId().equals(usuarioId)){
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

        inicializarNotificaciones();
        String notificacionId = String.valueOf(notificaciones.size());

        Notificacion notificacion = new Notificacion(usuarioId, alertaId, notificacionId);
        if(notificaciones.add(notificacion)){
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
        }else{
            String cadena = "No ha sido posible insertar. ";
            cadena+= usuarioId + " - " + alertaId;
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, cadena)).build();
        }
    }
    
    @Override
    public Response obtenerNotificaciones( @NotNull String usuarioId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        ArrayList<Notificacion> results = new ArrayList<>();
        inicializarNotificaciones();
        
        for (Notificacion n: notificaciones) {
            if(n.getUsuarioId().equals(usuarioId)){
                results.add(n);
            }
        }

        if(results.size() > 0){
            Gson gson = new Gson();
            String JSON = gson.toJson(results);

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, JSON)).build();
        }else{
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "No ha sido posible obtener las notificaciones.")).build();
        }
    }
    
}