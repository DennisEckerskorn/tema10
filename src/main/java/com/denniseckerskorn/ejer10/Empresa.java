package com.denniseckerskorn.ejer10;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
    private final List<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    /**
     * Método que añade un nuevo empleado a la lista de empleados
     *
     * @param dni
     * @param nombre
     * @param apellidos
     * @param fechaNacimiento
     * @param sueldo
     * @param cantidadHijos
     * @return
     */
    public Empleado addNuevoEmpleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, float sueldo, int cantidadHijos) {
        if (empleados != null) {
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            empleados.add(nuevoEmpleado);
            return nuevoEmpleado;
        }
        return null;
    }

    /**
     * Obtiene el empleado a partir del DNI proporcionado.
     *
     * @param dni
     * @return
     */
    public Empleado obtenerEmpleadoPorDNI(String dni) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                return empleados.get(i);
            }
        }
        return null;
    }

    public boolean borrarEmpleado(Empleado empleado) {
        empleado.removeHijosList();
        return empleados.remove(empleado);
    }



    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados +
                '}';
    }
}
