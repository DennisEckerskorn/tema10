package com.denniseckerskorn.ejer03;

import java.util.Random;

public class PrincipalPila {
    public PrincipalPila() {
        Pila<Integer> pila = new Pila<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            int number = pila.push(rnd.nextInt(51));
            System.out.println("PUSH:" + number);
        }

        for (int i = 0; i < 10; i++) {
            int num = pila.pop();
            System.out.println("POP:" + num);
        }
    }
}
