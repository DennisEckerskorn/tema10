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
     * Método que añade un nuevo empleado al array de empleados.
     * @param dni
     * @param nombre
     * @param apellidos
     * @param fechaNacimiento
     * @param sueldo
     * @param cantidadHijos
     * @return
     */
    public boolean addNuevoEmpleado(String dni, String nombre, String apellidos, String fechaNacimiento, float sueldo, int cantidadHijos) {
        try {
            Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            empleados.add(nuevoEmpleado);
            if(cantidadHijos > 0) {
                addNuevoHijoAEmpleado(nuevoEmpleado, cantidadHijos);
            }
            return true;
        } catch (DateTimeParseException dtpe) {
            System.out.println("El formato de la fecha se ha introducido incorrectamente, dd/MM/yyyy");
            return false;
        }
    }

    public boolean addNuevoHijoAEmpleado(Empleado empleado, int cantidadHijos) {
        try{
            for(int i = 0; i < cantidadHijos; i++) {
                Hijo nuevoHijo = new Hijo(nombre, fechaNacimiento);
            }

        }
        return
    }


}
