package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Point2;
import ru.ifmo.garder.compgeom.primitives.Segment2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;

@RunWith(JUnit4.class)
public class TestSegment2AndTriangleIntersection {
    private Point2<Float64> a;
    private Point2<Float64> b;
    private Point2<Float64> c;
    private Segment2<Float64> s;

    @Before
    public void setup() {
        a = TestUtils.getPoint2(0, 0);
        b = TestUtils.getPoint2(4, 0);
        c = TestUtils.getPoint2(2, 3);
    }

    @Test
    public void testSegmentBegIsVertex() {
        s = TestUtils.getSegment2(a, TestUtils.getPoint2(0, 5));
        assertTrue(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testSegmeintIsEdge() {
        s = TestUtils.getSegment2(a, b);
        assertTrue(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testAllSegmentInTriangle() {
        s = TestUtils.getSegment2(2, 1, 2, 2);
        assertTrue(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testSegmentEndsOutsideButIntersection() {
        s = TestUtils.getSegment2(3, 3, 2, -1);
        assertTrue(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testVertexIsOnSegment() {
        s = TestUtils.getSegment2(0, 1, 4, 5);
        assertTrue(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testSegmentIsOutside() {
        s = TestUtils.getSegment2(0, 1, 4, 7);
        assertFalse(isSegment2AndTriangleIntersects(a, b, c, s));
    }

    @Test
    public void testSegmentIsParallelEdge() {
        s = TestUtils.getSegment2(0, 1, 4, 7);
        assertFalse(isSegment2AndTriangleIntersects(a, b, c, s));
    }
}
