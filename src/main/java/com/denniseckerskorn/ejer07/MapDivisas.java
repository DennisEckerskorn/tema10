package com.denniseckerskorn.ejer07;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapDivisas {
    private final Map<Moneda, Double> divisas;
    private Moneda moneda;

    public MapDivisas() {
        this.divisas = new HashMap<>();
    }

    public void addMoneda(Moneda moneda, double cotizacion) {
        divisas.put(moneda, cotizacion);
    }

    public double getDivisa(Moneda moneda) {
        return divisas.get(moneda);
    }

    public Map<Moneda, Double> getDivisas() {
        return divisas;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MapDivisas that)) return false;

        return divisas.equals(that.divisas) && moneda == that.moneda;
    }

    @Override
    public int hashCode() {
        int result = divisas.hashCode();
        result = 31 * result + Objects.hashCode(moneda);
        return result;
    }
}
