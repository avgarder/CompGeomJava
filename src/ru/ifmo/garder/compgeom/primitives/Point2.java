package ru.ifmo.garder.compgeom.primitives;

import org.jscience.mathematics.number.Number;

public class Point2<T extends Number<T>> implements Comparable<Point2<T>> {
    public T x;
    public T y;

    public Point2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2<T> r) {
        return x.compareTo(r.x) == 0 ? y.compareTo(r.y) : x.compareTo(r.x);
    }

    public boolean equals(Point2<T> r) {
        return this.compareTo(r) == 0;
    }

    @Override
    public String toString() {
        return "(" + x.toString() + ", " + y.toString() + ")";
    }
}
