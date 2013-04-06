package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Rectangle2;
import ru.ifmo.garder.compgeom.primitives.Segment2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;

@RunWith(JUnit4.class)
public class TestSegment2AndRectangle2Intersection {
    private Rectangle2<Float64> r;
    private Segment2<Float64> s;

    @Before
    public void setUp() {
        r = new Rectangle2<Float64>(TestUtils.getPoint2(0, 0), TestUtils.getPoint2(7, 4));
    }

    @Test
    public void testSegmentsBegIsVertex() {
        s = TestUtils.getSegment2(0, 0, -1, -1);
        assertTrue(isSegment2AndRectangle2Intersects(r, s));
    }

    @Test
    public void testSegmentIsInside() {
        s = TestUtils.getSegment2(1, 1, 5, 2);
        assertTrue(isSegment2AndRectangle2Intersects(r, s));
    }

    @Test
    public void testSegmentIsOutside() {
        s = TestUtils.getSegment2(31, 31, 239, 239);
        assertFalse(isSegment2AndRectangle2Intersects(r, s));
    }
}
