package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Hijo {
    private final String nombre;
    private final LocalDate fechaNacimiento;

    public Hijo(String nombre, String fechaNacimiento) throws DateTimeParseException {
        this.nombre = nombre;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, dtf);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
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
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
