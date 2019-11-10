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
public class Orden {
    private int idOrden;
    private int idPaciente;
    private int idProfesional;
    private int idDisciplina;
    private int cantPracticas;
    private int minMensuales;
    private String fecha;

    public Orden(int idOrden, int idPaciente, int idProfesional, int idDisciplina, int cantPracticas, int minMensuales, String fecha) {
        this.idOrden = idOrden;
        this.idPaciente = idPaciente;
        this.idProfesional = idProfesional;
        this.idDisciplina = idDisciplina;
        this.cantPracticas = cantPracticas;
        this.minMensuales = minMensuales;
        this.fecha = fecha;
    }

    public Orden() {
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getCantPracticas() {
        return cantPracticas;
    }

    public void setCantPracticas(int cantPracticas) {
        this.cantPracticas = cantPracticas;
    }

    public int getMinMensuales() {
        return minMensuales;
    }

    public void setMinMensuales(int minMensuales) {
        this.minMensuales = minMensuales;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", idPaciente=" + idPaciente + ", idProfesional=" + idProfesional + ", idDisciplina=" + idDisciplina + ", cantPracticas=" + cantPracticas + ", minMensuales=" + minMensuales + ", fecha=" + fecha + '}';
    }
}
