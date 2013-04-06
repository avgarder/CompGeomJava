package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Point2;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestMemory {
    private static final int N = (int) 1e7;

    @Test
    public void testPoint2() {
        Point2<Float64>[] points = new Point2[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2<Float64>(Float64.valueOf(i), Float64.valueOf(i));
        }

        for (int i = 0; i < N; i++) {
            assertNotNull(points[i]);
            assertNotNull(points[i].x);
            assertNotNull(points[i].y);
        }
    }
}