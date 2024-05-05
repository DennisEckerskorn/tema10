package com.denniseckerskorn.ejer11;

public class Asignatura {
    public enum AsignaturaEnum {
        PRG ("Programación"),
        BBDD ("Bases de Datos"),
        ED ("Entornos de Desarollo"),
        SI ("Sistemas Informáticos"),
        ENG ("Inglés"),
        FOL ("Formación Orientación Laboral"),
        LM ("Lenguajes de Marcas");

        private final String nombreCompletoAsignatura;

        AsignaturaEnum(String nombreCompletoAsignatura) {
            this.nombreCompletoAsignatura = nombreCompletoAsignatura;
        }

        public String getNombreCompletoAsignatura() {
            return nombreCompletoAsignatura;
        }
    }

    private static int nextId = 1;
    private final int id;
    private final AsignaturaEnum nombre;

    public Asignatura(AsignaturaEnum nombre) {
        this.id = nextId++;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public AsignaturaEnum getNombre() {
        return nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asignatura that = (Asignatura) o;
        return id == that.id && nombre == that.nombre;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nombre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre=" + nombre +
                '}';
    }
}
