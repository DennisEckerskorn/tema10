package com.denniseckerskorn.pruebasiterator;

import java.util.Iterator;
import java.util.Random;

public class RandomSeries implements Iterator<Double>, Iterable<Double> {
    private final Random random;
    private final double min;
    private final double max;

    public RandomSeries() {
        this(0, 1);
    }

    public RandomSeries(long seed, double min, double max) {
        if (seed == Long.MIN_VALUE) {
            random = new Random();
        } else {
            random = new Random(seed);
        }
        this.min = min;
        this.max = max;

    }

    public RandomSeries(double min, double max) {
        this(Long.MIN_VALUE, min, max);
    }


    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Double next() {
        return random.nextDouble(min, max);
    }

    @Override
    public Iterator<Double> iterator() {
        return this;
    }
}
