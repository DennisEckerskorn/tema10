package com.denniseckerskorn.ejer04;

import java.util.Random;

public class PrincipalCola {
    public PrincipalCola() {
        Cola<Integer> cola = new Cola();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int numberAdd = rnd.nextInt(51);
            cola.add(numberAdd);
            System.out.println("ADD:" + numberAdd);
        }

        for (int i = 0; i < 10; i++) {
            int numberRemove = cola.remove();
            System.out.println("REMOVE" + numberRemove);
        }
    }
}
