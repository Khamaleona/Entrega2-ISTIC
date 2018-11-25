package io.swagger.api.Entities;
import java.util.Calendar;
import java.util.Date;

public class Notificacion {

    private String usuarioId;
    private String notificacionId;
    private String alertaId;
    private Date fecha;
    private String estado;
    private String contacto;

    public Notificacion(String usuarioId, String alertaId, String notificacionId){
        this.notificacionId = notificacionId;
        this.usuarioId = usuarioId;
        this.alertaId = alertaId;

        Calendar cal = Calendar.getInstance();

        this.fecha = cal.getTime();
        this.contacto = "123456789";
        this.estado = "pendiente";
    }

    public String getNotificacionId() {
        return notificacionId;
    }

    public void setNotificacionId(String notificacionId) {
        this.notificacionId = notificacionId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getAlertaId() {
        return alertaId;
    }

    public void setAlertaId(String alertaId) {
        this.alertaId = alertaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
}