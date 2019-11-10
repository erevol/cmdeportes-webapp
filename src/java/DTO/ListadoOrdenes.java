/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Modelo.Orden;

/**
 * 
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
public class ListadoOrdenes extends Orden {
    private String inscripto;

    public ListadoOrdenes() {
    }

    public ListadoOrdenes(int idOrden, int idPaciente, int idProfesional, int idDisciplina, int cantPracticas, int minMensuales, String fecha, String inscripto) {
        super(idOrden, idPaciente, idProfesional, idDisciplina, cantPracticas, minMensuales, fecha);
        this.inscripto = inscripto;
    }

    public ListadoOrdenes(String inscripto) {
        this.inscripto = inscripto;
    }

    public String getInscripto() {
        return inscripto;
    }

    public void setInscripto(String inscripto) {
        this.inscripto = inscripto;
    }

    @Override
    public String toString() {
        return "ListadoOrdenes{" + "inscripto=" + inscripto + '}';
    }
}
