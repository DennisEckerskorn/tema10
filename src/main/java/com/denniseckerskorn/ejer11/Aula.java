package com.denniseckerskorn.ejer11;

public class Aula {
    private static int nextId = 50; //ID starts at 50
    private final int id;
    private final String nombre;
    private final float metrosCuadrados;

    public Aula(String nombre, float metrosCuadrados) {
        id = nextId++;
        this.nombre = nombre;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getId() {
        return id;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aula aula = (Aula) o;
        return id == aula.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                "nombre=" + nombre +
                ", metrosCuadrados=" + metrosCuadrados +
                '}';
    }
}
