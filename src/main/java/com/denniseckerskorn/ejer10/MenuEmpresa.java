package com.denniseckerskorn.ejer10;

import com.denniseckerskorn.lib.ConsoleMenu;

public class MenuEmpresa {
    private ConsoleMenu menu;
    private ConsoleMenu menuConsultas;

    public MenuEmpresa() {
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
}
