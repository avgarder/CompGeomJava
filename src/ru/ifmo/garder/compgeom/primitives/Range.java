package ru.ifmo.garder.compgeom.primitives;

import org.jscience.mathematics.number.Number;

public class Range<T extends Number<T>> {
    public T inf;
    public T sup;

    public Range(T a, T b) {
        if (a.isLessThan(b)) {
            inf = a;
            sup = b;
        } else {
            inf = b;
            sup = a;
        }
    }

    public boolean contains(T x) {
        return inf.compareTo(x) <= 0 && sup.compareTo(x) >= 0;
    }
}
