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
public class ReporteInstructor {
    private int legajo;
    private String apellido;
    private String nombre;
    private int cantPracticasControladas;
    private int totalMin;
    private int pacientesAtendidos;

    public ReporteInstructor() {
    }

    public ReporteInstructor(int legajo, String apellido, String nombre, int cantPracticasControladas, int totalMin, int pacientesAtendidos) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cantPracticasControladas = cantPracticasControladas;
        this.totalMin = totalMin;
        this.pacientesAtendidos = pacientesAtendidos;
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

    public int getCantPracticasControladas() {
        return cantPracticasControladas;
    }

    public void setCantPracticasControladas(int cantPracticasControladas) {
        this.cantPracticasControladas = cantPracticasControladas;
    }

    public int getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(int totalMin) {
        this.totalMin = totalMin;
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }

    public void setPacientesAtendidos(int pacientesAtendidos) {
        this.pacientesAtendidos = pacientesAtendidos;
    }

    @Override
    public String toString() {
        return "ReporteInstructor{" + "legajo=" + legajo + ", apellido=" + apellido + ", nombre=" + nombre + ", cantPracticasControladas=" + cantPracticasControladas + ", totalMin=" + totalMin + ", pacientesAtendidos=" + pacientesAtendidos + '}';
    }
}
