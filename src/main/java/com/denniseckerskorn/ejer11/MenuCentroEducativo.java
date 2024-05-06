package com.denniseckerskorn.ejer11;

import com.denniseckerskorn.lib.ConsoleMenu;
import com.denniseckerskorn.lib.LibIO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

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
        menuBajas.addOpcion("Baja de Grupo...");
        menuBajas.addOpcion("Baja de Aula...");
        menuBajas.addOpcion("Baja de Profesor...");
        menuBajas.addOpcion("Volver al menú principal...");

        menuInfo = new ConsoleMenu("MENÚ DE CONSULTAS");
        menuInfo.addOpcion("Obtener Alumno por NIA...");
        menuInfo.addOpcion("Mostrar Alumnos por Grupo...");
        menuInfo.addOpcion("Obtener Profesor que imparte algúna Asignatura");
        menuInfo.addOpcion("Obtener Profesor por DNI");
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
                asociarAsignaturaProfesor();
                break;
            case 3: //Alta Grupos.
                altaGrupo();
                break;
            case 4: //Alta Aulas
                altaAulas();
                break;
            case 5: //Alta Profesores
                altaProfesor();
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
    }

    /**
     * Método que permite mostrar y elegir los grupos, asignaturas y profesores disponibles.
     * Finalmente las opciones elegidas permiten guardar las asignaturas con el profesor elegido a un grupo especifico.
     * Para guardar las asignaturas y los profesores se usa un hashmap, y el hasmap esta asociado a un grupo especifico.
     */
    private void asociarAsignaturaProfesor() {
        System.out.println("Elige el Grupo al que deseas asociar la Asignatura y el Profesor:");
        showGroups();
        Grupo grupoSeleccionado = selectGroup();

        int opcionAsignaturas = listaAsignaturas();

        int indexProfesores = 1;
        for (Profesor profesor : centro.getProfesores()) {
            System.out.println(indexProfesores + ". " + profesor.getNombre() + " " + profesor.getApellido());
            indexProfesores++;
        }
        int opcionProfesores = LibIO.requestInt("Elige el profesor:", 1, centro.getProfesores().size());

        Asignatura.AsignaturaEnum asignaturaSeleccionada = Asignatura.AsignaturaEnum.values()[opcionAsignaturas - 1];
        Profesor profesorSeleccionado = centro.getProfesores().get(opcionProfesores - 1);

        grupoSeleccionado.addAsignaturaProfesor(asignaturaSeleccionada, profesorSeleccionado);
    }

    private int listaAsignaturas() {
        int indexAsignaturas = 1;
        for (Asignatura.AsignaturaEnum asignatura : Asignatura.AsignaturaEnum.values()) {
            System.out.println(indexAsignaturas + ". " + asignatura.getNombreCompletoAsignatura());
            indexAsignaturas++;
        }
        return LibIO.requestInt("Elige una asignatura", 1, Asignatura.AsignaturaEnum.values().length);
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

    private void altaProfesor() {
        System.out.println("Por favor, ingresa los datos del Profesor:");
        String dni = LibIO.requestString("DNI: ", 6, 9);
        if (centro.profesorExiste(dni)) {
            System.out.println("El profesor ya existe con DNI " + dni);
        } else {
            String nombre = LibIO.requestString("Nombre: ", 3, 10);
            String apellido = LibIO.requestString("Apellido: ", 3, 20);
            float sueldo = LibIO.requestFloat("Sueldo: ", 1000, 4000);
            Profesor nuevoProfesor = new Profesor(dni, nombre, apellido, sueldo);
            if (centro.addProfesor(nuevoProfesor)) {
                System.out.println("El profesor se ha añadido correctamente");
            } else {
                System.out.println("No se ha podido añadir al profesor");
            }
        }
    }


    private void showMenuBajas() {
        int opcion;
        opcion = menuBajas.mostrarMenuInt();
        switch (opcion) {
            case 1: //Baja de alumno
                bajaAlumno();
                break;
            case 2: // Baja de Grupo...
                bajaGrupo();
                break;
            case 3: //Baja de Aula...
                break;
            case 4: //Baja de Profesor...
                break;
            case 5: //Salir
                return;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void bajaAlumno() {
        int nia = LibIO.requestInt("Ingresa el NIA del alumno", 1, 999);
        Alumno alumno = centro.obtenerAlumnoPorNia(nia);
        System.out.println("El alumno " + alumno + " va a ser borrado");
        if (alumno != null) {
            centro.eliminarAlumno(alumno);
            System.out.println("El alumno ha sido borrado con éxito");
        } else {
            System.out.println("No se ha podido eliminar al alumno");
        }
    }

    /**
     * Método que elimina un grupo entero, usar con cuidado...
     */
    private void bajaGrupo() {
        showGroups();
        Grupo grupoElegido = selectGroup();
        if(grupoElegido != null) {
            centro.eliminarGrupo(grupoElegido);
            System.out.println("El grupo " + grupoElegido + " se ha borrado con éxito");
        } else {
            System.out.println("No se ha podido eliminar al grupo elegido");
        }

    }

    private void showMenuConsultas() {
        int opcion;
        opcion = menuInfo.mostrarMenuInt();
        switch (opcion) {
            case 1: //Obtener Alumno por NIA...
                obtenerAlumnoPorNIA();
                break;
            case 2: //Mostrar Alumnos por Grupo
                obtenerAlumnosPorGrupo();
                break;
            case 3: //Obtener Profesor que imparte algúna Asignatura por Grupo
                obtenerProfesorFromAsignaturaGrupo();
                break;
            case 4: //Obtener Profesor por DNI
                obtenerProfesorPorDNI();
                break;
            case 5: //Salir
                return;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void obtenerAlumnoPorNIA() {
        int nia = LibIO.requestInt("Introduce el NIA del Alumno:", 1, 999);
        Alumno alumno = centro.obtenerAlumnoPorNia(nia);
        if (alumno != null) {
            System.out.println(alumno);
        } else {
            System.out.println("El Alumno con NIA " + nia + " no existe");
        }
    }

    private void obtenerAlumnosPorGrupo() {
        System.out.println("¿De qué grupo quieres mostrar los alumnos?");
        showGroups();
        Grupo grupo = selectGroup();
        System.out.println(grupo);
    }

    private void obtenerProfesorFromAsignaturaGrupo() {
        System.out.println("Elige el Grupo del que quieres saber los profesores que imparten las asignaturas:");
        showGroups();
        Grupo grupoElegido = selectGroup();

        System.out.println("Elige la Asignatura para saber qué Profesor la imparte:");
        Asignatura.AsignaturaEnum asignaturaElegida = selectAsignatura();

        try {
            String profesor = grupoElegido.getProfesorFromAsignaturaDeGrupo(asignaturaElegida);
            System.out.println("El Profesor que imparte la asignatura " + asignaturaElegida + " en el grupo " + grupoElegido.getNombre() + " es: " + profesor);
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
    }

    private Asignatura.AsignaturaEnum selectAsignatura() {
        int opcionAsignatura = listaAsignaturas();
        return Asignatura.AsignaturaEnum.values()[opcionAsignatura - 1];
    }

    private void obtenerProfesorPorDNI() {
        String dni = LibIO.requestString("Ingresa el DNI del profesor:", 8, 12);
        Profesor profesor = centro.obtenerProfesorPorDNI(dni);
        if (profesor != null) {
            System.out.println("El profesor con DNI: " + dni + " es: " + profesor);
        } else {
            System.out.println("No se ha encontrado al profesor con DNI: " + dni);
        }
    }
}
