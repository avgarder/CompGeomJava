package ru.ifmo.garder.compgeom;

import org.jscience.mathematics.number.Float64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.ifmo.garder.compgeom.primitives.Contour2;
import ru.ifmo.garder.compgeom.primitives.Point2;

import java.util.List;

import static org.junit.Assert.*;
import static ru.ifmo.garder.compgeom.ConvexHull.buildGrahamHull;
import static ru.ifmo.garder.compgeom.TestUtils.*;
/**
 * Created by: avgarder
 */
@RunWith(JUnit4.class)
public class TestGrahamHull {
    private Contour2<Float64> c;

    @Test
    public void test1() {
        c = getContour2(getPoint2(0, 0), getPoint2(1, 0), getPoint2(0, 1),
                getPoint2(2, 0), getPoint2(0, 2), getPoint2(3, 0));
        c = buildGrahamHull(c);
        assertTrue(checkConvexHull(c));
    }

    @Test
    public void test2() {
        List<Point2<Float64>> points = getRandPoints((int) 1e6);
        c = buildGrahamHull(points);
        assertTrue(checkConvexHull(c));
    }
}
