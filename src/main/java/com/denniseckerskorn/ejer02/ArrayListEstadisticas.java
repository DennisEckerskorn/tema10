package com.denniseckerskorn.ejer02;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayListEstadisticas() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListEstadisticas(int capacity) {
        super(capacity);
    }

    public ArrayListEstadisticas(Collection<Double> collection) {
        super(collection);
    }

    @Override
    public double minimo() {
        double min = Double.MAX_VALUE;
        for(int i = 0; i < size(); i++) {
            double value = get(i);
            if(value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < size(); i++) {
            double value = get(i);
            if(value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        return 0;
    }

    @Override
    public double media() {
        return 0;
    }

    @Override
    public double moda() {
        return 0;
    }
}
