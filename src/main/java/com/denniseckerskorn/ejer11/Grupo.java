package com.denniseckerskorn.ejer11;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.*;

public class Grupo {
    private static int nextID = 1;
    private final int id;
    private final List<Alumno> alumnos;
    private final Map<Asignatura, Profesor> asignaturaProfesorMap;
    private final String nombre;
    private final Aula aula;


    public Grupo(String nombre, Aula aula, int cantidadAlumnos) {
        id = nextID++;
        alumnos = new ArrayList<>();
        asignaturaProfesorMap = new HashMap<>();
        this.nombre = nombre;
        this.aula = aula;

        addAlumnosAuto(cantidadAlumnos);
    }

    /**
     * Método que añade un alumno a la Lista de alumnos
     *
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @return {@true} si se añade, de lo contrario {@false}.
     */
    public boolean addAlumnoManual(String nombre, String apellido, LocalDate fechaNacimiento, Grupo grupo) {
        Alumno alumno = new Alumno(nombre, apellido, fechaNacimiento, grupo);
        if(existeAlumno(nombre, apellido)) {
            return false;
        }
        return alumnos.add(alumno);
    }

    /**
     * Método que genera alumnos aleatorios dentro de un grupo específico y los añade a la lista.
     *
     * @param cantidadAlumnos cantidad de alumnos a generar.
     */
    private void addAlumnosAuto(int cantidadAlumnos) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidadAlumnos; i++) {
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            LocalDate fechaNacimiento = faker.date().birthdayLocalDate();
            Grupo grupo = this;
            Alumno alumno = new Alumno(nombre, apellido, fechaNacimiento, grupo);
            alumnos.add(alumno);
        }
    }

    public boolean existeAlumno(String nombre, String apellido) {
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getNombre().equals(nombre) && alumnos.get(i).getApellido().equals(apellido)) {
                return true;
            }
        }
        return false;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Map<Asignatura, Profesor> getAsignaturaProfesorMap() {
        return asignaturaProfesorMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grupo grupo = (Grupo) o;
        return id == grupo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", alumnos=" + alumnos +
                ", asignaturaProfesorMap=" + asignaturaProfesorMap +
                ", nombre='" + nombre + '\'' +
                ", aula=" + aula +
                '}' + "\n";
    }
}
