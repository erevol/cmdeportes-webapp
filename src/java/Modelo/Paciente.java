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
public class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private int dni;
    private String direccion;
    private String obraSocial;
    private String telefono;
    private String telefonoUrg;
    private float altura;
    private float peso;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombre, String apellido, String fechaNac, int dni, String direccion, String obraSocial, String telefono, String telefonoUrg, float altura, float peso) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.dni = dni;
        this.direccion = direccion;
        this.obraSocial = obraSocial;
        this.telefono = telefono;
        this.telefonoUrg = telefonoUrg;
        this.altura = altura;
        this.peso = peso;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoUrg() {
        return telefonoUrg;
    }

    public void setTelefonoUrg(String telefonoUrg) {
        this.telefonoUrg = telefonoUrg;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", dni=" + dni + ", direccion=" + direccion + ", obraSocial=" + obraSocial + ", telefono=" + telefono + ", telefonoUrg=" + telefonoUrg + ", altura=" + altura + ", peso=" + peso + '}';
    }
    
}
