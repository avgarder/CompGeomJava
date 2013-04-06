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
public class TestPointInContour {
    private Contour2<Float64> c;
    private Point2<Float64> p;

    @Before
    public void setUp() {
        c = getContour2(getPoint2(0, 0), getPoint2(3, 4), getPoint2(5, 8),
                getPoint2(7, 6), getPoint2(9, 8), getPoint2(13, 4),
                getPoint2(8, 0), getPoint2(6, 1), getPoint2(4, -3),
                getPoint2(7, -4), getPoint2(6, -8), getPoint2(1, -6),
                getPoint2(3, -1));
    }

    @Test
    public void testPointIsVertex() {
        p = getPoint2(7, 6);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointOnEdge() {
        p = getPoint2(11, 6);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointCompletelyOutside() {
        p = getPoint2(-30, -30);
        assertFalse(isPointInContour(p, c));
    }

    @Test
    public void testPointOutside1() {
        p = getPoint2(4, 7);
        assertFalse(isPointInContour(p, c));
    }

    @Test
    public void testPointOutside2() {
        p = getPoint2(1, -2);
        assertFalse(isPointInContour(p, c));
    }

    @Test
    public void testPointOutsideWithVertexTouch() {
        p = getPoint2(0, 1);
        assertFalse(isPointInContour(p, c));
    }

    @Test
    public void testPointOutsideWithTwoVertexTouches() {
        p = getPoint2(-1, 0);
        assertFalse(isPointInContour(p, c));
    }

    @Test
    public void testPointInside() {
        p = getPoint2(5, 3);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointInsideWithVertexTouch1() {
        p = getPoint2(4, 1);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointInsideWithVertexTouch2() {
        p = getPoint2(4, 0);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointInsideWithVertexTouch3() {
        p = getPoint2(4, -4);
        assertTrue(isPointInContour(p, c));
    }

    @Test
    public void testPointOustideWithTwoSurfaceVertexTouches() {
        p = getPoint2(0, 8);
        assertFalse(isPointInContour(p, c));
    }
}
