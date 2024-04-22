package com.denniseckerskorn;

import com.denniseckerskorn.ejer03.PrincipalPila;
import com.denniseckerskorn.ejer04.PrincipalCola;
import com.denniseckerskorn.ejer05.PrincipalCentroSalud;

public class Main {
    public static void main(String[] args) {
        //Ejer01 ejer01 = new Ejer01();

        /*
        //Ejemplo de HasMap:
        HashMap<String, String> diccionario = new HashMap<>();
        diccionario.put("Casa", "Bloque de piedras con techo donde vive gente");
        diccionario.put("Coche", "Caja de metal con 4 ruedas que se mueve");
        diccionario.put("Cajero","Máquina que sirve para diferentes servicios relacionados con el dinero");

        //Obtener Claves y valores:
        for(Map.Entry e : diccionario.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        //Obtener claves solamente:
        Set<String> claves = diccionario.keySet();
        System.out.println(claves);

        //Obtener valores solamente:
        Collection<String> valores = diccionario.values();
        System.out.println(valores);
         */

        //PrincipalPila principal = new PrincipalPila();
        //PrincipalCola cola = new PrincipalCola();
        PrincipalCentroSalud principalCentroSalud = new PrincipalCentroSalud();
    }
}