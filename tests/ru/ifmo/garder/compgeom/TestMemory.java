package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Point2;

@RunWith(JUnit4.class)
public class TestMemory {
    private static final int N = (int) 1e2;

    @Test
    public void testPoint2() {
        Point2<Float64>[] points = new Point2[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point2<Float64>(Float64.ZERO, Float64.ZERO);
        }
    }
}
