package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private List<Hijo> hijos;
    private final String dni;
    private final String nombre;
    private final String apellidos;
    private final LocalDate fechaNacimiento;
    private float sueldo;
    private int cantidadHijos;

    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, float sueldo, int cantidadHijos) {
        this.hijos = new ArrayList<>();
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
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

    public void setSueldo(float nuevoSueldo) {
        sueldo = nuevoSueldo;
    }

    public void incrementaCantidadHijosEmpleado() {
        cantidadHijos += 1;
    }

    public void decrementaCantidadHijosEmpleado() {
        cantidadHijos -= 1;
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

    public boolean addHijo(String nombre, LocalDate fechaNacimiento) {
        if (hijos != null) {
            hijos.add(new Hijo(nombre, fechaNacimiento));
            return true;
        }
        return false;
    }

    /**
     * Elimina el array de hijos y totalmente poniendolo a null.
     */
    public void removeHijosList() {
        hijos = null;
    }

    public boolean removeHijo(String nombreHijo) {
        for (int i = 0; i < hijos.size(); i++) {
            if (hijos.get(i).getNombre().equals(nombreHijo)) {
                hijos.remove(i);
                return true;
            }
        }
        return false;
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
                ", cantidadHijos=" + cantidadHijos +
                '}';
    }
}
