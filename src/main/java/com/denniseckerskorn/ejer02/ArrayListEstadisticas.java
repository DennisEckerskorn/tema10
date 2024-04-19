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
        for (int i = 0; i < size(); i++) {
            double value = get(i);
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < size(); i++) {
            double value = get(i);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public double sumatorio() {
        double sum = 0;
        for (int i = 0; i < size(); i++) {
            double value = get(i);
            sum += value;
        }
        return sum;
    }

    @Override
    public double media() {
        double sum = 0;
        sum = sumatorio();
        if (size() > 0) {
            return sum / size();
        } else {
            return 0; //Para evitar división por 0 si la lista está vacía.
        }
    }

    @Override
    public double moda() {
        //Falta implementar correctamente...
        return 0;
    }
}
