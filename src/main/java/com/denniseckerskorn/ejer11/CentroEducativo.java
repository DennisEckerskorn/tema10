package com.denniseckerskorn.ejer11;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CentroEducativo {
    private final List<Grupo> grupos;
    private final List<Aula> aulas;
    private final List<Profesor> profesores;

    public CentroEducativo() {
        grupos = new ArrayList<>();
        aulas = new ArrayList<>();
        profesores = new ArrayList<>();
        addProfesoresAuto(10);
    }

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
     * @param grupo
     * @return {@true} si se ha añadido correctamente, de lo contrario, {@false}
     */
    public boolean addGrupo(Grupo grupo) {
        return grupos.add(grupo);
    }

    /**
     * Permite añadir un aula a la lista de aulas.
     * @param aula
     * @return
     */
    public boolean addAula(Aula aula) {
        return aulas.add(aula);
    }

    public boolean addProfesor(Profesor profesor) {
        return profesores.add(profesor);
    }

    public Profesor getProfesorByDNI(String dni) {
        for(int i = 0; i < profesores.size(); i++) {
            if(profesores.get(i).getDni().equals(dni)) {
                return profesores.get(i);
            }
        }
        return null;
    }

    public boolean aulaExiste(Aula aula) {
        for(int i = 0; i < aulas.size(); i++) {
            if(aulas.get(i).getId() == aula.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permite obtener la lista completa de grupos.
     * @return lista de grupos.
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Permite obtener el nombre de cada grupo, sirve para mostrar los nombres de grupo.
     * @param index
     * @return
     */
    public String getNombreGrupo(int index) {
        if(index >= 0 && index < grupos.size()) {
            Grupo grupo = grupos.get(index);
            return grupo.getNombre();
        } else {
            return null;
        }
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
