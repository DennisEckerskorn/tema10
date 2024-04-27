package com.denniseckerskorn.ejer10;

import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
    private final List<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Método que añade un nuevo empleado al array de empleados, si tiene hijos tambien los añadira al array de hijos del empleado.
     * @param dni
     * @param nombre
     * @param apellidos
     * @param fechaNacimiento
     * @param sueldo
     * @param cantidadHijos
     * @return
     */
    public Empleado addNuevoEmpleado(String dni, String nombre, String apellidos, String fechaNacimiento, float sueldo, int cantidadHijos) {
        try {
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            empleados.add(nuevoEmpleado);
            return nuevoEmpleado;
        } catch (DateTimeParseException dtpe) {
            System.out.println("El formato de la fecha se ha introducido incorrectamente, dd/MM/yyyy");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados +
                '}';
    }
}
