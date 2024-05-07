package com.denniseckerskorn.pruebasiterator;

import java.util.Comparator;
import java.util.Objects;

public class Persona implements Comparable<Persona>{
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final int estatura;

    public Persona(String dni, String nombre, String apellidos, int estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estatura = estatura;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEstatura() {
        return estatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(dni);
        result = 31 * result + Objects.hashCode(nombre);
        result = 31 * result + Objects.hashCode(apellidos);
        return result;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
    @Override
    public int compareTo(Persona o) {
        return nombre.compareTo(o.nombre);
    }

    public static class ComparatorDni implements Comparator<Persona> {
        @Override
        public int compare(Persona o1, Persona o2) {
            return o1.getDni().compareTo(o2.getDni());
        }
    }

    public static class ComparatorEstatura implements Comparator<Persona> {
        @Override
        public int compare(Persona o1, Persona o2) {
            return o1.getEstatura() - o2.getEstatura();
        }
    }
}
