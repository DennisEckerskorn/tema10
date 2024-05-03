package com.denniseckerskorn.ejer11;

import java.time.LocalDate;

public class Alumno {
    private static int nextNIA = 1;
    private final int nia;
    private final String nombre;
    private final String apellido;
    private final LocalDate fechaNacimiento;
    private final Grupo grupo;

    public Alumno(String nombre, String apellido, LocalDate fechaNacimiento, Grupo grupo) {
        nia = nextNIA;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
    }

    public int getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;
        return nia == alumno.nia;
    }

    @Override
    public int hashCode() {
        return nia;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nia=" + nia +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", grupo=" + grupo +
                '}';
    }
}
