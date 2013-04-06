package ru.ifmo.garder.compgeom.primitives;

import org.jscience.mathematics.number.Number;

public class Segment2<T extends Number<T>> {
    public Point2<T> beg;
    public Point2<T> end;

    public Segment2(Point2<T> beg, Point2<T> end) {
        this.beg = beg;
        this.end = end;
    }

    public Point2<T> min() {
        return beg.compareTo(end) <= 0 ? beg : end;
    }

    public Point2<T> max() {
        return beg.compareTo(end) > 0 ? beg : end;
    }
}
