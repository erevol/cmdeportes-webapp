/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * 
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
public class Inscripcion {
    private int idInscripcion;
    private int idOrden;
    private String usuario;
    private String fecha;

    public Inscripcion() {
    }

    public Inscripcion(int idInscripcion, int idOrden, String usuario, String fecha) {
        this.idInscripcion = idInscripcion;
        this.idOrden = idOrden;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", idOrden=" + idOrden + ", usuario=" + usuario + ", fecha=" + fecha + '}';
    }
}
