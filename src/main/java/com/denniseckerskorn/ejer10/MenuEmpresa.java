package com.denniseckerskorn.ejer10;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class MenuEmpresa {
    private ConsoleMenu menu;
    private ConsoleMenu menuConsultas;
    private Empresa empresa;
    private Empleado empleadoActual;
    private Hijo hijo;

    public MenuEmpresa() {
        empresa = new Empresa();
        menu = new ConsoleMenu("GESTIÓN EMPLEADOS");
        menu.addOpcion("Nuevo Empleado");
        menu.addOpcion("Nuevo hijo");
        menu.addOpcion("Modificar sueldo");
        menu.addOpcion("Borrar empleado");
        menu.addOpcion("Borrar hijo");
        menu.addOpcion("Consultas");
        menu.addOpcion("Salir");

        menuConsultas = new ConsoleMenu("CONSULTAS EMPLEADOS");
        menuConsultas.addOpcion("Buscar por DNI");
        menuConsultas.addOpcion("Buscar por nombre");
        menuConsultas.addOpcion("Buscar por rango de edad");
        menuConsultas.addOpcion("Buscar por rando de sueldo");
        menuConsultas.addOpcion("Buscar por hijos menores de edad");
        menuConsultas.addOpcion("Volver al menú principal");

        System.out.println(empresa.toString());
        mainMenu();

    }

    private void mainMenu() {
        int opcion = 0;
        do {
            try {
                opcion = menu.mostrarMenuInt();
                switch (opcion) {
                    case 1: //Nuevo empleado
                        addNuevoEmpleado();
                        System.out.println(empresa.toString());
                        System.out.println(empleadoActual.toString());
                        break;
                    case 2: //Nuevo hijo
                        addHijoAEmpleadoExistente();
                        break;
                    case 3: //Modificar Sueldo
                        modificarSueldoEmpleado();
                        break;
                    case 4: //Borrar empleado
                        borrarEmpleado();
                        break;
                    case 5: //Borrar hijo
                        borrarHijo();
                        break;
                    case 6: //Menu consultas
                        menuConsultas();
                        break;
                    case 7: //Salir del programa
                        System.out.println("Leaving the program, see you soon...");
                        break;
                    default:
                        System.out.println("Numero no es válido");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("El valor ingresado no es un número, por favor introduce un número");
            }
        } while (opcion != 7);
    }

    private void menuConsultas() {
        try {
            int opcion = menuConsultas.mostrarMenuInt();
            switch (opcion) {
                case 1: //Buscar por DNI
                    buscarPorDNI();
                    break;
                case 2: //Buscar por nombre
                    buscarPorNombre();
                    break;
                case 3: //Buscar por rango de edad
                    buscarPorRangoEdad();
                    break;
                case 4: //Buscar por rango de sueldo
                    buscarPorRangoSueldos();
                    break;
                case 5: //Buscar por hijos menores de edad
                    buscarPorRangoHijosMenoresEdad();
                    break;
                case 6: //Salir del menuConsultas y volver al menu principal
                    return;
                default:
                    System.out.println("Numero no es válido");
                    break;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("El valor ingresado no es un número, por favor introduce un número");
        }
    }

    private void addNuevoEmpleado() {
        String dni = LibIO.requestString("Ingresa el DNI del empleado:", 8, 9);
        String nombre = LibIO.requestString("Ingresa el nombre del empleado: ", 3, 20);
        String apellidos = LibIO.requestString("Ingresa los apellidos del empleado: ", 3, 20);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LibIO.solicitarFechaLocalDate("Ingresa la fecha de nacimiento en formato dd/MM/yyyy:", dtf);
        float sueldo = LibIO.requestFloat("Ingresa el sueldo del empleado:", 600, 4000);
        int cantidadHijos = LibIO.requestInt("¿Cuantos hijos tiene el empleado?", 0, 20);

        if (cantidadHijos > 0) {
            empleadoActual = empresa.addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            for (int i = 0; i < cantidadHijos; i++) {
                String nombreHijo = LibIO.requestString("Ingresa el nombre del hijo:", 3, 20);
                LocalDate fechaNacimientoHijo = LibIO.solicitarFechaLocalDate("Ingresa la fecha de nacimiento del hijo, en formato dd/MM/yyyy:", dtf);
                empleadoActual.addHijo(nombreHijo, fechaNacimientoHijo);
            }
        } else {
            empleadoActual = empresa.addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
        }
    }

    private void addHijoAEmpleadoExistente() {
        String dni = LibIO.requestString("Ingresa el DNI del empleado buscado:", 8, 9);
        empleadoActual = empresa.obtenerEmpleadoPorDNI(dni);
        if (empleadoActual != null) {
            System.out.println("El empleado " + empleadoActual + " con DNI: " + dni + " existe!");
            String nombreHijo = LibIO.requestString("Ingresa el nombre del Hijo:", 3, 20);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimientoHijo = LibIO.solicitarFechaLocalDate("Ingresa la fecha de nacimiento del hijo", dtf);
            if (empleadoActual.addHijo(nombreHijo, fechaNacimientoHijo)) {
                empleadoActual.incrementaCantidadHijosEmpleado();
                System.out.println("El hijo con nombre: " + nombreHijo + " se ha añadido con éxito al Empleado: " + empleadoActual);
            } else {
                System.out.println("No se ha podido añadir el hijo al Empleado, prueba otra vez...");
            }
        } else {
            System.out.println("El Empleado con DNI " + dni + " no existe.");
        }
    }

    private void modificarSueldoEmpleado() {
        String dni = LibIO.requestString("Ingresa el DNI del Empleado buscado:", 8, 9);
        empleadoActual = empresa.obtenerEmpleadoPorDNI(dni);
        if (empleadoActual != null) {
            System.out.println("El Empleado " + empleadoActual + " con DNI: " + dni + " existe!");
            System.out.println("El Sueldo actual del empleado son: " + empleadoActual.getSueldo() + " Euros");
            float nuevoSueldo = LibIO.requestFloat("Ingresa el nuevo sueldo del Empleado", 600, 5000);
            empleadoActual.setSueldo(nuevoSueldo);
            System.out.println("El Sueldo actual del Empleado " + empleadoActual + " son: " + empleadoActual.getSueldo() + " Euros");
        }
    }

    private void borrarEmpleado() {
        String dni = LibIO.requestString("Ingresa el DNI del Empleado buscado:", 8, 9);
        empleadoActual = empresa.obtenerEmpleadoPorDNI(dni);
        if (empleadoActual != null) {
            System.out.println("El Empleado " + empleadoActual + " con DNI: " + dni + " existe!");
            if (empresa.borrarEmpleado(empleadoActual)) {
                System.out.println("El empleado se ha borrado con éxito");
            }
        }
    }

    private void borrarHijo() {
        String dni = LibIO.requestString("Ingresa el DNI del Empleado buscado:", 8, 9);
        empleadoActual = empresa.obtenerEmpleadoPorDNI(dni);
        if (empleadoActual != null) {
            System.out.println("El Empleado " + empleadoActual + " con DNI: " + dni + " existe!");
            String nombreHijo = LibIO.requestString("Ingresa el nombre del hijo que quieres borrar:", 3, 20);
            if (empleadoActual.removeHijo(nombreHijo)) {
                empleadoActual.decrementaCantidadHijosEmpleado();
                System.out.println("El hijo con nombre " + nombreHijo + " se ha eliminado correctamente del Empleado: " + empleadoActual);
            } else {
                System.out.println("No se ha podido eliminar el hijo del empleado " + empleadoActual);
            }
        }
    }

    private void buscarPorDNI() {
        String dni = LibIO.requestString("Ingresa el DNI del Empleado buscado:", 8, 9);
        empleadoActual = empresa.obtenerEmpleadoPorDNI(dni);
        if (empleadoActual != null) {
            System.out.println(empleadoActual);
        } else {
            System.out.println("El empleado con DNI " + dni + " no existe");
        }
    }

    private void buscarPorNombre() {
        String nombre = LibIO.requestString("Ingresa el nombre del Empleado buscado:", 3, 20);
        empleadoActual = empresa.obtenerEmpleadoPorNombre(nombre);
        if (empleadoActual != null) {
            System.out.println("El empleado buscado es: " + empleadoActual);
        } else {
            System.out.println("No se ha encontrado al empleado con nombre: " + nombre);
        }
    }

    private void buscarPorRangoEdad() {
        int edadMin = LibIO.requestInt("Ingresa la edad mínima a buscar", 0, 110);
        int edadMax = LibIO.requestInt("Ingresa la edad máxima a buscar", 0, 110);
        List<Empleado> resultadoEdades = empresa.obtenerEmpleadosPorRangoEdad(edadMin, edadMax);
        System.out.println(Arrays.toString(resultadoEdades.toArray()));
    }

    private void buscarPorRangoSueldos() {
        float sueldoMin = LibIO.requestFloat("Ingresa el Sueldo mínimo a buscar:", 0, 4000);
        float sueldoMax = LibIO.requestFloat("Ingresa el Sueldo máximo a buscar", 0, 4000);
        List<Empleado> resultadoSueldos = empresa.obtenerEmpleadosPorSueldo(sueldoMin, sueldoMax);
        System.out.println(Arrays.toString(resultadoSueldos.toArray()));
    }

    private void buscarPorRangoHijosMenoresEdad() {
        System.out.println("Los empleados que tienen hijos menores de edad, son:");
        List<Empleado> resultadoHijosMenores = empresa.obtenerEmpleadosHijosMenoresEdad();
        System.out.println(Arrays.toString(resultadoHijosMenores.toArray()));
    }
}
