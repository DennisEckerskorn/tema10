package com.denniseckerskorn.ejer11;

public class Profesor {
    private final String dni;
    private final String nombre;
    private final String apellido;
    private final float sueldo;

    public Profesor(String dni, String nombre, String apellido, float sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public float getSueldo() {
        return sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor profesor = (Profesor) o;
        return dni.equals(profesor.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sueldo=" + sueldo +
                '}' + "\n";
    }
}
