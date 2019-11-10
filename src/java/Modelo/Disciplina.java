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
public class Disciplina {
    private int idDisciplina;
    private String nombre;

    public Disciplina() {
    }

    public Disciplina(int idDisciplina, String nombre) {
        this.idDisciplina = idDisciplina;
        this.nombre = nombre;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "idDisciplina=" + idDisciplina + ", nombre=" + nombre + '}';
    }
    
    
}
