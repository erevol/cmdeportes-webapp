/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 * 
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
public class ReportePaciente {
    private int idOrden;
    private int idInscripcion;
    private int idPaciente;
    private String apellido;
    private String nombre;
    private int minMensuales;
    private int minRestantes;
    private int practicasRestantes;
    private String finalizado;

    public ReportePaciente() {
    }

    public ReportePaciente(int idOrden, int idInscripcion, int idPaciente, String apellido, String nombre, int minMensuales, int minRestantes, int practicasRestantes, String finalizado) {
        this.idOrden = idOrden;
        this.idInscripcion = idInscripcion;
        this.idPaciente = idPaciente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.minMensuales = minMensuales;
        this.minRestantes = minRestantes;
        this.practicasRestantes = practicasRestantes;
        this.finalizado = finalizado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinMensuales() {
        return minMensuales;
    }

    public void setMinMensuales(int minMensuales) {
        this.minMensuales = minMensuales;
    }

    public int getMinRestantes() {
        return minRestantes;
    }

    public void setMinRestantes(int minRestantes) {
        this.minRestantes = minRestantes;
    }

    public int getPracticasRestantes() {
        return practicasRestantes;
    }

    public void setPracticasRestantes(int practicasRestantes) {
        this.practicasRestantes = practicasRestantes;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "ReportePaciente{" + "idOrden=" + idOrden + ", idInscripcion=" + idInscripcion + ", idPaciente=" + idPaciente + ", apellido=" + apellido + ", nombre=" + nombre + ", minMensuales=" + minMensuales + ", minRestantes=" + minRestantes + ", practicasRestantes=" + practicasRestantes + ", finalizado=" + finalizado + '}';
    }
}
