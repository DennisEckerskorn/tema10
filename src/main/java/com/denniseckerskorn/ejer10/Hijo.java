package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase que representa un hijo de un empleado con sus atributos necesarios.
 */
public class Hijo {
    private final String nombre;
    private final LocalDate fechaNacimiento;

    /**
     * Constructor de un hijo, recibe dos parámetros:
     *
     * @param nombre          String, nombre del hijo.
     * @param fechaNacimiento LocqlDate, la fecha de nacimiento del hijo.
     */
    public Hijo(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter del nombre del hijo.
     *
     * @return String, nombre del hijo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de la fecha de nacimiento del hijo.
     *
     * @return LocalDate, fecha de nacimiento del hijo.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que calcula la edad a paritir de la fecha de nacimiento.
     * Usa LocalDate para obtener la fecha actual y calcula la diferencia en años entre la fecha de nacimiento y ahora.
     *
     * @return int, la edad en números enteros, solo los años.
     */
    public int getEdadHijo() {
        LocalDate ahora = LocalDate.now();
        Period period = Period.between(fechaNacimiento, ahora);
        return period.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hijo hijo = (Hijo) o;
        return nombre.equals(hijo.nombre) && fechaNacimiento.equals(hijo.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento + '\'' +
                ", edad=" + getEdadHijo() +
                '}';
    }
}
