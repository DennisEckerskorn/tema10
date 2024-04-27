package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private final List<Hijo> hijos;
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private final float sueldo;
    private final int cantidadHijos;

    public Empleado(String dni, String nombre, String apellidos, String fechaNacimiento, float sueldo, int cantidadHijos) throws DateTimeParseException {
        this.hijos = new ArrayList<>();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, dtf);
        this.sueldo = sueldo;
        this.cantidadHijos = cantidadHijos;
    }

    public List<Hijo> getHijos() {
        return hijos;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public int getCantidadHijos() {
        return cantidadHijos;
    }

    /**
     * Método que calcula la edad a partir de la fecha de nacimiento.
     *
     * @return la edad en números enteros.
     */
    public int getEdadEmpleado() {
        LocalDate ahora = LocalDate.now();
        Period period = Period.between(fechaNacimiento, ahora);
        return period.getYears();
    }

    public boolean addHijo(int cantidadHijos, String nombre, String fechaNacimiento) {
        try {
            hijos.add(new Hijo(nombre, fechaNacimiento));
            return true;
        } catch (DateTimeParseException dtpe) {
            System.out.println("El formato de la fecha se ha introducido incorrectamente, dd/MM/yyyy");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;
        return dni.equals(empleado.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "hijos=" + hijos +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldo=" + sueldo +
                '}';
    }
}
