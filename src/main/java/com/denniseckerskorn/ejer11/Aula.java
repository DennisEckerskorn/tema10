package com.denniseckerskorn.ejer11;

public class Aula {
    private static int nextID = 50;
    private final int id;
    private final float metrosCuadrados;

    public Aula(float metrosCuadrados) {
        id = nextID;
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getId() {
        return id;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }
}
