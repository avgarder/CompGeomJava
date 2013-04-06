package ru.ifmo.garder.compgeom.primitives;

import org.jscience.mathematics.number.Number;

public class Rectangle2<T extends Number<T>> {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 0;
    public static final int UP = 1;

    public Range<T> x;
    public Range<T> y;

    public Rectangle2(Range<T> x, Range<T> y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2(Point2<T> p1, Point2<T> p2) {
        x = new Range<T>(p1.x, p2.x);
        y = new Range<T>(p1.y, p2.y);
    }

    public boolean contains(Point2<T> point) {
        return x.contains(point.x) && y.contains(point.y);
    }

    public Point2<T> corner(int lr, int du) {
        return new Point2<T>(lr == LEFT ? x.inf : x.sup, du == DOWN ? y.inf : y.sup);
    }
}
