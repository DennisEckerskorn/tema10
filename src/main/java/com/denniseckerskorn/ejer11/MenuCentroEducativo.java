package com.denniseckerskorn.ejer11;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuCentroEducativo {
    private final ConsoleMenu menuPrincipal;
    private final ConsoleMenu menuAltas;
    private final ConsoleMenu menuBajas;
    private final ConsoleMenu menuInfo;
    private final CentroEducativo centro;

    public MenuCentroEducativo() {
        Aula aula1 = new Aula("Aula DAM", 120);
        Aula aula2 = new Aula("Aula DAW", 60);
        Grupo grupo1 = new Grupo("DAM", aula1, 20);
        Grupo grupo2 = new Grupo("DAW", aula2, 15);
        centro = new CentroEducativo();
        centro.addAula(aula1);
        centro.addAula(aula2);
        centro.addGrupo(grupo1);
        centro.addGrupo(grupo2);


        System.out.println(centro);


        menuPrincipal = new ConsoleMenu("CENTRO EDUCATIVO");
        menuPrincipal.addOpcion("ALTAS...");
        menuPrincipal.addOpcion("BAJAS...");
        menuPrincipal.addOpcion("MOSTRAR INFORMACIÓN...");
        menuPrincipal.addOpcion("SALIR...");

        menuAltas = new ConsoleMenu("MENÚ DE ALTAS");
        menuAltas.addOpcion("Alta de Alumnos...");
        menuAltas.addOpcion("Asociar Asignaturas con Profesores...");
        menuAltas.addOpcion("Alta de Grupos...");
        menuAltas.addOpcion("Alta de Aulas...");
        menuAltas.addOpcion("Alta de Profesores...");
        menuAltas.addOpcion("Volver al menú principal...");

        menuBajas = new ConsoleMenu("MENÚ DE BAJAS");
        menuBajas.addOpcion("Baja de Alumno...");
        menuBajas.addOpcion("Baja de Asignatura...");
        menuBajas.addOpcion("Baja de Grupo...");
        menuBajas.addOpcion("Baja de Aula...");
        menuBajas.addOpcion("Baja de Profesor...");
        menuBajas.addOpcion("Volver al menú principal...");

        menuInfo = new ConsoleMenu("MENÚ DE CONSULTAS");
        menuInfo.addOpcion("Mostrar Alumno");
        menuInfo.addOpcion("Mostrar Alumnos por Grupo");
        menuInfo.addOpcion("Mostrar Alumnos por Profesor");
        menuInfo.addOpcion("Mostrar Profesor");
        menuInfo.addOpcion("Volver al menú principal...");
        //TODO: Add more options...

        showMenuPrincipal();


    }

    private void showMenuPrincipal() {
        int opcion;
        do {
            opcion = menuPrincipal.mostrarMenuInt();
            switch (opcion) {
                case 1:
                    showMenuAltas();
                    break;
                case 2:
                    showMenuBajas();
                    break;
                case 3:
                    showMenuConsultas();
                    break;
                case 4:
                    System.out.println("Nos vemos pronto...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }


    private void showMenuAltas() {
        int opcion;
        opcion = menuAltas.mostrarMenuInt();
        switch (opcion) {
            case 1: //Alta Alumnos
                altaAlumno();
                break;
            case 2: // Asociar Asignaturas con Profesores

                break;
            case 3: //Alta Grupos.
                altaGrupo();
                break;
            case 4: //Alta Aulas
                altaAulas();
                break;
            case 5: //Alta Profesores
                break;
            case 6: //Salir
                return;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    /**
     * Permite dar de alta un nuevo alumno y asignarlo a un grupo ya existente.
     * Si el alumno corresponde a otro grupo, habrá que dar de alta el grupo primero.
     */
    private void altaAlumno() {
        System.out.println("Por favor, introduce los datos del Nuevo Alumno, el NIA se genera automáticamente:");
        String nombre = LibIO.requestString("Nombre: ", 3, 20);
        String apellido = LibIO.requestString("Apellido/s: ", 3, 20);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LibIO.solicitarFechaLocalDate("Fecha de Nacimiento: ", dtf);
        System.out.println("¿A qué Grupo pertenece el Alumno?");
        showGroups();
        Grupo grupoSeleccionado = selectGroup();
        if (grupoSeleccionado.addAlumnoManual(nombre, apellido, fechaNacimiento, grupoSeleccionado)) {
            System.out.println("El alumno se ha añadido correctamente");
        } else {
            System.out.println("El alumno no se ha podido añadir correctamente porque ya existe");
        }


        //TODO: Remove after testing...
        System.out.println(grupoSeleccionado);
        System.out.println(centro);
    }

    private void asociarAsignaturaProfesor() {
        System.out.println("Elige la Asignatura a Asociar:");
        int index = 1;
        for (Asignatura.AsignaturaEnum asignatura : Asignatura.AsignaturaEnum.values()) {
            System.out.println(index + ". " + asignatura.getNombreCompletoAsignatura());
            index++;
        }
        int opcion = LibIO.requestInt("Elige una asignatura", 1, Asignatura.AsignaturaEnum.values().length);
        //TODO: Mostrar profesores y asociarlos al hasmap junto ala asignatura elegida.

    }

    /**
     * Método que muestra los grupos disponibles con un número para seleccionar la opción(grupo).
     */
    private void showGroups() {
        for (int i = 0; i < centro.getGrupos().size(); i++) {
            if (centro.getNombreGrupo(i) != null) {
                System.out.println((i + 1) + ". " + centro.getNombreGrupo(i));
            } else {
                System.out.println("Nombres no disponibles (nulos)");
            }
        }
    }

    /**
     * Método que permite seleccionar el grupo según su número de opción generado.
     *
     * @return el grupo seleccionado
     */
    private Grupo selectGroup() {
        int opcion = LibIO.requestInt("Selecciona el Grupo", 1, centro.getGrupos().size());
        return centro.getGrupos().get(opcion - 1);
    }

    private void altaGrupo() {
        System.out.println("Por favor, ingresa los datos del Grupo nuevo:");
        String nombre = LibIO.requestString("Nombre: ", 1, 10);
        int cantidadAlumnos = LibIO.requestInt("Cuántos alumnos tendrá el grupo?");
        Aula nuevoAula = addAulasToNewGroup();
        if (!centro.aulaExiste(nuevoAula)) {
            centro.addGrupo(new Grupo(nombre, nuevoAula, cantidadAlumnos));
            System.out.println("El aula se ha creado y asignado correctamente al Grupo");
        } else {
            System.out.println("El aula ya existe y no se ha podido crear y asignar al grupo nuevo.");
        }
    }

    private Aula addAulasToNewGroup() {
        System.out.println("Por favor, ingresa los datos del Aula:");
        String nombre = LibIO.requestString("Nombre del aula: ", 1, 10);
        float metrosCuadrados = LibIO.requestFloat("Metros Cuadrados del Aula:", 1, 200);
        return new Aula(nombre, metrosCuadrados);
    }

    private void altaAulas() {
        System.out.println("Por favor, ingresa los datos del Aula:");
        String nombre = LibIO.requestString("Nombre del aula: ", 1, 10);
        float metrosCuadrados = LibIO.requestFloat("Metros Cuadrados del Aula:", 1, 200);
        Aula nuevoAula = new Aula(nombre, metrosCuadrados);
        if (!centro.aulaExiste(nuevoAula)) {
            centro.addAula(new Aula(nombre, metrosCuadrados));
            System.out.println("El Aula se ha creado correctamente");
        } else {
            System.out.println("El aula con estos datos ya existe y no se ha podido añadir.");
            System.out.println(centro.getAulas());
        }
    }


    private void showMenuBajas() {
        int opcion;
        opcion = menuBajas.mostrarMenuInt();
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
                return;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void showMenuConsultas() {
        int opcion;
        opcion = menuInfo.mostrarMenuInt();
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
                return;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}
