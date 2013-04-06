package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Contour2;
import ru.ifmo.garder.compgeom.primitives.Point2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;
import static ru.ifmo.garder.compgeom.TestUtils.*;

@RunWith(JUnit4.class)
public class TestPointInConvexContour {
    private Contour2<Float64> c;
    private Point2<Float64> p;

    @Before
    public void setUp() {
        c = getContour2(getPoint2(0, 0), getPoint2(0, 2), getPoint2(1, 3),
                getPoint2(4, 3), getPoint2(4.5, 1.5), getPoint2(3.5, 0));
    }

    @Test
    public void testPointCompletelyOutside() {
        p = getPoint2(1, -1);
        assertFalse(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointOutside() {
        p = getPoint2(1, 5);
        assertFalse(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointIsVertex() {
        p = c.get(0);
        assertTrue(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointIsOnEdge() {
        p = getPoint2(0.5, 2.5);
        assertTrue(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointIsOnLastEdge() {
        p = getPoint2(2, 0);
        assertTrue(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointInContour() {
        p = getPoint2(2, 2);
        assertTrue(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointInLastTriangle() {
        p = getPoint2(3, 0.2);
        assertTrue(isPointInConvexContour(p, c));
    }

    @Test
    public void testPointInFirstTriangle() {
        p = getPoint2(0.5, 2);
        assertTrue(isPointInConvexContour(p, c));
    }
}
