package com.denniseckerskorn.ejer10;

import com.denniseckerskorn.lib.ConsoleMenu;

public class MenuEmpresa {
    private ConsoleMenu menu;
    private ConsoleMenu menuConsultas;

    public MenuEmpresa() {
        menu = new ConsoleMenu("GESTIÓN EMPLEADOS");
        menu.addOpcion("Nuevo Empleado");

    }
}
