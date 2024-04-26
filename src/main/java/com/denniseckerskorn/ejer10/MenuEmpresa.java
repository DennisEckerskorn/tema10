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

    }

    private void mainMenu() {
        int opcion;
        do {
            opcion = menu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    menuConsultas();
                    break;
                case 7:
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
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                mainMenu();
            default:
                System.out.println("Numero no es válido");
                break;
        }
    }
}
