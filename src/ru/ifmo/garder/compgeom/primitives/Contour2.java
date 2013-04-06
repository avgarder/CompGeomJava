package ru.ifmo.garder.compgeom.primitives;

import org.jscience.mathematics.number.Number;

import java.util.*;

public class Contour2<T extends Number<T>> extends AbstractList<Point2<T>> {
    private ArrayList<Point2<T>> points;
    private int size;

    public Contour2(Collection<Point2<T>> points) {
        this.points = new ArrayList<Point2<T>>(points);
        size = this.points.size();
    }

    @Override
    public Point2<T> get(int index) {
        if (index < 0 || index >= size) {
            index = (index % size + size) % size;
        }
        return points.get(index);
    }

    @Override
    public int size() {
        return size;
    }
}