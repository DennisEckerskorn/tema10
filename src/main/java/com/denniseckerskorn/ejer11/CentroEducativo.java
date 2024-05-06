package com.denniseckerskorn.ejer11;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Clase que se encarga de control central del centro educativo, contiene las listas y genera datos aleatorios y manuales.
 * Ademas contiene varios métodos de busqueda o inserción.
 */
public class CentroEducativo {
    private final List<Grupo> grupos;
    private final List<Aula> aulas;
    private final List<Profesor> profesores;

    /**
     * Constructor del Centro Educativo, inicializa las listas de grupos, aulas y profesores.
     * Ademas se generan Profesores Aleatorios.
     */
    public CentroEducativo() {
        grupos = new ArrayList<>();
        aulas = new ArrayList<>();
        profesores = new ArrayList<>();
        addProfesoresAuto(10);
    }

    /**
     * Permite generar una cantidad de Profesores con Datos aleatorios mediante Faker.
     *
     * @param cantidadProfesores cantidad a generar.
     */
    private void addProfesoresAuto(int cantidadProfesores) {
        Faker faker = new Faker(new Locale("es", "ES"));
        for (int i = 0; i < cantidadProfesores; i++) {
            String dni = faker.idNumber().valid();
            String nombre = faker.name().firstName();
            String apellido = faker.name().lastName();
            float sueldo = (float) faker.number().randomDouble(2, 1000, 4000);
            Profesor profesor = new Profesor(dni, nombre, apellido, sueldo);
            profesores.add(profesor);
        }
    }

    /**
     * Permite añadir un grupo a la lista de grupos.
     *
     * @param grupo
     * @return {@true} si se ha añadido correctamente, de lo contrario, {@false}
     */
    public boolean addGrupo(Grupo grupo) {
        return grupos.add(grupo);
    }

    /**
     * Permite añadir un aula a la lista de aulas.
     *
     * @param aula
     * @return
     */
    public boolean addAula(Aula aula) {
        return aulas.add(aula);
    }

    /**
     * Permite añadir un profesor a la lista de profesores.
     *
     * @param profesor objeto Profesor que recibe
     * @return {@true} si se ha añadido, de lo contrario, {@false}
     */
    public boolean addProfesor(Profesor profesor) {
        return profesores.add(profesor);
    }

    /**
     * Permite comprobar si el aula pasado como parámetro existe en la Lista de aulas.
     * Se comprueba mediante el ID del objeto aula, ya que el ID es único.
     *
     * @param aula objeto aula que recibe
     * @return {@true} si el aula ya existe en la lista, de lo contrario, {@false}
     */
    public boolean aulaExiste(Aula aula) {
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getId() == aula.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite buscar un alumno dentro de uno de los grupos.
     * Usa el nia del alumno para buscarlo.
     *
     * @param nia
     * @return Alumno con el NIA correspondiente, de lo contrario NULL.
     */
    public Alumno obtenerAlumnoPorNia(int nia) {
        for (Grupo grupo : grupos) {
            Alumno alumno = grupo.getAlumnoPorNIA(nia);
            if (alumno != null) {
                return alumno;
            }
        }
        return null;
    }

    public boolean eliminarAlumno(Alumno alumno) {
        for (Grupo grupo : grupos) {
            return grupos.remove(alumno);
        }
        return false;
    }

    public boolean eliminarGrupo(Grupo grupo) {
        for (int i = 0; i < grupos.size(); i++) {
            return grupos.remove(grupo);
        }
        return false;
    }

    public boolean eliminarAula(int id) {
        for (int i = 0; i < aulas.size(); i++) {
            Aula aula = aulas.get(i);
            if (aula.getId() == id) {
                return aulas.remove(aula);
            }
        }
        return false;
    }

    public boolean eliminarProfesor(String dni) {
        for (int i = 0; i < profesores.size(); i++) {
            Profesor profesor = profesores.get(i);
            if (profesor.getDni().equals(dni)) {
                return profesores.remove(profesor);
            }
        }
        return false;
    }

    /**
     * Permite buscar un profesor en la lista de profesores mediante su DNI.
     *
     * @param dni DNI del profesor que se busca
     * @return Objeto Profesor con el DNI, de lo contrario, NULL
     */
    public Profesor obtenerProfesorPorDNI(String dni) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)) {
                return profesores.get(i);
            }
        }
        return null;
    }

    /**
     * Permite obtener la lista completa de grupos.
     *
     * @return lista de grupos.
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * Permite obtener la lista completa de aulas.
     *
     * @return lista de aulas.
     */
    public List<Aula> getAulas() {
        return aulas;
    }

    /**
     * Permite obtener la lista completa de profesores.
     *
     * @return lista de profesores.
     */
    public List<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Permite obtener el nombre de cada grupo, sirve para mostrar los nombres de grupo.
     *
     * @param index
     * @return
     */
    public String getNombreGrupo(int index) {
        if (index >= 0 && index < grupos.size()) {
            Grupo grupo = grupos.get(index);
            return grupo.getNombre();
        } else {
            return null;
        }
    }

    /**
     * Permite comprobar si un profesor ya existe dentro de la lista de profesores.
     * Usa el DNI para buscarlo.
     *
     * @param dni String
     * @return {@true} si existe, de lo contrario {@false}
     */
    public boolean profesorExiste(String dni) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroEducativo that = (CentroEducativo) o;
        return grupos.equals(that.grupos) && aulas.equals(that.aulas) && profesores.equals(that.profesores);
    }

    @Override
    public int hashCode() {
        int result = grupos.hashCode();
        result = 31 * result + aulas.hashCode();
        result = 31 * result + profesores.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "grupos=" + grupos +
                ", aulas=" + aulas + "\n" +
                ", profesores=" + profesores +
                '}';
    }
}
