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
public class ReporteProfesional {
    private int legajo;
    private String apellido;
    private String nombre;
    private int ordenes;
    private int mes;
    private int anio;

    public ReporteProfesional() {
    }

    public ReporteProfesional(int legajo, String apellido, String nombre, int ordenes, int mes, int anio) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.ordenes = ordenes;
        this.mes = mes;
        this.anio = anio;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
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

    public int getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(int ordenes) {
        this.ordenes = ordenes;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "ReporteProfesional{" + "legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", ordenes=" + ordenes + ", mes=" + mes + ", anio=" + anio + '}';
    }
}
