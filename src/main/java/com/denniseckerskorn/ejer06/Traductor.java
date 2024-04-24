package com.denniseckerskorn.ejer06;

import java.util.HashMap;
import java.util.Map;

public class Traductor {
    private final Map<String, String> parejaPalabras;

    public Traductor() {
        this.parejaPalabras = new HashMap<>();
    }

    /**
     * Método que añade la clave y el valor al HashMap.
     *
     * @param palabraValenciano String clave
     * @param palabraIngles     String valor
     */
    public void addParejaPalabras(String palabraValenciano, String palabraIngles) {
        parejaPalabras.put(palabraValenciano, palabraIngles);
    }

    /**
     * Método que obtiene el valor mediante la clave pasada como parámetro.
     *
     * @param palabraValenciano String clave
     * @return valor a partir de la clave.
     */
    public String traducirPalabras(String palabraValenciano) {
        return parejaPalabras.get(palabraValenciano);
    }

}
