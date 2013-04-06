package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Contour2;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.Operations.*;
import static ru.ifmo.garder.compgeom.TestUtils.*;

@RunWith(JUnit4.class)
public class TestContour2Orientation {
    private Contour2<Float64> c;


    @Test
    public void testClockWise() {
        c = getContour2(getPoint2(0, 0), getPoint2(0, 3), getPoint2(2, 5), getPoint2(3, 2));
        assertEquals(ContourOrientation.CLOCKWISE, contourOrientation(c));
    }

    @Test
    public void testCounterClockWise() {
        c = getContour2(getPoint2(0, 0), getPoint2(3, 2), getPoint2(2, 5), getPoint2(0, 3));
        assertEquals(ContourOrientation.COUNTERCLOCKWISE, contourOrientation(c));
    }
}
