package com.denniseckerskorn.ejer07;

import java.util.HashMap;
import java.util.Map;

public class MapDivisas {
    private final Map<Moneda, Double> divisas;
    private Moneda moneda;

    public MapDivisas() {
        this.divisas = new HashMap<>();
    }

    public void addMoneda(Moneda moneda, double cotizacion) {
        divisas.put(moneda, cotizacion);
    }

    public double divisaAEuros(Moneda moneda) {
        return divisas.get(moneda);
    }
}
