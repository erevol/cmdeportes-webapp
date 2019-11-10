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
public class Profesional {
    private int idProfesional;
    private int idTipo;
    private int legajo;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private int dni;
    private String direccion;
    private String telefono;
    private String matricula;
    private String urlFoto;

    public Profesional() {
    }

    public Profesional(int idProfesional, int idTipo,int legajo, String nombre, 
            String apellido, String fechaNac, int dni, String direccion, 
            String telefono, String matricula, String urlFoto) {
        this.idProfesional = idProfesional;
        this.idTipo = idTipo;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.matricula = matricula;
        this.urlFoto = urlFoto;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Profesional{" + "idProfesional=" + idProfesional + ", idTipo=" + idTipo + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", matricula=" + matricula + ", urlFoto=" + urlFoto + '}';
    }
}
