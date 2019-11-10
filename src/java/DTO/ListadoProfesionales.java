/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import Modelo.Profesional;

/**
 * 
 * @author Eugenia Revol <euge.revol@gmail.com>
 */
public class ListadoProfesionales extends Profesional {
    private String posicion;

    public ListadoProfesionales(String posicion) {
        this.posicion = posicion;
    }

    public ListadoProfesionales(int idProfesional, int idTipo, int legajo, String nombre, String apellido, String fechaNac, int dni, String direccion, String telefono, String matricula, String urlFoto, String posicion) {
        super(idProfesional, idTipo, legajo, nombre, apellido, fechaNac, dni, direccion, telefono, matricula, urlFoto);
        this.posicion = posicion;
    }

    public ListadoProfesionales() {
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return super.toString() + "Profesionales{" + "posicion=" + posicion + '}';
    }
    
    
}
