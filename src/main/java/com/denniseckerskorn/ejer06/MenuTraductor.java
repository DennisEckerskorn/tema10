package com.denniseckerskorn.ejer06;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

public class MenuTraductor {
    private final ConsoleMenu menu;
    private final Traductor traductor;

    public MenuTraductor() {
        traductor = new Traductor();
        menu = new ConsoleMenu("MENÚ PRINCIPAL");
        menu.addOpcion("Introducir parejas de palabras...");
        menu.addOpcion("Traducir palabras...");
        menu.addOpcion("Salir de la aplicación...");

        String paIng = "";
        String paVal = "";
        int opcion;
        do {
            opcion = menu.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    int cantidadPalabras = LibIO.requestInt("¿Cuántas parejas deseas introducir?", 1, 20);
                    for (int i = 0; i < cantidadPalabras; i++) {
                        paIng = LibIO.requestString("Dime la palabra en Inglés:", 1, 30);
                        paVal = LibIO.requestString("Dime la palabra en Valenciano:", 1, 30);
                        traductor.addParejaPalabras(paIng, paVal);
                    }
                    break;
                case 2:
                    String palabraABuscar = LibIO.requestString("Palabra a buscar", 1, 30);
                    String traduccion = traductor.traducirPalabras(palabraABuscar);
                    System.out.println("La palabra en Ingles es: " + traduccion);
                    break;
                default:
                    System.out.println("No es una opción válida");
            }

        } while (opcion != 3);
    }
}
