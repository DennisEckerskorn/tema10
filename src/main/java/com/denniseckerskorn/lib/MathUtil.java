package com.denniseckerskorn.lib;

public class MathUtil {
    /**
     * Función para comprobar si un número está dentro de un intervalo de numeros.
     * @param valor
     * @param valorMin
     * @param valorMax
     * @return
     */
    public static int clamp(int valor, int valorMin, int valorMax) {
        if(valor < valorMin) {
            return valorMin;
        }
        if(valor > valorMax) {
            return valorMax;
        }
        return valor;
    }

    /**
     * Función para comprobar si un número está dentro de un intervalo de numeros.
     * @param valor
     * @param valorMin
     * @param valorMax
     * @return
     */
    public static float clamp(float valor, float valorMin, float valorMax) {
        if(valor < valorMin) {
            return valorMin;
        }
        if(valor > valorMax) {
            return valorMax;
        }
        return valor;
    }
}
