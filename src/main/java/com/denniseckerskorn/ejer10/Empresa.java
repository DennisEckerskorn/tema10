package com.denniseckerskorn.ejer10;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Empresa {
    private final List<Empleado> empleados;
    private final Random rnd;

    public Empresa() {
        this.empleados = new ArrayList<>();
        this.rnd = new Random();
        generarEmpleadosAleatorios(40);
    }

    private void generarEmpleadosAleatorios(int cantidadEmpleados) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidadEmpleados; i++) {
            String dni = String.format("%08d", rnd.nextInt());
            String nombre = faker.name().firstName();
            String apellidos = faker.name().lastName();
            LocalDate fechaNacimiento = faker.date().birthdayLocalDate();
            float sueldo = rnd.nextFloat(4001);
            int cantidadHijos = rnd.nextInt(11);
            Empleado empleadoGenerado = addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            if (empleadoGenerado.getCantidadHijos() > 0) {
                for (int j = 0; j < cantidadHijos; j++) {
                    String nombreHijo = faker.name().firstName();
                    LocalDate fechaNacimientoHijo = faker.date().birthdayLocalDate(0, 30);
                    empleadoGenerado.addHijo(nombreHijo, fechaNacimientoHijo);
                }
            }
        }
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

    public Empleado obtenerEmpleadoPorNombre(String nombre) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(nombre)) {
                return empleados.get(i);
            }
        }
        return null;
    }

    public List<Empleado> obtenerEmpleadosPorRangoEdad(int edadMin, int edadMax) {
        List<Empleado> rangosEdad = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getEdadEmpleado() >= edadMin && empleados.get(i).getEdadEmpleado() <= edadMax) {
                rangosEdad.add(empleados.get(i));
            }
        }
        return rangosEdad;
    }

    public List<Empleado> obtenerEmpleadosPorSueldo(float minSueldo, float maxSueldo) {
        List<Empleado> rangoSueldos = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getSueldo() >= minSueldo && empleados.get(i).getSueldo() >= maxSueldo) {
                rangoSueldos.add(empleados.get(i));
            }
        }
        return rangoSueldos;
    }

    //TODO: Needs correcting and testing
    public List<Empleado> obtenerEmpleadosHijosMenoresEdad() {
        List<Empleado> hijosMenoresEdad = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getHijos() != null) {
                for (int j = 0; j < empleados.get(j).getHijos().size(); j++) {
                    if (empleados.get(j).getHijos().size() > 18) {
                        hijosMenoresEdad.add(empleados.get(i));
                    }
                }
            }
        }
        return hijosMenoresEdad;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "empleados=" + empleados +
                '}' + "\n";
    }
}
