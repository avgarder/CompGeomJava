package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Point2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;

@RunWith(JUnit4.class)
public class TestPointInTriangle {
    private Point2<Float64> a;
    private Point2<Float64> b;
    private Point2<Float64> c;
    private Point2<Float64> t;

    @Before
    public void setup() {
        a = TestUtils.getPoint2(0, 0);
        b = TestUtils.getPoint2(4, 0);
        c = TestUtils.getPoint2(2, 2);
    }

    @Test
    public void testPointIsVertex() {
        t = TestUtils.getPoint2(2, 2);
        assertTrue(isPointInTriangle(a, b, c, t));
    }

    @Test
    public void testPointLeft() {
        t = TestUtils.getPoint2(0, 2);
        assertFalse(isPointInTriangle(a, b, c, t));
    }

    @Test
    public void testPointRight() {
        t = TestUtils.getPoint2(3, 2);
        assertFalse(isPointInTriangle(a, b, c, t));
    }

    @Test
    public void testPointDown() {
        t = TestUtils.getPoint2(2, -1);
        assertFalse(isPointInTriangle(a, b, c, t));
    }

    @Test
    public void testPointIn() {
        t = TestUtils.getPoint2(2, 1);
        assertTrue(isPointInTriangle(a, b, c, t));
    }

    @Test
    public void testPointOnEdge() {
        t = TestUtils.getPoint2(1, 1);
        assertTrue(isPointInTriangle(a, b, c, t));
    }
}
