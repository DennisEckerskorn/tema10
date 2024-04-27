package com.denniseckerskorn.ejer10;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

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
        menuConsultas.addOpcion("Buscar por NIF");
        menuConsultas.addOpcion("Buscar por nombre");
        menuConsultas.addOpcion("Buscar por rango de edad");
        menuConsultas.addOpcion("Buscar por rando de sueldo");
        menuConsultas.addOpcion("Buscar por hijos menores de edad");
        menuConsultas.addOpcion("Volver al menú principal");

        mainMenu();

    }

    private void mainMenu() {
        int opcion;
        do {
            opcion = menu.mostrarMenuInt();
            switch (opcion) {
                case 1: //Nuevo empleado
                    addNuevoEmpleado();
                    System.out.println(empresa.toString());
                    System.out.println(empleadoActual.toString());
                    break;
                case 2: //Nuevo hijo
                    break;
                case 3: //Modificar Sueldo
                    break;
                case 4: //Borrar empleado
                    break;
                case 5: //Borrar hijo
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
        } while (opcion != 7);
    }

    private void menuConsultas() {
        int opcion = menuConsultas.mostrarMenuInt();
        switch (opcion) {
            case 1: //Buscar por NIF
                break;
            case 2: //Buscar por nombre
                break;
            case 3: //Buscar por rango de edad
                break;
            case 4: //Buscar por rango de sueldo
                break;
            case 5: //Buscar por hijos menores de edad
                break;
            case 6: //Salir del menuConsultas y volver al menu principal
                return;
            default:
                System.out.println("Numero no es válido");
                break;
        }
    }

    private void addNuevoEmpleado() {
        String dni = LibIO.requestString("Ingresa el DNI del empleado:", 8,9);
        String nombre = LibIO.requestString("Ingresa el nombre del empleado: ", 3, 20);
        String apellidos = LibIO.requestString("Ingresa los apellidos del empleado: ", 3, 20);
        String fechaNacimiento = LibIO.requestString("Ingresa la fecha de nacimiento del Empleado",10,10); //TODO: Cambiar a date y validar formato
        float sueldo = LibIO.requestFloat("Ingresa el sueldo del empleado:", 600, 4000);
        int cantidadHijos = LibIO.requestInt("¿Cuantos hijos tiene el empleado?", 0, 20);

        if(cantidadHijos > 0) {
            empleadoActual = empresa.addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
            for(int i = 0; i < cantidadHijos; i++) {
                String nombreHijo = LibIO.requestString("Ingresa el nombre del hijo:", 3, 20);
                String fechaNacimientoHijo = LibIO.requestString("Ingresa la fecha de nacimiento del hijo",10,10); //TODO: Cambiar a date y validar formato
                empleadoActual.addHijo(nombreHijo, fechaNacimientoHijo);
            }
        } else {
            empleadoActual = empresa.addNuevoEmpleado(dni, nombre, apellidos, fechaNacimiento, sueldo, cantidadHijos);
        }
    }
}
