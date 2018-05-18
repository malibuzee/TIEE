package com.malibuzee.sisteval.model;

/**
 * Created by F129 on 10/04/2018.
 */

public class AlumnoModelo {

    private String matricula, nombres, apellidos, edad, serial_alum;

    public AlumnoModelo(String matricula, String nombres, String apellidos, String edad, String serial_alum) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.serial_alum = serial_alum;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSerial_alum() {
        return serial_alum;
    }

    public void setSerial_alum(String serial_alum) {
        this.serial_alum = serial_alum;
    }
}