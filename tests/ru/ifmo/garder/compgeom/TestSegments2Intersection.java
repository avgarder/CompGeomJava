package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Segment2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;

@RunWith(JUnit4.class)
public class TestSegments2Intersection {
    @Test
    public void test1() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 2, 2);
        Segment2<Float64> b = TestUtils.getSegment2(-1, 2, 0, 2);

        assertFalse(isSegments2Intersects(a, b));
        assertFalse(isSegments2Intersects(b, a));
    }

    @Test
    public void test2() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 1, 0);
        Segment2<Float64> b = TestUtils.getSegment2(0, 1, 1, 1);

        assertFalse(isSegments2Intersects(a, b));
        assertFalse(isSegments2Intersects(b, a));
    }

    @Test
    public void test3() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 1, 1);
        Segment2<Float64> b = TestUtils.getSegment2(0, 1, 1, 0);

        assertTrue(isSegments2Intersects(a, b));
        assertTrue(isSegments2Intersects(b, a));
    }

    @Test
    public void test4() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 1, 1);
        Segment2<Float64> b = TestUtils.getSegment2(2, 2, 3, 3);

        assertFalse(isSegments2Intersects(a, b));
        assertFalse(isSegments2Intersects(b, a));
    }

    @Test
    public void test5() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 2, 2);
        Segment2<Float64> b = TestUtils.getSegment2(1, 1, 3, 3);

        assertTrue(isSegments2Intersects(a, b));
        assertTrue(isSegments2Intersects(b, a));
    }

    @Test
    public void test6() {
        Segment2<Float64> a = TestUtils.getSegment2(0, 0, 2, 2);
        Segment2<Float64> b = TestUtils.getSegment2(0, 1, 1, 1);

        assertTrue(isSegments2Intersects(a, b));
        assertTrue(isSegments2Intersects(b, a));
    }


}
